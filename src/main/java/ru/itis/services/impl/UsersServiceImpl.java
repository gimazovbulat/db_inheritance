package ru.itis.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dto.UserDto;
import ru.itis.model.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.interfaces.UsersService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public List<UserDto> findAll() {
        return usersRepository.findAll().stream()
                .map(
                        u -> UserDto.builder()
                                .id(u.getId())
                                .age(u.getAge())
                                .name(u.getName())
                                .build()
                ).collect(Collectors.toList());
    }

    public Optional<UserDto> findById(Long id) {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return
                    Optional.ofNullable(UserDto.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .age(user.getAge())
                            .build());
        }
        return Optional.empty();
    }

    public Optional<UserDto> findByName(String name) {
        Optional<User> optionalUser = usersRepository.findByName(name);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return
                    Optional.ofNullable(UserDto.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .age(user.getAge())
                            .build());
        }
        return Optional.empty();
    }

    @Override
    public UserDto save(UserDto user) {
        User savedUser = usersRepository.save(User.builder()
                .name(user.getName())
                .age(user.getAge())
                .build());

        return UserDto.builder()
                .age(savedUser.getAge())
                .name(savedUser.getName())
                .id(savedUser.getId())
                .build();
    }
}
