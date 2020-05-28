package edu.mum.cs.cs425.demos.studentrecorsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {
        Student [] students = {
                new Student(110001,"Dave", LocalDate.of(1951,11,18)),
                new Student(110002,"Anna", LocalDate.of(1990,12,7)),
                new Student(110003,"Erica", LocalDate.of(1974,1,31)),
                new Student(110004,"Carlos", LocalDate.of(2009,8,22)),
                new Student(110005,"Bob", LocalDate.of(1990,3,5)),
        };
        System.out.println("#################-List of Students Information-#################\n");
        printListOfStudents(students);
        System.out.println("#################-List of Platinum Alumni Students-#################\n");
        getListOfPlatinumAlumniStudents(students);
        System.out.println("##########################");


    }
    public static void printListOfStudents(Student [] students){
        Arrays.stream(students).sorted(Comparator.comparing(Student::getName)).forEach(Student::printString);
    }
    public static void getListOfPlatinumAlumniStudents(Student [] students){
        Arrays.stream(students).filter(student -> student.getDateOfAdmission().getYear()<=1990)
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed()).forEach(Student::printString);
    }
}
