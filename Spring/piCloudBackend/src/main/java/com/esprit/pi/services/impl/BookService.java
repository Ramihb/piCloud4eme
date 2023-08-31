package com.esprit.pi.services.impl;

import com.esprit.pi.dto.Bookdto;
import com.esprit.pi.entities.BookEntity;
import com.esprit.pi.repositories.BookRepository;
import com.esprit.pi.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Bookdto> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        return convertEntitiesToDtos(bookEntities);
    }

    @Override
    public Bookdto getBookById(int bookId) {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            BookEntity bookEntity = optionalBook.get();
            return convertEntityToDto(bookEntity);
        } else {
            return null;
        }
    }

    @Override
    public Bookdto addBook(Bookdto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setBookName(bookDto.getBookName());
        bookEntity.setBookDescription(bookDto.getBookDescription());
        bookEntity.setBookPDF(bookDto.getBookPDF());
        bookEntity.setFeedback(bookDto.getFeedback());
        bookEntity.setRating(bookDto.getRating());


        BookEntity savedEntity = bookRepository.save(bookEntity);
        return convertEntityToDto(savedEntity);

    }

    @Override
    public Bookdto updateBook(int bookId, Bookdto updatedBook) {
        Optional<BookEntity> optionalBook = bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            BookEntity existingBook = optionalBook.get();
            // Update the existing book's information using data from updatedBook
            existingBook.setBookName(updatedBook.getBookName());
            existingBook.setBookDescription(updatedBook.getBookDescription());
            existingBook.setBookPDF(updatedBook.getBookPDF());
            existingBook.setRating(updatedBook.getRating());
            existingBook.setFeedback(updatedBook.getFeedback());

            BookEntity updatedEntity = bookRepository.save(existingBook);
            return convertEntityToDto(updatedEntity);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteBookById(int bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        } else {
            return false;
        }
    }

    private Bookdto convertEntityToDto(BookEntity bookEntity) {
        Bookdto bookDto = new Bookdto();
        bookDto.setBookId(bookEntity.getBookId());
        bookDto.setBookName(bookEntity.getBookName());
        bookDto.setBookDescription(bookEntity.getBookDescription());
        bookDto.setBookPDF(bookEntity.getBookPDF());
        bookDto.setFeedback(bookEntity.getFeedback());
        bookDto.setRating(bookEntity.getRating());
        return bookDto;
    }

    private List<Bookdto> convertEntitiesToDtos(List<BookEntity> bookEntities) {
        List<Bookdto> bookDtos = new ArrayList<>();
        for (BookEntity entity : bookEntities) {
            bookDtos.add(convertEntityToDto(entity));
        }
        return bookDtos;
    }

}