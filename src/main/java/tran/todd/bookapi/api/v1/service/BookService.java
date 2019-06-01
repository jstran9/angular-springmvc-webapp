package tran.todd.bookapi.api.v1.service;

import tran.todd.bookapi.api.v1.model.Book;

import java.util.List;

public interface BookService {
    // Save the record
    Long save(Book book);

    // get a single record
    Book get(Long id);

    // get all the records
    List<Book> list();

    // update the record
    void update(Long id, Book book);

    // delete a record
    void delete(Long id);
}
