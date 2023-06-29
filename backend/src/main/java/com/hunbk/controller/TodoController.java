package com.hunbk.controller;

import com.hunbk.dto.request.TodoCheckRequest;
import com.hunbk.dto.request.TodoRequest;
import com.hunbk.dto.response.TodosResponse;
import com.hunbk.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<TodosResponse> findAll() {
        return ResponseEntity.ok().body(todoService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TodoRequest todoRequest) {
        todoService.create(todoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity todoCheck(@PathVariable Long id,
                                    @RequestBody TodoCheckRequest todoCheckRequest) {
        todoService.todoCheck(id, todoCheckRequest);
        return ResponseEntity.ok().build();
    }

}
