package edu.lemon.annotationbasedbeanconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        System.out.println(helloWorld.greet());
    }
}