package io.github.rafaelsouuza.todo.service;

import io.github.rafaelsouuza.todo.dtos.TodoDto;
import io.github.rafaelsouuza.todo.entities.Todo;
import io.github.rafaelsouuza.todo.repositories.TodoRespositoy;
import io.github.rafaelsouuza.todo.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRespositoy todoRespositoy;

    public List<TodoDto> findAllOpen() {
        List<Todo> list = todoRespositoy.findAllOpen();
        return list.stream().map(x -> new TodoDto(x)).collect(Collectors.toList());
    }

    public List<TodoDto> findAllClose() {
        List<Todo> list = todoRespositoy.findAllClose();
        return list.stream().map(x -> new TodoDto(x)).collect(Collectors.toList());
    }

    public List<TodoDto> findAll() {
        List<Todo> list = todoRespositoy.findAll();
        return list.stream().map(x -> new TodoDto(x)).collect(Collectors.toList());
    }

    public Todo findById(Integer id) {
        Optional<Todo> obj = todoRespositoy.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Todo insert(Todo obj) {
        return todoRespositoy.save(obj);
    }
}
