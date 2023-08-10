package com.arima.javareactaws.prepostannotations;

import com.arima.javareactaws.BusinessCalculationService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependencyClass someDependencyClass;

    public SomeClass(SomeDependencyClass someDependencyClass) {
        super();
        this.someDependencyClass = someDependencyClass;
        System.out.println("All dependencies are ready");
    }

    @PostConstruct
    public void initialize() {
        someDependencyClass.getReady();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("cleanup");
    }
}

@Component
class SomeDependencyClass {

    public void getReady() {
        System.out.println("Using some dependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(PrePostAnnotationLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
