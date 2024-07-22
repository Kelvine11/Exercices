package org.example.exercices.Exercice3.service;

import org.example.exercices.Exercice3.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<Student>();

    public StudentService() {

    }

    public void addStudent(Student student) {
        if (students.isEmpty()) {
            students.add(student);
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(student.getId().equals(students.get(i).getId()));
                if (student.getId().equals(students.get(i).getId())) {
                    students.set(i, student);
                } else students.add(student);

            }
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(UUID id) {
        return (Student) students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Student> getStudentByName(String lastName) {
        return students.stream().filter(s -> s.getLastName().equals(lastName)).toList();
    }

    public void deleteStudentById(UUID id) {
        students.removeIf(s -> s.getId().equals(id));
    }


}
