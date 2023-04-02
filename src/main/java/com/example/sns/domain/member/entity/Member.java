package com.example.sns.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Member {

    //id,email,birthDay는 한번 선언되고나면 변경되면 안되기 때문에 final을 한다.
    //entity는 private
    final private Long id;
    //nickname은 변경 가능하기에 final으로 하지 않는다.
    //객체 안에서만 관리가 되어야, 변경 사항이 생기거나 코드 양이 많아 졌을 때, side effect를 확인하기 쉽다.
    private String nickname;
    //이메일
    final private String email;
    //생일
    final private LocalDate birthday;
    //생성일
    final private LocalDateTime createdAt;
    //최대 길이
    final private static Long NAME_MAX_LENGTH = 10L;


//입력할 때, 필드끼리의 의존성이 없고 다 입력 받아야 하는 값이기에 다 Setter로 불러왔다.
    @Builder
    public Member(Long id, String nickname, String email, LocalDate birthday, LocalDateTime createdAt) {
        this.id = id;
        this.email = Objects.requireNonNull(email);
        this.birthday = Objects.requireNonNull(birthday);
        validateNickname(nickname);
        this.nickname = Objects.requireNonNull(nickname);
        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }

    //변경하는 함수니,void로 반환하지 않는다.
    //String으로 변경할 닉네임을 받는다.
    public void changeNickname(String to) {
        //닉변이 null이면 안되기 때문에, 체크 해준다.
        Objects.requireNonNull(to);
        //10글자 초과 안되게 하는거
        validateNickname(to);
    //nickname에 to를 넣어준다.
        nickname = to;

    }



    private void validateNickname(String nickname) {
        //검증, 닉네임의 길이 검증 하고 있다.
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과 했습니다.");
        }
    }

