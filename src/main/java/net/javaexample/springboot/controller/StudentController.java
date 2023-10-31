package net.javaexample.springboot.controller;

import net.javaexample.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Jace",
                "Pis-an"
        );
        return student;
    }

    @GetMapping("all-student")
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Jason", "Pis-an"));
        students.add(new Student(2, "Jade", "Pis-an"));
        students.add(new Student(3, "Dee", "Ocampo"));
        students.add(new Student(4, "Burrito", "Pis-an"));

        return students;
    }

    // Springboot REST API with Path Variable
    // {id} - URI template variable
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
}
