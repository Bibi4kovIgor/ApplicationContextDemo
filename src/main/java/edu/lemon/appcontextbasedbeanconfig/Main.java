package edu.lemon.appcontextbasedbeanconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application_context.xml");
        HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWorld.greet());


    }
}