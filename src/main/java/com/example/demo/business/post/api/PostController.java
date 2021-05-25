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
    public ResponseEntity<?> AddPost(@Valid @RequestBody PostForm.Request.AddPost addPost){
        Post Add = postService.AddPost(addPost.AddPost());

        return ResponseEntity.status(HttpStatus.CREATED).body(Add);
    }

    @PatchMapping("/post/{id}")
    public ResponseEntity<?> Modify(@PathVariable Long id, @RequestBody PostForm.Request.Modify modify){
        return ResponseEntity.status(HttpStatus.OK).body(Modify(id, modify));
    }

}
