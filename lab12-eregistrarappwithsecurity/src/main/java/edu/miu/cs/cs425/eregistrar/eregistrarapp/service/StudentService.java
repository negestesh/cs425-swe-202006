package edu.miu.cs.cs425.eregistrar.eregistrarapp.service;

import edu.miu.cs.cs425.eregistrar.eregistrarapp.model.Student;

import java.util.List;

public interface StudentService {
    Iterable<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Integer studentId);
    void deleteStudentById(Integer studentId);
    List<Student> searchStudents(String searchString);
}
