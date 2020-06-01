package ru.itis.services.interfaces;

import ru.itis.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);

    Optional<UserDto> findByName(String name);

    UserDto save(UserDto user);
}
