package com.example.sns.domain.member;

import com.example.sns.domain.member.entity.Member;
import com.example.sns.util.MemberFixtureFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MemberTest {
    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    @Test
public void testChangeName() {
      var member = MemberFixtureFactory.create();
      var expected = "taeyoung";
      member.changeNickname(expected);

        Assertions.assertEquals(expected, member.getNickname());
 }
    @DisplayName("회원의 닉네임은 10자를 초과할 수 없다.")
    @Test
    public void testNicknameMaxLength() {
        var member = MemberFixtureFactory.create();
        var  overMaxLengthName = "taeyoungtaeyoung";

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> member.changeNickname(overMaxLengthName));



    }
}
