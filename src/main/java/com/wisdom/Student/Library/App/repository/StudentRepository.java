package com.wisdom.Student.Library.App.repository;

import com.wisdom.Student.Library.App.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByUserName(String UserName);
}
