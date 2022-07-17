package com.eby.employeemanager.repo;

import com.eby.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Employee, Long>
// Employee is the type of the entity that being managed
// and long is the type of the Id field (primary key)
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
