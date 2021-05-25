package com.example.demo.business.member.form;

import com.example.demo.business.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class MemberForm {

    public static class Request{

        @Getter
        @Setter
        @NoArgsConstructor
        public static class SignUp{
            @NotBlank(message = "이메일을 입력해주세요.")
            private String email;

            @NotBlank(message = "비밀번호를 입력해주세요.")
            private String password;

            public Member SignUp(){
                return Member.builder()
                        .email(email)
                        .password(password)
                        .build();
            }

        }

    }

    public static class Response{

    }

}
