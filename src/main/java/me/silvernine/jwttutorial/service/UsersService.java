package me.silvernine.jwttutorial.service;

import lombok.RequiredArgsConstructor;
import me.silvernine.jwttutorial.dto.UsersDto;
import me.silvernine.jwttutorial.entity.Authority;
import me.silvernine.jwttutorial.entity.Users;
import me.silvernine.jwttutorial.repository.UserRepository;
import me.silvernine.jwttutorial.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.Optional;

/**
 * packageName    : me.silvernine.jwttutorial.service
 * fileName       : UserService
 * author         : 김재성
 * date           : 2022-11-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-25        김재성       최초 생성
 */

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Users signup(UsersDto usersDto){
        if(userRepository.findOneWithAuthoritiesByUsername(usersDto.getUsername()).orElse(null) != null){
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Users users = Users.builder()
                .username(usersDto.getUsername())
                .password(passwordEncoder.encode(usersDto.getPassword()))
                .nickname(usersDto.getNickname())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return userRepository.save(users);
    }

    @Transactional(readOnly = true)
    public Optional<Users> getUserWithAuthorities(String username){
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<Users> getMyUserWithAuthorities(){
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }
}
