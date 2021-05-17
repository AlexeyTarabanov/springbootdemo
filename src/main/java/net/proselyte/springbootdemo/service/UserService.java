package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 это будет некая оболочка, в которой мы будем принимать запросы из внешнего мира (потом реализуем ее)
 и будем дергать репозиторные методы

 1/ далее описываем функционал, который мы хотели бы получить,
 Например.
 Я бы хотел уметь {получать User-a по id} {сохранять пользователя} {и т.д.}

 2/ для того, чтобы я мог изменить эти данные в базе данных,
 мне необходим репозиторий
 private UserRepository userRepository


 */

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // получать User-a по id
    public User findById(Long id) {

        // хочу вернуть результат выполнения метода getOne
        return userRepository.getOne(id);
    }

    // получать список всех User-oв, которые у меня есть
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // сохранять пользователя
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // удалять User-a по id
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
