package com.clone.reddit.service;

import com.clone.reddit.model.User;

import java.util.Collection;

public interface UserService {
    User create(User user);
    Collection<User> list();
}