package net.proselyte.springbootdemo.controller;

import net.proselyte.springbootdemo.model.User;
import net.proselyte.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    // при переходе по ссылке /users в моем приложении я буду реализовывать функционал,
    // который пропишу в данном методе
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        // model добавь в себя аттрибут под названием users (тот, что у нас указан на странице html)
        // и в переменную user положи результат данного запроса
        // то есть я получил всех юзеров из БД и запихнул их в этот users
        model.addAttribute("users",users);
        // здесь мы должны вернуть строку
        // это будет путь к html-файлу, в котором будет прописана вся логика

        // user-list - означает, что когда я перейду по ссылке в /users
        // я выполню эту логику, а потом верну этот users
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        // просим userService сохранить user-а
        userService.saveUser(user);
        // после этого переадресуй меня на страницу /users
        return "redirect:/users";
    }

    // так как мы будем переходить на какую-то страницу
    // именно поэтому ставим метод get
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        // мне нужно получить user-a, который равен userService.findById(id)
        // по id, который я передал получаю пользователя
        User user = userService.findById(id);
        // после этого я в model добавляю атрибут
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        // метод saveUser в репозитории сам определяет
        // обновление или создание новой сущности
        userService.saveUser(user);
        return "redirect:/users";
    }
}
