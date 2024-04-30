package edu.lemon.appcontextbasedbeanconfig;

import edu.lemon.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application_context.xml");
      Person personA = applicationContext.getBean("personSingleton", Person.class);
      Person personB = applicationContext.getBean("personSingleton", Person.class);

      personA.setName("Ihor");
      personB.setAge(32);

      assert (!personA.equals(personB));

      Person personC = applicationContext.getBean("personPrototype", Person.class);
      Person personD = applicationContext.getBean("personPrototype", Person.class);

      personC.setName("Ihor");
      personD.setAge(32);

      assert (personC.equals(personD));

        HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWorld.greet());




    }
}