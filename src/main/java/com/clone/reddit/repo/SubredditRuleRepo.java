package com.clone.reddit.repo;

import com.clone.reddit.model.SubredditRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubredditRuleRepo extends JpaRepository<SubredditRule, Long> {
}
