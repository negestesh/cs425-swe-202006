package edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp;

import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model.Student;
import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.mystudentmgmtapp.repository.StudentRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class MystudentmgmtappApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;


    @Override
    public void run(String... args) throws Exception {
        Transcript trans1 = new Transcript("BS Computer Science");
        Transcript trans2 = new Transcript("BS Computer Science");
        Transcript trans3 = new Transcript("BS Accounting");
        Classroom classroom = new Classroom("McLaughling Building", "M105" );
        Classroom classroom1 = new Classroom("Mclaughling Building", "M106");


        Student student = new Student("0000-61-0001", "Anna", "Merilyn", "Bob", 3.75, LocalDate.of(2019,12,28), trans1,classroom);
        trans1.setStudent(student);
        Student student1 = new Student("0000-61-0002", "Dylan", "Glen", "Harper", 3.50, LocalDate.of(2020,2,1), trans2, classroom);
        trans2.setStudent(student1);
        Student student3 = new Student("0000-61-0003", "Alemayoh", "Abrha", "Solomon", 3.80, LocalDate.of(2020,2,2),trans3,classroom1);
        trans3.setStudent(student3);
        classroom.setStudents(Arrays.asList(student,student1));
        classroom1.setStudents(Collections.singletonList(student3));

        Classroom savedClassroom = saveClassroom(classroom);
        Classroom savedClassroom2 = saveClassroom(classroom1);
        System.out.println(savedClassroom.toString());
        System.out.println(savedClassroom2.toString());



//        Student student2 = saveStudent(student3);
//        System.out.println(student2);

    }
    public static void main(String[] args) {
        SpringApplication.run(MystudentmgmtappApplication.class, args);
    }

    private Student saveStudent(Student student){
        return studentRepository.save(student);

    }
    private Classroom saveClassroom(Classroom classroom){
        return classroomRepository.save(classroom);
    }


}
