package io.github.rafaelsouuza.todo.resources;

import io.github.rafaelsouuza.todo.entities.Todo;
import io.github.rafaelsouuza.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoResource {

    @Autowired
    private TodoService todoService;

    @GetMapping("/open")
    public ResponseEntity<List<Todo>> findAllOpen() {
        List<Todo> list = todoService.findAllOpen();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/close")
    public ResponseEntity<List<Todo>> findAllClose() {
        List<Todo> list = todoService.findAllClose();
        return ResponseEntity.ok().body(list);
    }
}
