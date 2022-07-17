package com.eby.employeemanager;

import com.eby.employeemanager.model.Employee;
import com.eby.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @GetMapping is shortcut @RequestMapping(method = RequestMethod.GET)

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private EmployeeService employeeService;


    // @Autowired is needed?
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee e = employeeService.findEmployee(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
        Employee newEmployee = employeeService.addEmployee(e);
        if (newEmployee == null)
            return  new ResponseEntity<>(newEmployee, HttpStatus.BAD_REQUEST);
        else
            return  new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {
        Employee updateEmployee = employeeService.updateEmployee(e);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
