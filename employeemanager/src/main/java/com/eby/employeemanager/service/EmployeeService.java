package com.eby.employeemanager.service;

import com.eby.employeemanager.exception.UserNotFoundException;
import com.eby.employeemanager.model.Employee;
import com.eby.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee e) {
        e.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(e);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee e) {
        return employeeRepo.save(e);
    }

    public Employee findEmployee(Long id) {
        return employeeRepo.findById(id).orElseThrow(
                () -> new UserNotFoundException("User by " + id + " was not found")
        );
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

}
