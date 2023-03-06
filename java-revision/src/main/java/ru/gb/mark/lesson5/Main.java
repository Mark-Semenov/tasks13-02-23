package ru.gb.mark.lesson5;

import ru.gb.mark.lesson5.entity.Student;
import ru.gb.mark.lesson5.service.StudentService;
import ru.gb.mark.lesson5.service.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentServiceImpl();

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            list.add(new Student().setName("Test"));
        }


        //Save all
        service.saveAll(list);
        service.getAll().forEach(System.out::println);

        //Get by id
        Optional<Student> student = service.getById(2L);
        System.out.println(student.orElseThrow());

        //Change
        student.get().setName("Bob");
        service.saveOrUpdate(student.get());

        System.out.println(service.getById(2L));

        //Remove
        service.removeById(1L);
        Optional<Student> student1 = service.getById(3L);
        service.remove(student1.orElseThrow());

        service.getAll().forEach(System.out::println);

    }
}
