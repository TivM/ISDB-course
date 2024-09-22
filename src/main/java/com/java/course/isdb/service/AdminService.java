package com.java.course.isdb.service;


import com.java.course.isdb.entity.Admin;

import java.util.List;

public interface AdminService {

    Admin add(String name, int age, String division);

    List<Admin> getAll();

    Admin getById(int id);

    void deleteById(int id);

    Admin updateById(int id, String name, int age, String division);
}
