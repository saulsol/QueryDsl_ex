package com.example.querydsl_ex.service;

import com.example.querydsl_ex.constant.BookType;
import com.example.querydsl_ex.dto.BookAndAuthorDto;
import com.example.querydsl_ex.dto.BookDto;
import com.example.querydsl_ex.dto.BookTypeDto;
import com.example.querydsl_ex.dto.CreateBookDto;
import com.example.querydsl_ex.entity.Author;
import com.example.querydsl_ex.entity.Book;
import com.example.querydsl_ex.entity.QBook;
import com.example.querydsl_ex.repository.AuthorRepository;
import com.example.querydsl_ex.repository.BookRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public String createBook(CreateBookDto createBookDto) {
        Author findAuthor = authorRepository
                .findById(1L).get();
        Book book = Book.toEntity(createBookDto, findAuthor);

        bookRepository.save(book);
        return "책이 생성되었습니다.";
    }

    public List<BookDto> findByBookType(BookTypeDto bookTypeDto) {
        QBook book = QBook.book;

        JPAQuery<Book> query = jpaQueryFactory.selectFrom(book);
        if (bookTypeDto.getBookType().equals(BookType.HARD)) {
            query.where(book.bookType.eq(BookType.HARD));
        } else if (bookTypeDto.getBookType().equals(BookType.SOFT)) {
            query.where(book.bookType.eq(BookType.SOFT));
        }

        List<Book> bookList = query.fetch();
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book findBook : bookList) {
            BookDto bookDto = new BookDto();
            bookDto.setBookName(findBook.getBookName());
            bookDto.setAuthorName(findBook.getAuthor().getName());
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    public BookAndAuthorDto findByBookName(String bookName){
//        Book findBook = bookRepository.findByBookName(bookName).get();
//        return BookAndAuthorDto.builder()
//                .bookName(findBook.getBookName())
//                .bookType(findBook.getBookType())
//                .authorName(findBook.getAuthor().getName())
//                .authorEmail(findBook.getAuthor().getEmail())
//                .build();
        return bookRepository.findByBookNameDto(bookName);
    }

}
