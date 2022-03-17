package io.github.rafaelsouuza.todo.resources;

import io.github.rafaelsouuza.todo.dtos.TodoDto;
import io.github.rafaelsouuza.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<TodoDto> findById(@PathVariable Integer id) {
        TodoDto obj = todoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TodoDto> insert(@RequestBody @Valid TodoDto dto) {
        TodoDto objDto = todoService.insert(dto);
        URI uri = ServletUriComponentsBuilder // Inseri um cabeçalho Location contendo o endereço do novo recurso inserido
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(objDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(objDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
