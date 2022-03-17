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

    public TodoDto findById(Integer id) {
        Optional<Todo> obj = todoRespositoy.findById(id);
        obj.orElseThrow(() -> new ResourceNotFoundException(id));
        return new TodoDto(obj.get());
    }

    public TodoDto insert(TodoDto dto) {
        Todo obj = new Todo();
        copyToDtoToEntity(dto, obj);
        todoRespositoy.save(obj);
        return new TodoDto(obj);
    }

    public void delete(Integer id) {
        Optional<Todo> obj = todoRespositoy.findById(id);
        obj.orElseThrow(() -> new ResourceNotFoundException(id));
        todoRespositoy.deleteById(id);
    }

    public TodoDto update(Integer id, TodoDto dto) {
        Optional<Todo> obj = todoRespositoy.findById(id);
        obj.orElseThrow(() -> new ResourceNotFoundException(id));
        copyToDtoToEntity(dto, obj.get());
        Todo newObj = todoRespositoy.save(obj.get());
        return new TodoDto(newObj);
    }

    private void copyToDtoToEntity(TodoDto dto, Todo entity) {
        entity.setTitulo(dto.getTitulo());
        entity.setDescricao(dto.getDescricao());
        entity.setDataParaFinalizar(dto.getDataParaFinalizar());
        entity.setFinalizado(dto.getFinalizado());
    }
}
