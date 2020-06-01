package ru.itis.services.impl;

import ru.itis.dto.AdminDto;
import ru.itis.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.repositories.AdminRepository;
import ru.itis.services.interfaces.AdminsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminRepository adminRepository;

    public List<AdminDto> findAll() {
        return adminRepository.findAll().stream().map(
                admin -> {
                    AdminDto adminDto = new AdminDto();
                    adminDto.setId(admin.getId());
                    adminDto.setName(admin.getName());
                    adminDto.setAge(admin.getAge());
                    adminDto.setChannel(admin.getChannel());
                    return adminDto;
                }
        ).collect(Collectors.toList());
    }

    public Optional<AdminDto> findById(Long id) {
        Optional<Admin> optionalAdmin = adminRepository.findById(id);
        AdminDto adminDto = null;
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            adminDto = new AdminDto();
            adminDto.setId(admin.getId());
            adminDto.setName(admin.getName());
            adminDto.setAge(admin.getAge());
            adminDto.setChannel(admin.getChannel());
        }
        return Optional.ofNullable(adminDto);
    }

    public Optional<AdminDto> findByName(String name) {
        Optional<Admin> optionalAdmin = adminRepository.findByName(name);
        AdminDto adminDto = null;
        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();
            adminDto = new AdminDto();
            adminDto.setId(admin.getId());
            adminDto.setName(admin.getName());
            adminDto.setAge(admin.getAge());
            adminDto.setChannel(admin.getChannel());
        }
        return Optional.ofNullable(adminDto);
    }
}
