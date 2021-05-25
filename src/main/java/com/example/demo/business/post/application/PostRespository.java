package com.example.demo.business.post.application;

import com.example.demo.business.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRespository extends JpaRepository<Post, Long> {

    List<Post> findAll(Post post);

    Optional<Post> findById(Long id);

    @Query("update post p set p.title = :title and p.content = :content where p.id = id")
    int modify(Long id, Post post);

}
