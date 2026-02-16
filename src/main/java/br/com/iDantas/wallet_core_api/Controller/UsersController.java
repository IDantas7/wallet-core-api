package br.com.iDantas.wallet_core_api.Controller;

import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/wallet-core")
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users user){
        return userService.createUser(user);
    }

    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users findUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@PathVariable Long id, @RequestBody Users user){
        return userService.updateUser(id, user);
    }
}
