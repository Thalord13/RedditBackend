package com.clone.reddit.repo;

import com.clone.reddit.model.Flare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlareRepo extends JpaRepository<Flare, Long> {

    List<Flare> findBySubredditId(Long subredditId);

}
