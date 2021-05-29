package com.application.pragra.crudusingrestapi.controller;

import com.application.pragra.crudusingrestapi.entity.Student;
import com.application.pragra.crudusingrestapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping(value = "/save",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Student saveStudent(@RequestBody Student student){
        return service.createStudent(student);
    }

    @PostMapping("/saveAll")
    public List<Student> saveAllStudents(@RequestBody List<Student> student){
        return service.createListOfStudents(student);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return service.getAllStudents();
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return service.getStudentById(id);
    }

    @GetMapping("/getName/{name}")
    public Student getStudentByName(@PathVariable String name){
        return service.getStudentByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        return service.deleteById(id);
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return  service.updateStudent(student);
    }
}
