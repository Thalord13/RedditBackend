package com.clone.reddit.service.implementation;

import com.clone.reddit.model.User;
import com.clone.reddit.repo.UserRepo;
import com.clone.reddit.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User create(User user) {
        log.info("Saving new user: {}", user.getDisplayname());
        return userRepo.save(user);
    }

    @Override
    public Collection<User> list() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
