package com.clone.reddit.service;

import com.clone.reddit.dto.SubredditDTO;
import com.clone.reddit.model.Subreddit;

import java.util.Collection;

public interface SubredditService {

    SubredditDTO create(String header, SubredditDTO subreddit);
    Collection<Subreddit> list(int limit);
    Subreddit get(Long id);
    Subreddit update(Subreddit server);
    Boolean delete(Long id);

}
