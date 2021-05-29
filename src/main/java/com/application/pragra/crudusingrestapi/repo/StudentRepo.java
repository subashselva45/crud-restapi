package com.application.pragra.crudusingrestapi.repo;

import com.application.pragra.crudusingrestapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

    //@Query(value = "select * from student where name =?",nativeQuery = true)
    Student findByName( String name);
    List<Student> findAllByName(String name);
    List<Student> findAllByAgeOrderById(Integer id);
}
