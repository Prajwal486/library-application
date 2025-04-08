package com.wisdom.Student.Library.App.service;

import com.wisdom.Student.Library.App.CustomUserDetails;
import com.wisdom.Student.Library.App.entity.Student;
import com.wisdom.Student.Library.App.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student= studentRepository.findByUserName(username);
        if (Objects.isNull(student)){
            System.out.println("student not available");
            throw new UsernameNotFoundException("student not found");

        }
       return new CustomUserDetails(student);
    }
}
