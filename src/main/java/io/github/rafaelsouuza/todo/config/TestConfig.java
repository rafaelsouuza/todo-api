package io.github.rafaelsouuza.todo.config;

import io.github.rafaelsouuza.todo.entities.Todo;
import io.github.rafaelsouuza.todo.repositories.TodoRespositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TodoRespositoy todoRespositoy;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2", LocalDateTime.parse("25/03/2022 10:40", formatter), false);
        Todo t2 = new Todo(null, "Correr", "Praticar excercícios Físico", LocalDateTime.parse("26/03/2022 10:40", formatter), true);
        Todo t3 = new Todo(null, "Ler", "Ler um livro", LocalDateTime.parse("21/03/2022 10:40", formatter), false);
        Todo t4 = new Todo(null, "Meditar", "Meditar durante 30 minutos pela manhã", LocalDateTime.parse("27/03/2022 10:40", formatter), true);

        todoRespositoy.saveAll(Arrays.asList(t1, t2, t3, t4));
    }
}
