package io.github.rafaelsouuza.todo.repositories;

import io.github.rafaelsouuza.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRespositoy extends JpaRepository<Todo, Integer> {
}
