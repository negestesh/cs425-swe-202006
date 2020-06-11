package edu.miu.cs.cs425.eregistrar.eregistrarapp.service.impl;

import edu.miu.cs.cs425.eregistrar.eregistrarapp.model.Student;
import edu.miu.cs.cs425.eregistrar.eregistrarapp.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.eregistrarapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchStudents(String searchString) {
        if (containsDecimalPoint(searchString) && isCgpa(searchString)) {
            return studentRepository.findAllByCgpaEquals(Double.parseDouble(searchString));

        } else if (isDate(searchString)) {
            return studentRepository.findAllByEnrollmentDateEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        } else {
            return studentRepository.findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrMiddleNameContainingOrIsInternationalContaining
                    (searchString,
                            searchString,
                            searchString,
                            searchString,
                            searchString);
        }
    }

    private boolean isCgpa(String searchString) {
        boolean isParseableAsCgpa = false;
        try {
            Double.parseDouble(searchString);
            isParseableAsCgpa = true;
        } catch (Exception ex) {
            if (ex instanceof ParseException) {
                isParseableAsCgpa = false;
            }
        }
        return isParseableAsCgpa;
    }

    private boolean isDate(String searchString) {
        boolean isParseableAsDate = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            isParseableAsDate = true;
        } catch (Exception ex) {
            if (ex instanceof DateTimeParseException) {
                isParseableAsDate = false;
            }
        }
        return isParseableAsDate;
    }

    private boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }
}
