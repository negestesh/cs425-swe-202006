package edu.miu.cs.cs425.eregistrar.eregistrarapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotBlank(message = "Student Number is required")
    @Column(name = "studentNumber", nullable = false, unique = true)
    private String studentNumber;

    @NotBlank(message = "First Name is required")
    @Column(name = "firstName", nullable = false)
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last Name is required")
    @Column(name = "lastName", nullable = false)
    private String lastName;

    private Double cgpa;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private LocalDate enrollmentDate;

    @NotBlank(message = "International status is required")
    @Column(name = "isInternational", nullable = false)
    private String isInternational;


    public Student() {
    }

    public Student(@NotBlank String studentNumber, @NotBlank String firstName, String middleName, @NotBlank String lastName, Double cgpa, @NotBlank LocalDate enrollmentDate, @NotBlank String isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(String isInternational) {
        this.isInternational = isInternational;
    }

    @Override
    public String toString() {
        return String.format(
                "Student [studentNumber=%s, firstName=%s, middleName=%s, lastName=%s, cgpa=%s, enrollmentDate=%s, isInternational=%s]",
                this.studentNumber,
                this.firstName,
                this.middleName,
                this.lastName,
                this.cgpa,
                this.enrollmentDate,
                this.isInternational);
    }
}
