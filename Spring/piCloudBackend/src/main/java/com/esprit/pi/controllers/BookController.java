package com.esprit.pi.controllers;

import com.esprit.pi.dto.Bookdto;
import com.esprit.pi.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Bookdto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Bookdto> getBookById(@PathVariable int bookId) {
        Bookdto book = bookService.getBookById(bookId);

        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            System.out.println(
                    "-------------------------------------------------------------------------------------------");

            return ResponseEntity.notFound().build();
        }
    }

   @PostMapping
    public Bookdto addBook(@RequestBody Bookdto book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Bookdto> updateBook(@PathVariable int bookId, @RequestBody Bookdto updatedBook) {
        Bookdto updated = bookService.updateBook(bookId, updatedBook);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
        boolean deleted = bookService.deleteBookById(bookId);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
