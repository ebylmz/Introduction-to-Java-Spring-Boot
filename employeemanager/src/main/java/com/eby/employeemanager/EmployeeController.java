package com.eby.employeemanager;

import com.eby.employeemanager.model.Employee;
import com.eby.employeemanager.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @GetMapping is shortcut @RequestMapping(method = RequestMethod.GET)
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // @Autowired is needed?
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        logger.info("Employees list fetched successfully.");
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee e = employeeService.findEmployee(id);
        logger.info("Employee: {} is fetched successfully.", id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
        Employee newEmployee = employeeService.addEmployee(e);
        logger.info("Employee: {} is saved", e.getName());
        return  new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e) {
        Employee updateEmployee = employeeService.updateEmployee(e);
        logger.info("Employee: {} is updated.", e.getName());
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        logger.info("Employee: {} is deleted.", id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
