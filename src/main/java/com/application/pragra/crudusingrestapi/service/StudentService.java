package com.application.pragra.crudusingrestapi.service;

import com.application.pragra.crudusingrestapi.entity.Student;
import com.application.pragra.crudusingrestapi.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public Student createStudent(Student student){
        return  repo.save(student);
    }

    public List<Student > createListOfStudents(List<Student> students){
        List<Student> list = repo.saveAll(students);
        return list;
    }

    public Student getStudentById(Integer id){
        return repo.findById(id).orElse(null);
    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    public Student getStudentByName(String name){
        return repo.findByName(name);
    }

    public List<Student> getAllStudentByName(String name){
        return repo.findAllByName(name);
    }

    public List<Student> getAllStudentByAgeOrderById(Integer id){
        return repo.findAllByAgeOrderById(id);
    }

    public String deleteById(Integer id){
        repo.deleteById(id);
        return "deleted id"+" "+ id;
    }
    public Student updateStudent(Student student){
        Student st = repo.findById(student.getId()).orElse(null);
        st.setAge(student.getAge());
        st.setCity(student.getCity());
        st.setName(student.getName());
        return repo.save(st);

    }

}
