package com.example.demo.business.post.application;

import com.example.demo.business.post.entity.Post;
import com.example.demo.common.error.code.ErrorCode;
import com.example.demo.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRespository postRespository;

    @Transactional
    public List<Post> findAll(){
        return postRespository.findAll();
    }

    @Transactional
    public Post findById(Long id){
        return postRespository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_POST));
    }

    @Transactional
    public Post add(Post post){
        return postRespository.save(post);
    }

    @Transactional
    public void modify(Long id, Post post){
        postRespository.modify(id, post);
    }

}
