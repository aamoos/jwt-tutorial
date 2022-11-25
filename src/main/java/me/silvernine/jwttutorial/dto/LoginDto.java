package me.silvernine.jwttutorial.dto;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * packageName    : me.silvernine.jwttutorial.dto
 * fileName       : LoginDto
 * author         : 김재성
 * date           : 2022-11-25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-11-25        김재성       최초 생성
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;

}
