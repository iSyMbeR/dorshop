package pl.dorshop.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.dorshop.shop.model.User;
import pl.dorshop.shop.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private static final int PAGE_SIZE = 30;
    private static final String USER_NOT_FOUND = "user with mail: ' %s ' not found";

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Page<User> getUsersWithSorting(int page, Sort.Direction sort) {
        return userRepository.findAll(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id")));
    }

    public User getSingleUser(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserByEmail(String mail) {
        userRepository.deleteUserByEmail(mail)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND,mail)));
    }

//    public User getUserByLoginAndPassword(String login, String password){
//        return userRepository.getByLoginAndPassword(login,password);
//    }

}
