package tran.todd.bookapi.api.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tran.todd.bookapi.api.v1.dao.BookDAO;
import tran.todd.bookapi.api.v1.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public Long save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    @Transactional
    public Book get(Long id) {
        return bookDAO.get(id);
    }

    @Override
    @Transactional
    public List<Book> list() {
        return bookDAO.list();
    }

    @Override
    @Transactional
    public void update(Long id, Book book) {
        bookDAO.update(id, book);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookDAO.delete(id);
    }
}
