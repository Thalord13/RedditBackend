package com.clone.reddit.service;

import com.clone.reddit.model.AuthenticationResponse;
import com.clone.reddit.model.UserAccount;

import java.util.Collection;

public interface UserService {
    AuthenticationResponse register(UserAccount user);
    Collection<UserAccount> list();
}