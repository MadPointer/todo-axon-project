package com.madpointer.ddd.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class TodoCreateCommand {
    @TargetAggregateIdentifier
    private String todoId;
    private String description;

    public TodoCreateCommand(String todoId, String description) {
        this.todoId = todoId;
        this.description = description;
    }

    public String getTodoId() {
        return todoId;
    }

    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
