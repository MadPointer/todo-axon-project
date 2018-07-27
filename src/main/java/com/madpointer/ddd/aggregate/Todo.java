package com.madpointer.ddd.aggregate;

import com.madpointer.ddd.command.TodoCreateCommand;
import com.madpointer.ddd.event.TodoCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Todo {

    @AggregateIdentifier
    private String todoId;

    public Todo() {
    }

    @CommandHandler
    public Todo(TodoCreateCommand command) {
        apply(new TodoCreatedEvent(command.getTodoId(), command.getDescription()));
    }

    @EventSourcingHandler
    protected void on(TodoCreatedEvent event) {
        this.todoId = event.getId();
    }

}
