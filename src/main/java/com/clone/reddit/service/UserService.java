package com.clone.reddit.service;

import com.clone.reddit.model.UserAccount;

import java.util.Collection;

public interface UserService {
    UserAccount create(UserAccount user);
    Collection<UserAccount> list();
}