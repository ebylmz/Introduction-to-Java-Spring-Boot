package com.example.ebylmz.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        // make sure that the emails are unique
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent())
            throw new IllegalStateException("email already in use");
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentID) {
        if (! studentRepository.existsById(studentID))
            throw new IllegalStateException("student with id " + studentID + " does not exist");
        studentRepository.deleteById(studentID);
    }

    @Transactional
    public void updateStudent(Long studentID, String name, String email) {
        // make sure the student with given id is exist
        Student student = studentRepository.findById(studentID)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id " + studentID + " does not exist"
                ));

        // set the name
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
            student.setName(name);
        // set the email
        if (email != null && email.length() > 0 && !Objects.equals(student.getName(), name)) {
            // make sure that emails are unique
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if (studentByEmail.isPresent())
                    throw new IllegalStateException("email already in use");
            student.setEmail(email);
        }
     }
}
