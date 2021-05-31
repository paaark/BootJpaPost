package com.example.demo.business.post.api;

import com.example.demo.business.post.application.PostService;
import com.example.demo.business.post.entity.Post;
import com.example.demo.business.post.form.PostForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/post/{id}")
    public ResponseEntity<?> FindById(@PathVariable Long id){
        Post FindById = postService.FindById(id);
        return ResponseEntity.status(HttpStatus.OK).body(FindById);
    }

    @PostMapping("/post")
    public ResponseEntity<?> AddPost(@Valid @RequestBody PostForm.Request.add addPost){
        Post Add = postService.AddPost(addPost.add());

        return ResponseEntity.status(HttpStatus.CREATED).body(addPost);
    }

    @PatchMapping("/post/{id}")
    public ResponseEntity<?> Modify(@PathVariable Long id, @RequestBody PostForm.Request.modify modify){
        return ResponseEntity.status(HttpStatus.OK).body(Modify(id, modify));
    }

}
