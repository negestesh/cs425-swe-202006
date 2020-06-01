package edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp;

import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class MystudentmgmtappApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void run(String... args) throws Exception {
        Transcript trans1 = new Transcript("BS Computer Science");
        Transcript trans2 = new Transcript("BS Computer Science");
        Classroom classroom = new Classroom("McLaughling Building", "M105" );


        Student student = new Student("0000-61-0001", "Anna", "Merilyn", "Bob", 3.75, LocalDate.of(2019,12,28), trans1,classroom);
        trans1.setStudent(student);
        Student student1 = new Student("0000-61-0002", "Dylan", "Glen", "Harper", 3.50, LocalDate.of(2020,2,1), trans2, classroom);
        trans2.setStudent(student1);
        classroom.setStudents(Arrays.asList(student,student1));
        Student savedStudent = saveStudent(student);
        System.out.println(savedStudent.toString());

    }
    public static void main(String[] args) {
        SpringApplication.run(MystudentmgmtappApplication.class, args);
    }

    private Student saveStudent(Student student){
        return studentRepository.save(student);

    }

}
