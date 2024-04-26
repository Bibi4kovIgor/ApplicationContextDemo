package edu.lemon.appcontextbasedbeanconfig;

import edu.lemon.aspects.annotation.LogExecutionTime;

public class HelloWorld {
    private final String message;
    private final Greetings greeting;

    public HelloWorld(String message, Greetings greetings) {
        this.message = message;
        this.greeting = greetings;
    }

    @LogExecutionTime
    public String greet() throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            stringBuilder.append(message).append(greeting.getName()).append(i);
            Thread.sleep(100);
        }
        return stringBuilder.toString();
    }

}
