package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 JpaRepository - это некий интерфейс, который с помощью сложной реализации
 с использованием Reflection API способна генерировать для нас запросы.
 Кроме того, что здесь есть стандартный набор методов, мы так же можем писать и свои запросы

 */

public interface UserRepository extends JpaRepository<User, Long> {
}
