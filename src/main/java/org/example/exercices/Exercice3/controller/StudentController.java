package org.example.exercices.Exercice3.controller;

import org.example.exercices.Exercice3.entity.Student;
import org.example.exercices.Exercice3.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/index")
    public String index(@RequestParam(value = "search", required = false) String lastName, Model model) {
        if(lastName != null && !lastName.isEmpty()) {
            model.addAttribute("students", studentService.getStudentByName(lastName));
            System.out.println("totototo");
            return "exercice3/students";
        }else return "exercice3/index";
    }

    @GetMapping("/list")
    public String studentsList(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "exercice3/students";
    }

    @GetMapping("/student/{id}")
    public String student(@PathVariable UUID id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "exercice3/details";
    }

    @GetMapping("/add")
    public String addFrom(Model model) {
        Student student = new Student();
        student.setId(UUID.randomUUID());
        model.addAttribute("student", student);
        return "exercice3/form";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/list";
    }
}
