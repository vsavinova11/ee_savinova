package com.accenture.flowershop.be.repositories.user;

import com.accenture.flowershop.be.entity.user.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByLogin(String login);
}
