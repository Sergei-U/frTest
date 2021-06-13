package ru.usov.frtest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.usov.frtest.Entity.User;

import java.util.Optional;

/**
 *
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Override
    Optional<User> findById(Long aLong);
}
