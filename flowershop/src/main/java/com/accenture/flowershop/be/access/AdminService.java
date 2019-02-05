package com.accenture.flowershop.be.access;

import com.accenture.flowershop.be.entity.user.Admin;

import java.util.List;

public interface AdminService {
    Admin addAdmin(Admin admin);
    Admin findAdmin(String login);
    List<Admin> listAdmin();
}
