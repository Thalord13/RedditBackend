package com.clone.reddit.service;

import com.clone.reddit.dto.FlareDTO;
import com.clone.reddit.dto.SubredditDTO;
import com.clone.reddit.dto.SubredditRuleDTO;
import com.clone.reddit.model.Flare;
import com.clone.reddit.model.Subreddit;
import com.clone.reddit.model.SubredditRule;

import java.util.Collection;
import java.util.List;

public interface SubredditService {

    SubredditDTO create(String header, SubredditDTO subreddit);
    Collection<Subreddit> list(int limit);
    Subreddit get(Long id);
    SubredditDTO update(String header, Long id,  SubredditDTO subredditDTO);
    Boolean delete(Long id);

}
