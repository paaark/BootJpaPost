package com.example.demo.common.message.form;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageForm {

    private String message;

    @Builder
    private MessageForm(String message){
        this.message = message;
    }

}
