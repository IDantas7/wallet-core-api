package br.com.iDantas.wallet_core_api.Controller;

import br.com.iDantas.wallet_core_api.DTO.UsersRequest;
import br.com.iDantas.wallet_core_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/wallet")
public class UsersController {

    private final UserService userService;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid UsersRequest usersRequest) throws Exception {
        userService.createUser(usersRequest);
    }

}
