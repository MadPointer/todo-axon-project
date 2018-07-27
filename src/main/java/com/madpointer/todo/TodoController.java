package com.madpointer.todo;

import com.madpointer.ddd.command.TodoCreateCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository todoRepository;
    private final CommandGateway commandGateway;

    public TodoController(TodoRepository todoRepository, CommandGateway commandGateway) {
        this.todoRepository = todoRepository;
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public List<Todo> listTodo() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Future<String> createTodo(@RequestBody @Valid TodoRequest todoRequest) {
        Assert.notNull(todoRequest.getDescription(), "description is required and cannot be empty");
        String todoId = UUID.randomUUID().toString();
        return commandGateway.send(new TodoCreateCommand(todoId, todoRequest.getDescription()));
    }

    @EventHandler
    public void on(TodoCreateCommand event) {
        todoRepository.save(new Todo(event.getTodoId(), event.getDescription()));
    }
}
