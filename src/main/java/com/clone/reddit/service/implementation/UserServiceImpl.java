package com.clone.reddit.service.implementation;

import com.clone.reddit.config.JwtService;
import com.clone.reddit.model.AuthenticateRequest;
import com.clone.reddit.model.AuthenticationResponse;
import com.clone.reddit.model.Role;
import com.clone.reddit.model.UserAccount;
import com.clone.reddit.repo.UserRepo;
import com.clone.reddit.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static org.springframework.data.domain.PageRequest.of;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(UserAccount request) {
        var user = UserAccount.builder()
                .username(request.getUsername())
                .displayname(request.getDisplayname())
                .password(passwordEncoder.encode(request.getPassword()))
                .karma("0")
                .role(Role.USER)
                .build();
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticateRequest request) {
// COMMENT FOR NOW
// TO DO TEST TOKEN EXPIRY
        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        var user = userRepo.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public Collection<UserAccount> list() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

}
