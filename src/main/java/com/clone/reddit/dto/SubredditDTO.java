package com.clone.reddit.dto;

import com.clone.reddit.model.Flare;
import com.clone.reddit.model.Subreddit;
import com.clone.reddit.model.SubredditRule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubredditDTO {

    private String subredditName;
    private List<SubredditRuleDTO> subredditRuleDTOList;
    private List<FlareDTO> flareDTOS;

}
