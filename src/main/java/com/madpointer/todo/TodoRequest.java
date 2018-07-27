package com.madpointer.todo;

import org.hibernate.validator.constraints.NotEmpty;

public class TodoRequest {

    @NotEmpty
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

