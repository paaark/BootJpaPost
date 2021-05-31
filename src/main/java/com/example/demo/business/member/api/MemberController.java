package com.example.demo.business.member.api;

import com.example.demo.business.member.application.MemberService;
import com.example.demo.business.member.entity.Member;
import com.example.demo.business.member.form.MemberForm;
import com.example.demo.common.message.form.MessageForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    private static final int INVALID_EMAIL = 1;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody MemberForm.Request.add signUp){
        int chkEmail = memberService.findEmail(signUp.getEmail());

        Member member = memberService.SignUp(signUp.toEntity());

        HttpHeaders headers = new HttpHeaders();

        if(chkEmail == INVALID_EMAIL)
            return new ResponseEntity<MessageForm>(getMessage("중복입니다."), headers, HttpStatus.BAD_REQUEST);
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    private MessageForm getMessage(String getMessage){
        MessageForm message = MessageForm.builder().message(getMessage).build();
        return message;
    }

}
