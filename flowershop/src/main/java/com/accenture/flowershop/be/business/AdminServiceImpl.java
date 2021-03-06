package com.accenture.flowershop.be.business;
import com.accenture.flowershop.be.entity.user.Admin;
import com.accenture.flowershop.be.repositories.user.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin addAdmin(Admin admin) {
        return adminRepository.saveAndFlush(admin);
    }

    @Override
    public Admin findAdmin(String login) {
        return adminRepository.findAdminByLogin(login);
    }

}
