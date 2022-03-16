package io.github.rafaelsouuza.todo.service;

import io.github.rafaelsouuza.todo.entities.Todo;
import io.github.rafaelsouuza.todo.repositories.TodoRespositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRespositoy todoRespositoy;

    public List<Todo> findAllOpen() {
        List<Todo> list = todoRespositoy.findAllOpen();
        return list;
    }

    public List<Todo> findAllClose() {
        List<Todo> list = todoRespositoy.findAllClose();
        return list;
    }
}
