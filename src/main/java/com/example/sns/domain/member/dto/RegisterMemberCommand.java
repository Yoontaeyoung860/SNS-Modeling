package com.example.sns.domain.member.dto;

import java.time.LocalDate;

//DTO RECODE를 활용한다. java16부터 공식 도입됨.recode는 클래스가 아니다.
//recode를 선언하게 되면 Getter Setter를 자동으로 만들어주고, 프로퍼티 형식으로 쓸 수 있다. .email 같이..
//이메일, 닉네임, 생년월일.

//단순히 데이터만 담고 있어서 레코드를 사용하기 좋다.
public record RegisterMemberCommand(
    String email,
    String nickname,
    LocalDate birthday
)
 {



        }
