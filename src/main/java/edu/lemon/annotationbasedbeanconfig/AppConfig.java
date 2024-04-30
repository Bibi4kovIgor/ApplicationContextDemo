package edu.lemon.annotationbasedbeanconfig;

import edu.lemon.aspects.LogExecutionTimeAspect;
import edu.lemon.model.Greetings;
import edu.lemon.model.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
  @Bean
  public Greetings greetings() {
    return new Greetings("Ihor");
  }

  @Bean
  public HelloWorld helloWorld() {
    String message = "Hello, ";
    return new HelloWorld(message, greetings());
  }

  @Bean
  public LogExecutionTimeAspect logExecutionTimeAspect() {
    return new LogExecutionTimeAspect();
  }

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public Person personSingleton(){
    return Person.builder().build();
  }

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  public Person personPrototype(){
    return Person.builder().build();
  }
}
