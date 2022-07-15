package com.example.ebylmz.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/register")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/delete/{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentID) {
        studentService.deleteStudent(studentID);
    }

    // PUT http://localhost:8080/student/1?name=Maria
    // PUT http://localhost:8080/student/1?name=Maria&email=maria@gmail.com
    @PutMapping(path = "update/{studentID}")
    public void updateStudent(
            @PathVariable("studentID") Long studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentID, name, email);
    }
}
