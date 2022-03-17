package io.github.rafaelsouuza.todo.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVerisoUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado. Id " + id);
    }
}
