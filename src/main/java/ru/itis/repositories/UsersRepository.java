package ru.itis.repositories;

import org.springframework.data.jpa.repository.Query;
import ru.itis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
    List<User> findAll();
}
