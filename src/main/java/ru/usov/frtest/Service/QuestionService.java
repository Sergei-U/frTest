package ru.usov.frtest.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.usov.frtest.Entity.Question;
import ru.usov.frtest.Repo.QuestionRepo;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepo questionRepo;

    public Question addQuestion(Question question) {
        this.questionRepo.save(question);
        return question;
    }

    public Question editQuestion(Question question) {
        this.questionRepo.save(question);
        return question;
    }

    public void deleteQuestion(Long id) {
        this.questionRepo.deleteById(id);
    }


    public List<Question> findAll() {
        return questionRepo.findAll();
    }

    public Optional<Question> findQuestion(Long id) {
        return questionRepo.findById(id);

    }
}
