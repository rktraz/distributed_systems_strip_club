package com.stripclub.user.service;

import com.stripclub.user.repo.UserRepository;
import com.stripclub.user.repo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class UserService {

    private final UserRepository userRepository;

    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    public Long create(String firstname, String lastname, String email, String login, String password, String phoneNumber) throws IllegalArgumentException{

        final User user = new User(firstname,lastname, email, login,password,phoneNumber);
        final User savedUser = userRepository.save(user);
        return savedUser.getId_user();
    }

    public User fetchById(long id) throws IllegalArgumentException{
        final Optional<User> maybeUser = userRepository.findById(id);
        if (maybeUser.isEmpty()) throw new IllegalArgumentException("User not found");
        else return maybeUser.get();
    }
    public void updateUser(long id_user ,String email,String phoneNumber) throws IllegalArgumentException {
        final Optional<User> maybeUser = userRepository.findById(id_user);

        if (maybeUser.isEmpty())
            throw new IllegalArgumentException("Invalid user ID");

        final User user = maybeUser.get();
        if (email != null && !email.isBlank()) user.setEmail(email);
        if (phoneNumber != null && !phoneNumber.isBlank()) user.setPhoneNumber(phoneNumber);
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}