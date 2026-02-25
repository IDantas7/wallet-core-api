package br.com.iDantas.wallet_core_api.Controller;

import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.dto.UsersRequest;
import br.com.iDantas.wallet_core_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/wallet-core")
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersRequest createUser(@Valid @RequestBody UsersRequest user){
        return userService.createUser(user);
    }

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsersRequest findUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping("user")
    @ResponseStatus(HttpStatus.OK)
    public List<UsersRequest> getAllUser(){
        return userService.getAllUsers();
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsersRequest updateUser(@PathVariable String id, @RequestBody UsersRequest user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
}
