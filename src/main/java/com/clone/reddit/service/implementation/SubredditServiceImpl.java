package com.clone.reddit.service.implementation;

import com.clone.reddit.config.JwtService;
import com.clone.reddit.dto.FlareDTO;
import com.clone.reddit.dto.SubredditDTO;
import com.clone.reddit.dto.SubredditRuleDTO;
import com.clone.reddit.model.Flare;
import com.clone.reddit.model.Subreddit;
import com.clone.reddit.model.SubredditRule;
import com.clone.reddit.model.UserAccount;
import com.clone.reddit.repo.FlareRepo;
import com.clone.reddit.repo.SubredditRepo;
import com.clone.reddit.repo.SubredditRuleRepo;
import com.clone.reddit.repo.UserRepo;
import com.clone.reddit.service.SubredditService;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class SubredditServiceImpl implements SubredditService {

    private final SubredditRepo subredditRepo;
    private final SubredditRuleRepo subredditRuleRepo;
    private final FlareRepo flareRepo;
    private final UserRepo userRepo;
    private final JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtTokenProvider;

    @Override
    public SubredditDTO create(String header, SubredditDTO subredditDto) {

        String token = extractToken(header);
        String username = jwtService.extractUsername(token);

        UserAccount userAccount = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));;

        Subreddit subreddit = new Subreddit();

        subreddit.setSubredditName(subredditDto.getSubredditName());
        subreddit.setUserAccount(userAccount);
        subredditRepo.save(subreddit);

        if (subredditDto.getSubredditRuleDTOList() != null) {
            for (SubredditRuleDTO ruleDTO : subredditDto.getSubredditRuleDTOList()) {
                SubredditRule rule = new SubredditRule();
                rule.setRule(ruleDTO.getRule());
                rule.setSubreddit(subreddit);
                subredditRuleRepo.save(rule);
            }
        }

        if (subredditDto.getFlareDTOS() != null) {
            for (FlareDTO flareDTO : subredditDto.getFlareDTOS()) {
                Flare flare = new Flare();
                flare.setFlare(flareDTO.getFlare());
                flare.setSubreddit(subreddit); // Set FK using generated subredditId
                flareRepo.save(flare);
            }
        }

        return subredditDto;
    }

    @Override
    public Collection<Subreddit> list(int limit) {
        return null;
    }

    @Override
    public Subreddit get(Long id) {
        return null;
    }

    @Override
    public Subreddit update(Subreddit server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private String extractToken(String header)
    {
        if(header != null && header.startsWith("Bearer "))
        {
            return header.substring(7);
        }
        return null;
    }

}
