package com.example.demo.business.member.application;

import com.example.demo.business.member.entity.Member;
import com.example.demo.common.error.code.ErrorCode;
import com.example.demo.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRespository memberRespository;

    @Transactional
    public Member SignUp(Member member){
        return memberRespository.save(member);
    }

    public int findEmail(String email){
        return memberRespository.findEmail(email);
    }

}
