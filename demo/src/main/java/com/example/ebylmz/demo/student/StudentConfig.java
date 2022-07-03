package com.example.ebylmz.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return  args -> {
            Student helin = new Student(
                    "Helin",
                    "helin@gmail.com",
                    LocalDate.of(2004, Month.AUGUST, 5));

            Student rabia = new Student(
                    "Rabia",
                    "rabia@gmail.com",
                    LocalDate.of(2000, Month.FEBRUARY, 27));

            repository.saveAll(List.of(helin, rabia));
        };
    }
}
