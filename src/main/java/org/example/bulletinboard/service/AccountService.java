package org.example.bulletinboard.service;

import org.example.bulletinboard.model.User;
import org.example.bulletinboard.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final AccountRepository userRepository;

    @Autowired
    UserService(AccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean login(User user) {
        return userRepository.findById(user.getId())
                .map(findUser -> findUser.getPw().equals(user.getPw()))
                .orElseGet(() -> {
                    save(user); // 빠른 기능 구현을 위해 회원가입 기능 일단은 제외
                    return true;
                });
    }
}
