package br.com.iDantas.wallet_core_api.service;

import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import br.com.iDantas.wallet_core_api.dto.UsersRequest;
import br.com.iDantas.wallet_core_api.exception.BusinessException;
import br.com.iDantas.wallet_core_api.exception.UserNotFoundException;
import jdk.jshell.spi.ExecutionControl;
import org.hibernate.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public Users createUser(Users dto) {
        if (usersRepository.existsByUsername(dto.getUsername())){
            throw new BusinessException("Username already exists");
        }
        if (usersRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("Email already exists");
        }
        if (usersRepository.existsByCpf(dto.getCpf())){
            throw new BusinessException("Cpf already exists");
        }
        return usersRepository.save(dto);

    }

    public Users getUserById(Long id){
        Optional<Users> optionalUsers = usersRepository.findById(id);

        if(optionalUsers.isEmpty()){
            System.out.println("User with this Id: " + id + " not found");
        }

        return optionalUsers.get();
    }

    public Users updateUser(Long id, Users user){
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            System.out.println("User with this Id: " + id + " not found");
        }
        return usersRepository.save(user);
    }

    public void deleteUser(Long id){
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            throw new UserNotFoundException("User with this Id: " + id + " not found");
        }
        usersRepository.deleteById(id);
    }
}
