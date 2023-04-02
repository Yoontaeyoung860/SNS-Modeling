package com.example.sns.controller;


import com.example.sns.domain.member.dto.MemberDto;
import com.example.sns.domain.member.dto.RegisterMemberCommand;
import com.example.sns.domain.member.entity.Member;
import com.example.sns.domain.member.service.MemberReadService;
import com.example.sns.domain.member.service.MemberWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class MemberController {
   final private MemberWriteService memberWriteService;
   final private MemberReadService memberReadService;

   @PostMapping("/members")
   //유저가 입력할 정보를 받는다.
   public MemberDto register(@RequestBody RegisterMemberCommand command) {
      var member = memberWriteService.create(command);
      return memberReadService.toDto(member);
   }
   @GetMapping("/members/{id}")
   public MemberDto getMember(@PathVariable Long id) {
      return memberReadService.getMemeber(id);
   }
   //Mapping Loginc

}
