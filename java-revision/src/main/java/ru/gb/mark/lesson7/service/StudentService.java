package ru.gb.mark.lesson7.service;


import ru.gb.mark.lesson7.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> getStudentById(Long id);

    List<Student> getAllStudents();

    void deleteStudentById(Long id);

    void saveOrUpdateStudent(Student student);

}
