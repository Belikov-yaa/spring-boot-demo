package ru.geekbrains.springbootdemo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.springbootdemo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUserName(String username);
}
