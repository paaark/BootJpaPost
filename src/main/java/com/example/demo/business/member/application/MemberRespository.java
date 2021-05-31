package com.example.demo.business.member.application;

import com.example.demo.business.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRespository extends JpaRepository<Member, Long> {

    @Query("select cound(*) from member where email = :email")
    int findByEmail(String email);

}
