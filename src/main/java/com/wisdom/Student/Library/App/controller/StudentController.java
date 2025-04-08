package com.wisdom.Student.Library.App.controller;

import com.wisdom.Student.Library.App.entity.Student;
import com.wisdom.Student.Library.App.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

     @GetMapping
    public ResponseEntity<List<Student>>getStudent(){
        List<Student>students=studentService.getStudent();
        if (students.isEmpty()){
            return ResponseEntity.noContent().build();
        }
      return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Optional<Student>student=studentService.findById(id);
        if (student.isPresent()){
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping("/register")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
         Student createdStudent=studentService.createStudent(student);
         return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){
         Student updatedStudent=studentService.updateStudent( id,student);
         if (updatedStudent==null){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
         studentService.deleteStudent(id);
         return ResponseEntity.noContent().build();
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/login")
    public String login(@RequestBody Student student){
         return studentService.verify(student);
    }

}
