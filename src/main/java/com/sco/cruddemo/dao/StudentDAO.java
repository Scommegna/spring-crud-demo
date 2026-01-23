package com.sco.cruddemo.dao;

import com.sco.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
