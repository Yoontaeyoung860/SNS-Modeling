package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//회원정보 등록
//조회와 쓰기를 분리하는 것이 굉장히 중요하기에 read,write 분리.
@RequiredArgsConstructor
@Service
public class MemberWriteService {
   final private MemberRepository memberRepository;
    public Member create(RegisterMemberCommand command) //매개변수에 dto RegisterMemberCommand를 가져온다.
     {
        /*
           목표 - 회원정보(이메일, 닉네임, 생년월일)을 등록한다. 닉네임은 10자를 넘길 수 없다.
           파라미터 - memberRegisterCommand  - DTO에서 만든다.DTO니까, RECODE를 활용한다.
           회원 객체 - val member = Member.of(memberRegisterCommand)
           memberRepository.save(member)
         */
         var member = Member.builder()
                 .nickname(command.nickname())
                 .email(command.email())
                 .birthday(command.birthday())
                 .build();
        return memberRepository.save(member);
    }
}
