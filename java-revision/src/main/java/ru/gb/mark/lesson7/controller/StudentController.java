package ru.gb.mark.lesson7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.mark.lesson7.entity.Student;
import ru.gb.mark.lesson7.service.StudentService;

import java.util.Collections;

@Controller
@RequestMapping(path = "/")
public class StudentController {

    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/student")
    String getStudent(@RequestParam(name = "id", required = false) Long id, Model model) {
        model.addAttribute("students", Collections.singletonList(service.getStudentById(id).orElseThrow()));
        return "index";
    }

    @GetMapping("/students")
    String loadAllStudent(Model model) {
        model.addAttribute("students", service.getAllStudents());
        return "index";
    }


    @GetMapping("/student/remove")
    String loadAllStudent(@RequestParam(name = "id") Long id) {
        service.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/student/update")
    String update(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id).orElseThrow());
        return "index";
    }

    @PostMapping("/student/update")
    String update(Student student) {
        service.saveOrUpdateStudent(student);
        return "redirect:/students";
    }

}
