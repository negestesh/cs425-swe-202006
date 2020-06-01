package edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;



@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "Student Number is Required")
    @Column(name = "studentNumber", nullable = false)
    private String studentNumber;

    @NotBlank(message = "Student First Name is Required")
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "middleName", nullable = true)
    private String middleName;//optional

    @NotBlank(message = "Student Last Name is Required")
    @Column(name = "lastName", nullable = false)
    private String LastName;

    @Column(name = "cgpa", nullable = true)
    private Double cgpa;//optional

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEnrollment;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "transcript_Id")
    private Transcript transcript;


    @ManyToOne
    @JoinColumn(name = "class_room")
    private Classroom classroom;

    public Student(String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment, Transcript transcript, Classroom classroom) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.LastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;
        this.classroom = classroom;
    }


    public Student() {
        super();
    }

    public Student(Long studentId, String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        LastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
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
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return String.format(
                "Student [studentId=%s, studentNumber=%s, firstName=%s, middleName=%s, LastName=%s, cgpa=%s, dateOfEnrollment=%s]",
                this.studentId,
                this.studentNumber,
                this.firstName,
                this.middleName,
                this.LastName,
                this.cgpa,
                this.dateOfEnrollment);
    }
}
