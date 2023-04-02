package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Member {
<<<<<<< HEAD
    //id,email,birthDay는 한번 선언되고나면 변경되면 안되기 때문에 final을 한다.
    //entity는 private
    final private Long id;
    //nickname은 변경 가능하기에 final으로 하지 않는다.
    private String nickname;
    final private String email;
    final private LocalDate birthday;
    final private LocalDateTime createdAt;
    final private static Long NAME_MAX_LENGTH = 10L;

    //입력할 때, 필드끼리의 의존성이 없고 다 입력 받아야 하는 값이기에 다 Setter로 불러왔다.
=======
    //id,email,birthDay는 한번 선언되고나면 바뀌면 안되기 때문에 final
    final private Long id;
    private String nickname;
    final private String email;

    final private LocalDate birthday;

    final private LocalDateTime createdAt;

    final private static Long NAME_MAX_LENGTH = 10L;

//입력할 때, 필드끼리의 의존성이 없고 다 입력 받아야 하는 값이기에 다 Setter로 불러왔다.
>>>>>>> 4cc0908d1841e642e3036904c0f5fe2859a3e020
    @Builder
    public Member(Long id, String nickname, String email, LocalDate birthday, LocalDateTime createdAt) {
        this.id = id;
        this.email = Objects.requireNonNull(email);
        this.birthday = Objects.requireNonNull(birthday);
        validateNickname(nickname);
        this.nickname = Objects.requireNonNull(nickname);

        this.createdAt = createdAt == null ? LocalDateTime.now() : createdAt;
    }
<<<<<<< HEAD
    //검증
    void validateNickname(String nickname) {
=======
//검증
    void validateNickname(String nickname){
>>>>>>> 4cc0908d1841e642e3036904c0f5fe2859a3e020
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과 했습니다.");

    }
}
