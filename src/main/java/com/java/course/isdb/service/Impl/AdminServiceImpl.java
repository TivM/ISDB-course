package com.java.course.isdb.service.Impl;

import com.java.course.isdb.entity.Admin;
import com.java.course.isdb.repository.AdminRepository;
import com.java.course.isdb.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;


    @Override
    @Transactional
    public Admin add(String name, int age, String division) {
        Admin admin = new Admin()
                .setName(name)
                .setAge(age)
                .setDivision(division);

        adminRepository.save(admin);

        return admin;
    }
}
