package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u left join fetch u.roles where u.username=:username")//todo: если прописывать запрос заглавными, например, SELECT - IDE подсвечивает (распознает) строку как SQL-запрос
    //todo: необычное решение.. можем? обойтись без прописывания запроса @Query Попробуй, затрать пож.на это время
    User findByUsername(String username);
}