package pl.dorshop.shop.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.dorshop.shop.model.User;
import pl.dorshop.shop.model.UserType;
import pl.dorshop.shop.service.UserService;

import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("/users/random")
    public void addRandomUser(){
        User user = User.builder()
                .userType(UserType.ADMIN)
                .password(RandomString.make(15))
                .address(RandomString.make(20))
                .lastName(RandomString.make(20))
                .firstName(RandomString.make(20))
                .phone("513-431-241")
                .email(RandomString.make(10)+"@gmail.com")
                .build();
        userService.addUser(user);
    }

    @GetMapping("/users/{page}/{sort}")
    public Page<User> getUsersWithSorting(@PathVariable int page, @PathVariable Sort.Direction sort) {
        return userService.getUsersWithSorting(page, sort);
    }

    @GetMapping("/users/{id}")
    public User getSingleUser(@PathVariable long id) {
        return userService.getSingleUser(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
        } catch (DataIntegrityViolationException e) {
            log.info("User with that mail already exist");
        }
    }

//    @GetMapping("/users/search/{login}/{password}")
//    public User getUserByLoginAndPassword(@PathVariable String login, @PathVariable String password){
//        return userService.getUserByLoginAndPassword(login, password);
//    }
}
