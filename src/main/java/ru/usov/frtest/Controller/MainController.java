package ru.usov.frtest.Controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.usov.frtest.Entity.User;
import ru.usov.frtest.Repo.QuestionRepo;

import java.util.HashMap;

/**
 *
 */
@Controller
@RequestMapping("/")
@AllArgsConstructor
public class MainController {

    private final QuestionRepo questionRepo;



    @GetMapping
    @ApiOperation(value = "return index, model, user")
    public String main(Model model, @AuthenticationPrincipal User user) {
        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile", user);
        data.put("messages", questionRepo.findAll());

        model.addAttribute("frontendData", data);

        return "index";
    }
}
