package br.com.iDantas.wallet_core_api.Controller;

import br.com.iDantas.wallet_core_api.database.model.Users;
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
    public Users createUser(@Valid @RequestBody Users user){
        return userService.createUser(user);
    }

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users findUserById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping("user")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> getAllUser(){
        return userService.getAllUsers();
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@PathVariable String id, @RequestBody Users user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
}
