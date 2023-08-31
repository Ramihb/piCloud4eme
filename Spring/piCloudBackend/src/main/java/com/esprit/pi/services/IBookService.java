package com.esprit.pi.services;

import com.esprit.pi.dto.Bookdto;

import java.util.List;

public interface IBookService {
    List<Bookdto> getAllBooks();

    public Bookdto addBook(Bookdto book);

    public Bookdto getBookById(int bookId);

    public boolean deleteBookById(int bookId);

    public Bookdto updateBook(int bookId, Bookdto updatedBook);

}
