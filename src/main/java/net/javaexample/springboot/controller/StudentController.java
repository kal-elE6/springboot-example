package net.javaexample.springboot.controller;

import net.javaexample.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Jace",
                "Pis-an"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "jason")
                .body(student);
    }
//    without responseEntity
//    public Student getStudent() {
//        Student student = new Student(
//                1,
//                "Jace",
//                "Pis-an"
//        );
//        return student;
//    }

    // Springboot returns List
    @GetMapping("all-student")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Jason", "Pis-an"));
        students.add(new Student(2, "Jade", "Pis-an"));
        students.add(new Student(3, "Dee", "Ocampo"));
        students.add(new Student(4, "Burrito", "Pis-an"));

        return ResponseEntity.ok(students);
    }

    // Springboot REST API with Path Variable
    // {id} - URI template variable
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Springboot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Jason&lastName=Pis-an
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // Springboot REST API that handles HTTP POST Request - creating new resource
    //@PostMapping and @RequestBody
    @PostMapping("create")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Springboot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return ResponseEntity.ok(student);
    }

    // Springboot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
