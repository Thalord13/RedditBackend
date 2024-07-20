package com.clone.reddit.repo;

import com.clone.reddit.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubredditRepo extends JpaRepository<Subreddit, Long> {
}
