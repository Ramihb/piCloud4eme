package com.esprit.pi.controllers;

import com.esprit.pi.dto.Bookdto;
import com.esprit.pi.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {

        return ResponseEntity.ok("File uploaded successfully.");
    }

 

    @PostMapping
public ResponseEntity<Bookdto> addBook(
        @RequestParam("file") MultipartFile file,
        @ModelAttribute Bookdto book) {
    try {
        String fileName = file.getOriginalFilename();
        String filePath = "C:\\Users\\Ghassen\\Desktop\\piCloud4eme\\Spring\\piCloudBackend\\uploads"
                + File.separator + fileName;
        file.transferTo(new File(filePath));
        book.setBookPDF(filePath);

     
        
        // Now, 'book' object contains other fields as well
        
        // Call your bookService to add the book and return a response
        Bookdto addedBook = bookService.addBook(book);
        return ResponseEntity.ok(addedBook);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
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
