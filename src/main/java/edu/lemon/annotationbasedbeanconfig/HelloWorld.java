package edu.lemon.annotationbasedbeanconfig;

import edu.lemon.aspects.annotation.LogExecutionTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HelloWorld {

    private final String message;

    private final Greetings greeting;

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
