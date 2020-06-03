package edu.miu.cs.cs425.eregistrar.eregistrarapp.repository;

import edu.miu.cs.cs425.eregistrar.eregistrarapp.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findAllByStudentNumberContainingOrFirstNameContainingOrLastNameContainingOrMiddleNameContainingOrIsInternationalContaining
            (String studentNumber,
             String firstName,
             String lastName,
             String middleName,
             String isInternational);
    List<Student> findAllByCgpaEquals(Double cgpa);
    List<Student> findAllByEnrollmentDateEquals(LocalDate enrollmentDate);
}
