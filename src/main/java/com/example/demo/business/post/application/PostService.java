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
    public List<Post> FindAll(){
        return postRespository.findAll();
    }

    @Transactional
    public Post FindById(Long id){
        return postRespository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));
    }

    @Transactional
    public Post AddPost(Post post){
        return postRespository.save(post);
    }

    @Transactional
    public void Modify(Long id, Post post){
        postRespository.modify(id, post);
    }

}
