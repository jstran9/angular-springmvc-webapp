package tran.todd.bookapi.api.v1.dao;

import tran.todd.bookapi.api.v1.model.Book;

import java.util.List;

public interface BookDao {

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
