package com.arima.javareactaws;

import com.arima.javareactaws.game.GameRunner;
import com.arima.javareactaws.game.GamingConsole;
import com.arima.javareactaws.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
