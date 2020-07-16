package br.com.marcellogpassos.cnjapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CnjApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CnjApiApplication.class, args);
    }
}
