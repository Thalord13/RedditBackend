package com.clone.reddit.repo;

import com.clone.reddit.model.Flare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlareRepo extends JpaRepository<Flare, Long> {
}
