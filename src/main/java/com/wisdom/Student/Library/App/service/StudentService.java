package com.wisdom.Student.Library.App.service;

import com.wisdom.Student.Library.App.entity.Student;
import com.wisdom.Student.Library.App.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        student.setPassword(bCryptPasswordEncoder
                .encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        if (!studentRepository.existsById(id)) {
            return null;
        }
        student.setStudentId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("student not found with this ID:" + id);
        }
        studentRepository.deleteById(id);
    }

    public String verify(Student student) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        student.getUserName(), student.getPassword()
                )
        );
       // Student students= studentRepository.findByUserName(student.getUserName());
        if (authenticate.isAuthenticated()) {
        return jwtService.generateToken(student);
        }
        return "Failure";
    }
}