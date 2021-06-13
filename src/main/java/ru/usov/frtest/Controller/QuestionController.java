package ru.usov.frtest.Controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.usov.frtest.Entity.Question;
import ru.usov.frtest.Service.QuestionService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Controller
@AllArgsConstructor
@RestController("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    @ApiOperation(value = "Get request. Return list Question")
    public List<Question> questionList(){return questionService.findAll();}

    @GetMapping("{id}")
    @ApiOperation(value = "Get request. Return one Question by id")
    public Optional<Question> questionById(@PathVariable("id") Long id){return questionService.findQuestion(id);}

    @PostMapping
    @ApiOperation(value = "Post request. Create new Question")
    public Question createQuestion(@RequestBody Question question) {
        question.setCreationTime(LocalDateTime.now());
        return questionService.addQuestion(question);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Put request. Update Question from DB to new Question")
    public Question update(
            @PathVariable("id") Question questionFromDb,
            @RequestBody Question question) {
        BeanUtils.copyProperties(question, questionFromDb, "id");

        return questionService.editQuestion(questionFromDb);
    }
    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete request. Delete by id  Question from DB")
    public void deleteUsr(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
    }
}
