package io.github.rafaelsouuza.todo.config;

import io.github.rafaelsouuza.todo.repositories.TodoRespositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TodoRespositoy todoRespositoy;

    @Override
    public void run(String... args) throws Exception {

    }
}
