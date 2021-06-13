package ru.usov.frtest.Controller;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.usov.frtest.Entity.User;
import ru.usov.frtest.Service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Controller
@AllArgsConstructor
@RestController("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "Get request. Return list User")
    public List<User> userList(){return userService.findAll();}
    
    @GetMapping("{id}")
    @ApiOperation(value = "Get request. Return one User by id")
    public Optional<User> userById(@PathVariable("id") Long id){return userService.findUser(id);}

    @PostMapping
    @ApiOperation(value = "Post request. Create new User")
    public User createUsr(@RequestBody User user) {
        user.setCreationDate(LocalDateTime.now());
        return userService.addUser(user);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Put request. Update User from DB to new User")
    public User update(
            @PathVariable("id") User userFromDb,
            @RequestBody User user) {
        BeanUtils.copyProperties(user, userFromDb, "id");

        return userService.editUser(userFromDb);
    }
    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete request. Delete by id  User from DB")
    public void deleteUsr(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
