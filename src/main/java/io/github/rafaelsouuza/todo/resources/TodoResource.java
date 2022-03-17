package io.github.rafaelsouuza.todo.resources;

import io.github.rafaelsouuza.todo.dtos.TodoDto;
import io.github.rafaelsouuza.todo.entities.Todo;
import io.github.rafaelsouuza.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoResource {

    @Autowired
    private TodoService todoService;

    @GetMapping("/open")
    public ResponseEntity<List<TodoDto>> findAllOpen() {
        List<TodoDto> list = todoService.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/close")
    public ResponseEntity<List<TodoDto>> findAllClose() {
        List<TodoDto> list = todoService.findAllClose();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> findAll() {
        List<TodoDto> list = todoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Integer id) {
        Todo obj = todoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
