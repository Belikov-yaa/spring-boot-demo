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
    private final SessionFactory factory;
    private Session session;

    public  ProductsDAO() {
        factory = new Configuration()
//                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        session = factory.getCurrentSession();
    }

    public Product findById(Long id) {
        session.beginTransaction();
        Product productFromDB = session.get(Product.class, id);
        session.getTransaction().commit();
        return productFromDB;
    }

    public List<Product> findAll() {
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

    public Product saveOrUpdate(Product product) {
        session.beginTransaction();
        Product productFromDB = session.get(Product.class, product.getId());
        if (productFromDB != null) {
            productFromDB.setPrice(product.getPrice());
            productFromDB.setTitle(product.getTitle());
        } else
            session.save(product);
        session.getTransaction().commit();
        return productFromDB;
    }
}
