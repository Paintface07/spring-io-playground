package org.kondrak.batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 1/22/2016.
 */
@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {

//        ApplicationContext ctx = new AnnotationConfigApplicationContext(BatchConfig.class);
        SpringApplication.run(Main.class, args);
        System.out.println("************* DONE *************");
    }

    @Override
    public void run(String... strings) {
        System.out.println("running...");
    }
}
