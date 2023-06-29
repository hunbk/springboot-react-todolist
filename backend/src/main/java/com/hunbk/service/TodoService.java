package com.hunbk.service;

import com.hunbk.domain.Todo;
import com.hunbk.dto.request.TodoCheckRequest;
import com.hunbk.dto.request.TodoRequest;
import com.hunbk.dto.response.TodosResponse;
import com.hunbk.repository.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {

    private final TodoMapper todoMapper;

    public TodosResponse findAll() {
        List<Todo> todos = todoMapper.findAll();
        return TodosResponse.from(todos);
    }

    public void create(TodoRequest todoRequest) {
        todoMapper.create(todoRequest);
    }

    public void delete(Long id) {
        todoMapper.delete(id);
    }

    public void todoCheck(Long id, TodoCheckRequest todoCheckRequest) {
        todoMapper.todoCheck(id, todoCheckRequest.getIsCheck());
    }
}
