package com.madpointer.ddd.aggregate;

import com.madpointer.ddd.command.TodoCreateCommand;
import com.madpointer.ddd.event.TodoCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Before;
import org.junit.Test;

public class TodoTest {
    private AggregateTestFixture<Todo> testFixture;

    @Before
    public void setUp() throws Exception {
        testFixture = new AggregateTestFixture<>(Todo.class);
    }

    @Test
    public void testCreateTodoTask(){
        testFixture.givenNoPriorActivity()
                   .when(new TodoCreateCommand("123321", "description"))
                   .expectEvents(new TodoCreatedEvent("123321", "description"));
    }
}
