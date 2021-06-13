package ru.usov.frtest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.usov.frtest.Entity.Question;

import java.util.Optional;

/**
 *
 */
@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    @Override
    Optional<Question> findById(Long aLong);
}
