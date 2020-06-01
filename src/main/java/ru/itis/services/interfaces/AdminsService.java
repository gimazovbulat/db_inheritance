package ru.itis.services.interfaces;

import ru.itis.dto.AdminDto;

import java.util.List;
import java.util.Optional;

public interface AdminsService {
    List<AdminDto> findAll();
    Optional<AdminDto> findById(Long id);
    Optional<AdminDto> findByName(String name);
}
