package com.switchfully.jan.order.services;

import com.switchfully.jan.order.instances.Admin;
import com.switchfully.jan.order.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Collection<Admin> getAdmins() {
        return adminRepository.getAdmins();
    }
}
