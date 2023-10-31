package net.javaexample.springboot.controller;

import net.javaexample.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Jason",
                "Pis-an"
        );
        return student;
    }
}
