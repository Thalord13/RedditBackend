package com.clone.reddit.repo;

import com.clone.reddit.model.Flare;
import com.clone.reddit.model.SubredditRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubredditRuleRepo extends JpaRepository<SubredditRule, Long> {

    List<SubredditRule> findBySubredditId(Long subredditId);

}
