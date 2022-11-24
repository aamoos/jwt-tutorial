package me.silvernine.jwttutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName    : me.silvernine.jwttutorial.controller
 * fileName       : HelloController
 * author         : 김재성
 * date           : 2022-11-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-24        김재성       최초 생성
 */

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pwd = "1234";
        return ResponseEntity.ok(passwordEncoder.encode(pwd));
    }
}
