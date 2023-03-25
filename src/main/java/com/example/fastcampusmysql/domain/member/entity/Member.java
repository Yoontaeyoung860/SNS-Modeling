package com.example.fastcampusmysql.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Member {
    //id,email,birthDay는 한번 선언되고나면 바뀌면 안되기 때문에 final
    final private Long id;
    private String nickname;
    final private String email;

    final private LocalDate birthday;

    final private LocalDateTime createdAt;

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
//검증
    void validateNickname(String nickname){
        Assert.isTrue(nickname.length() <= NAME_MAX_LENGTH, "최대 길이를 초과 했습니다.");

    }
}
