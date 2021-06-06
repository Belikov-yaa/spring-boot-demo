package ru.geekbrains.springbootdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.geekbrains.springbootdemo.enities.Product;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ProductsDAO {
    private SessionFactory factory;
    private Session session;

    public ProductsDAO() {
    }

    @PostConstruct
    public void init() {
        factory = new Configuration()
//                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        session = factory.getCurrentSession();
    }

    public Product findById(Long id) {
        session = factory.getCurrentSession();
        session.beginTransaction();
        Product productFromDB = session.get(Product.class, id);
        session.getTransaction().commit();
        return productFromDB;
    }

    public List<Product> findAll() {
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT i FROM Product i", Product.class).getResultList();
        session.getTransaction().commit();
        return products;
    }

    public void deleteById(Long id) {
        session.beginTransaction();
        Product productFromDB = session.get(Product.class, id);
        session.remove(productFromDB);
        session.getTransaction().commit();
    }

    public Product save(Product product) {
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        return product;
    }

    public Product update(Product product) {
        session.beginTransaction();
        Product productFromDB = session.get(Product.class, product.getId());
        if (productFromDB != null) {
            productFromDB.setPrice(product.getPrice());
            productFromDB.setTitle(product.getTitle());
            session.save(product);
            session.getTransaction().commit();
        }
        return product;
    }
}
