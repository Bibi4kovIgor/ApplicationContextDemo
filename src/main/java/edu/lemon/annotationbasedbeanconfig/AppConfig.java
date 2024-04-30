package edu.lemon.annotationbasedbeanconfig;

import edu.lemon.aspects.LogExecutionTimeAspect;
import edu.lemon.model.Greetings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public Greetings greetings(){
        return new Greetings("Ihor");
    }

    @Bean
    public HelloWorld helloWorld() {
        String message = "Hello, ";
        return new HelloWorld(message, greetings());
    }

    @Bean
    public LogExecutionTimeAspect logExecutionTimeAspect(){
        return new LogExecutionTimeAspect();
    }

}
