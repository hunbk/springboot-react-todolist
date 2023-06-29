package com.hunbk.dto.response;

import com.hunbk.domain.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TodoResponse {

    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isCheck;

    public TodoResponse(Long id, String content, LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isCheck) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isCheck = isCheck;
    }

    public static TodoResponse from(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getUpdatedAt(),
                todo.getIsCheck()
        );
    }
}
