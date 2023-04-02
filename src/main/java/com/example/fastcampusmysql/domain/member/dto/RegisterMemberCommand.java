package com.example.fastcampusmysql.domain.member.dto;

import java.time.LocalDate;

<<<<<<< HEAD
//DTO RECODE를 활용한다. java16부터 공식 도입됨.recode는 클래스가 아니다.
=======
//DTO RECODE를 활용한다. java16부터 도입됨.recode는 클래스가 아니다.
>>>>>>> 4cc0908d1841e642e3036904c0f5fe2859a3e020
//recode를 선언하게 되면 Getter Setter를 자동으로 만들어주고, 프로퍼티 형식으로 쓸 수 있다. .email 같이..
//이메일, 닉네임, 생년월일
public record RegisterMemberCommand(
    String email,
    String nickname,
    LocalDate birthday
)
 {



        }
