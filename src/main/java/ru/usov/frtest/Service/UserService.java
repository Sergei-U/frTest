package ru.usov.frtest.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.usov.frtest.Entity.User;
import ru.usov.frtest.Repo.UserRepo;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User addUser(User user) {
        this.userRepo.save(user);
        return user;
    }

    public User editUser(User user) {
        this.userRepo.save(user);
        return user;
    }

    public void deleteUser(Long id) {
        this.userRepo.deleteById(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findUser(Long id) {
        return userRepo.findById(id);
    }
}
