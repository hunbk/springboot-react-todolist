package com.hunbk.dto.response;

import com.hunbk.domain.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class TodosResponse {
    private List<TodoResponse> todos;

    public TodosResponse(List<TodoResponse> todos) {
        this.todos = todos;
    }

    public static TodosResponse from(List<Todo> todos) {
        return new TodosResponse(
                todos.stream()
                        .map(TodoResponse::from)
                        .collect(Collectors.toList())
        );
    }
}
