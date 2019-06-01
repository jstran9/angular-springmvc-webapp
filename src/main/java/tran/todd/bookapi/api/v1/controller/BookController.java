package tran.todd.bookapi.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tran.todd.bookapi.api.v1.model.Book;
import tran.todd.bookapi.api.v1.service.BookService;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // Get all the books
    @GetMapping("/api/books")
    public ResponseEntity<List<Book>> list() {
        /*
         * note: the ResponseEntity is not our return type. Instead of we will create a custom class and add
         * our custom properties (response code, response message, and response object).
         */
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }
}
