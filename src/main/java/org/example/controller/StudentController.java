package org.example.controller;

import org.example.dto.FacultyDtoOut;
import org.example.dto.StudentDtoIn;
import org.example.dto.StudentDtoOut;
import org.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentDtoOut create(@RequestBody StudentDtoIn studentDtoIn) {
        return service.create(studentDtoIn);
    }

    @GetMapping("/{id}")
    public StudentDtoOut get(@PathVariable long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public StudentDtoOut update(@PathVariable long id,
                                @RequestBody StudentDtoIn studentDtoIn) {
        return service.update(id, studentDtoIn);
    }

    @DeleteMapping("/{id}")
    public StudentDtoOut delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/{age}/students")
    public Collection<StudentDtoOut> findAll(@PathVariable(required = false) int age) {
        return service.findAll(age);
    }

    @GetMapping("/filter")
    public Collection<StudentDtoOut> findStudentsByAgeBetween(@RequestParam int from,
                                                              @RequestParam int to) {
        return service.findStudentsByAgeBetween(from, to);
    }

    @GetMapping("/{id}/faculty")
    public FacultyDtoOut findStudentsFaculty(@PathVariable Long id) {
        return service.findStudentsFaculty(id);
    }
}