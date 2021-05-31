package com.example.demo.business.post.form;

import javax.validation.constraints.NotBlank;

import com.example.demo.business.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class PostForm {

    public static class Request{

        @Getter
        @Setter
        @NoArgsConstructor
        public static class add{
            @NotBlank(message = "제목을 입력해주세요.")
            private String title;

            @NotBlank(message = "내용을 입력해주세요.")
            private String content;

            public Post toEntity(){
                return Post.builder()
                        .title(title)
                        .content(content)
                        .build();
            }

        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class modify{
            @NotBlank(message = "제목을 입력해주세요.")
            private String title;

            @NotBlank(message = "내용을 입력해주세요.")
            private String content;

            public Post toEntity(){
                return Post.builder()
                        .title(title)
                        .content(content)
                        .build();
            }

        }

    }

    public static class Response{

        @Getter
        @Setter
        public static class findAll {
            private String title;
            private String content;

            private findAll(String title, String content){
                this.title = title;
                this.content = content;
            }
        }


        @Getter
        @Setter
        public static class findById {
            private Long id;
            private String title;
            private String content;

            private findById(Long id,String title, String content){
                this.id = id;
                this.title = title;
                this.content = content;
            }
        }

    }

}
