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
    public Long save(Book book) {
        return null;
    }

    @Override
    public Book get(Long id) {
        return null;
    }

    @Override
    @Transactional
    public List<Book> list() {
        return bookDAO.list();
    }

    @Override
    public void update(Long id, Book book) {

    }

    @Override
    public void delete(Long id) {

    }
}
