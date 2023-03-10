package ru.gb.mark.lesson5.service;

import ru.gb.mark.lesson5.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> getById(Long id);

    void removeById(Long id);

    void remove(Student student);

    List<Student> getAll();

    void saveOrUpdate(Student student);

    void saveAll(List<Student> students);

}
