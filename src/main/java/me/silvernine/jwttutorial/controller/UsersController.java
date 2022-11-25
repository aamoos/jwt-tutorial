package me.silvernine.jwttutorial.controller;

import lombok.RequiredArgsConstructor;
import me.silvernine.jwttutorial.dto.UsersDto;
import me.silvernine.jwttutorial.entity.Users;
import me.silvernine.jwttutorial.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * packageName    : me.silvernine.jwttutorial.controller
 * fileName       : UserController
 * author         : 김재성
 * date           : 2022-11-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-25        김재성       최초 생성
 */

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/signup")
    public ResponseEntity<Users> signup(@Valid @RequestBody UsersDto usersDto){
        return ResponseEntity.ok(usersService.signup(usersDto));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Users> getMyUserInfo(){
        return ResponseEntity.ok(usersService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Users> getUserInfo(@PathVariable String username){
        return ResponseEntity.ok(usersService.getUserWithAuthorities(username).get());
    }

}
