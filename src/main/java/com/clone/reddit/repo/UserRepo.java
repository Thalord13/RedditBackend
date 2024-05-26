package com.clone.reddit.repo;

import com.clone.reddit.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserAccount, Long> {
}
