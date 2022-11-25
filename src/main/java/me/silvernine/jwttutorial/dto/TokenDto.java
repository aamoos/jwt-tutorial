package me.silvernine.jwttutorial.dto;

import lombok.*;

/**
 * packageName    : me.silvernine.jwttutorial.dto
 * fileName       : TokenDto
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
public class TokenDto {

    private String token;
}
