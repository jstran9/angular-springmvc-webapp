package tran.todd.bookapi.api.v1.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tran.todd.bookapi.api.v1.model.Book;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long save(Book book) {
        sessionFactory.getCurrentSession().save(book);
        return book.getId();
    }

    @Override
    public Book get(Long id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    public List<Book> list() {
        return sessionFactory.getCurrentSession().createQuery("from Book").list();

    }

    @Override
    public void update(Long id, Book book) {

    }

    @Override
    public void delete(Long id) {

    }
}
