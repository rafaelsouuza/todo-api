package io.github.rafaelsouuza.todo.repositories;

import io.github.rafaelsouuza.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRespositoy extends JpaRepository<Todo, Integer> {

    @Query("SELECT obj FROM Todo obj WHERE obj.finalizado = false ORDER BY obj.dataParaFinalizar")
    List<Todo> findAllOpen();

    @Query("SELECT obj FROM Todo obj WHERE obj.finalizado = true ORDER BY obj.dataParaFinalizar")
    List<Todo> findAllClose();
}
