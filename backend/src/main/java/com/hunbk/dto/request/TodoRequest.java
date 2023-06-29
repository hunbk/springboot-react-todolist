package com.hunbk.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class TodoRequest {

    @NotBlank
    private String content;

    public TodoRequest(String content) {
        this.content = content;
    }
}
