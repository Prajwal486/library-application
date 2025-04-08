package com.wisdom.Student.Library.App.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private Long registrationId;
    @Column(nullable = false, unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String qualification;
    private String preparingFor;
    private String healthProblem;
    private Long primaryContactNo;
    private Long secondaryContactNo;
    private String referenceName1;
    private Long referenceContact1;
    private String referenceName2;
    private Long referenceContact2;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPreparingFor() {
        return preparingFor;
    }

    public void setPreparingFor(String preparingFor) {
        this.preparingFor = preparingFor;
    }

    public String getHealthProblem() {
        return healthProblem;
    }

    public void setHealthProblem(String healthProblem) {
        this.healthProblem = healthProblem;
    }

    public Long getPrimaryContactNo() {
        return primaryContactNo;
    }

    public void setPrimaryContactNo(Long primaryContactNo) {
        this.primaryContactNo = primaryContactNo;
    }

    public Long getSecondaryContactNo() {
        return secondaryContactNo;
    }

    public void setSecondaryContactNo(Long secondaryContactNo) {
        this.secondaryContactNo = secondaryContactNo;
    }

    public String getReferenceName1() {
        return referenceName1;
    }

    public void setReferenceName1(String referenceName1) {
        this.referenceName1 = referenceName1;
    }

    public Long getReferenceContact1() {
        return referenceContact1;
    }

    public void setReferenceContact1(Long referenceContact1) {
        this.referenceContact1 = referenceContact1;
    }

    public String getReferenceName2() {
        return referenceName2;
    }

    public void setReferenceName2(String referenceName2) {
        this.referenceName2 = referenceName2;
    }

    public Long getReferenceContact2() {
        return referenceContact2;
    }

    public void setReferenceContact2(Long referenceContact2) {
        this.referenceContact2 = referenceContact2;
    }
}
