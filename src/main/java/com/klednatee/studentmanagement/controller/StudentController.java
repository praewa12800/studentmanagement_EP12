package com.klednatee.studentmanagement.controller;

import com.klednatee.studentmanagement.dto.StudentDto;
import com.klednatee.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudent(Model model) {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/new")
    public String newStudents(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create-students";
    }

    @PostMapping("/students")
    public String saveStudents(@Valid @ModelAttribute("student") StudentDto student,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "create-students";
        }

        studentService.creatstudent(student);
        return "redirect:/students";
    }

    // Edit
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable() Long studentId, Model model) {
        StudentDto student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "edit-student";
    }
}
