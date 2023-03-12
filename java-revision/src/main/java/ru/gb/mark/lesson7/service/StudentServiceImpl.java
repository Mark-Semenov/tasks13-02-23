package ru.gb.mark.lesson7.service;

import org.springframework.stereotype.Service;
import ru.gb.mark.lesson7.entity.Student;
import ru.gb.mark.lesson7.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public void deleteStudentById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public void saveOrUpdateStudent(Student student) {
        repository.save(student);
    }
}
