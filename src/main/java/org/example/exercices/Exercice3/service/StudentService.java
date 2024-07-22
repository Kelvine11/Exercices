package org.example.exercices.Exercice3.service;

import org.example.exercices.Exercice2.entity.Product;
import org.example.exercices.Exercice3.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<Student>();
    private int numberId = 0;

    public StudentService() {

    }

    public void addStudent(Student student) {

        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(UUID id) {
        return (Student) students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Student> getStudentByName(String lastName) {
        return  students.stream().filter(s -> s.getLastName().equals(lastName)).toList();
    }



}
