package com.eby.employeemanager;

import com.eby.employeemanager.model.Employee;
import com.eby.employeemanager.repo.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class EmployeeConfig {
    /*
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepo repo) {
        return args -> {
            Employee[] employees = {
                    new Employee("Jack A. Main", "jack@gmail.com", "Graphics Designer", "000 123-456", "https://bootdey.com/img/Content/avatar/avatar1.png", "3691c8df-f2aa-4cd3-9e1c-6d82f13ce441"),
                    new Employee("Paul L. Goyette", "paul@gmail.com", "Urban Designer", "000 123-456", "https://bootdey.com/img/Content/avatar/avatar6.png", "3691c8df-f2aa-4cd3-9e1c-6d82f13ce442"),
                    new Employee("Jonathan Smith", "jonathan@gmail.com", "Electrical Engineer", "000 123-456", "https://bootdey.com/img/Content/avatar/avatar5.png", "3691c8df-f2aa-4cd3-9e1c-6d82f13ce443"),
                    new Employee("Lily J. Ford", "lily@gmail.com", "Architect", "000 123-456", "https://bootdey.com/img/Content/avatar/avatar3.png", "3691c8df-f2aa-4cd3-9e1c-6d82f13ce444"),
                    new Employee("Mary Jane", "mary@gmail.com", "Architect", "000 123-456", "https://bootdey.com/img/Content/avatar/avatar8.png", "3691c8df-f2aa-4cd3-9e1c-6d82f13ce445")
            };

            repo.saveAll(Arrays.asList(employees));
        };
    }
    */
}
