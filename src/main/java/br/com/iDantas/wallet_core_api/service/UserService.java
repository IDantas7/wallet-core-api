package br.com.iDantas.wallet_core_api.service;


import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import br.com.iDantas.wallet_core_api.DTO.UsersRequest;
import br.com.iDantas.wallet_core_api.exception.BusinessException;
import br.com.iDantas.wallet_core_api.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    private void validateEmailAndCPF(UsersRequest request){

        if (usersRepository.existsByEmail(request.getEmail())){
            throw new BusinessException("Email already exists");
        }
        if (usersRepository.existsByCpf(request.getCpf())){
            throw new BusinessException("Cpf already exists");
        }
    }

    public void createUser(UsersRequest request) {
        validateEmailAndCPF(request);

        usersRepository.save(Users.builder()
                .name(request.getName())
                .password(request.getPassword())
                .email(request.getEmail())
                .cpf(request.getCpf())
                .type(request.getType())
                .balance(request.getBalance())
                .build());
    }

    public Users findById(Integer id) throws  UserNotFoundException {
        return usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException (String.format("Usuario nao encontrado no id %s", id)));
    }

    public void deleteUser(Integer id){
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            throw new UserNotFoundException("User with this Id: " + id + " not found");
        }
        usersRepository.deleteById(id);
    }
}
