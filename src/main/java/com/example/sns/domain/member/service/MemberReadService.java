package com.example.sns.domain.member.service;

import com.example.sns.domain.member.dto.MemberDto;
import com.example.sns.domain.member.entity.Member;
import com.example.sns.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberReadService {
   final private MemberRepository memberRepository;

   public MemberDto getMemeber(Long id) {
     var member = memberRepository.findById(id).orElseThrow();
return toDto(member);
   }
    public MemberDto toDto(Member member) {
        return new MemberDto(member.getId(),member.getEmail(),member.getNickname(),member.getBirthday());
    }
}
