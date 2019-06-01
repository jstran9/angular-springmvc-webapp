package tran.todd.bookapi.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tran.todd.bookapi.api.v1.model.Book;
import tran.todd.bookapi.api.v1.service.BookService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/")
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all the books
    @GetMapping("books")
    public ResponseEntity<List<Book>> list() {
        /*
         * note: the ResponseEntity is not our return type. Instead of we will create a custom class and add
         * our custom properties (response code, response message, and response object).
         */
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }

    // Save the book
    @PostMapping("book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        Long bookId = bookService.save(book);
        return ResponseEntity.ok().body("Book created with id: " + bookId);
    }

    // Get a single record with id.
    @GetMapping("book/{id}")
    public ResponseEntity<Book> get(@PathVariable Long id) {
        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);
    }

    // update the book record.
    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Book book) {
        bookService.update(id,      book);
        return ResponseEntity.ok().body("Book has been updated with id: " + id);
    }

    // delete a book record
    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<?> delete(@PathVariable Long bookId) {
        bookService.delete(bookId);
        return ResponseEntity.ok().body("Book has been deleted with id: " + bookId);
    }
}
