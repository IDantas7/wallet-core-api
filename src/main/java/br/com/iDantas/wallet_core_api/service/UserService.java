package br.com.iDantas.wallet_core_api.service;


import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import br.com.iDantas.wallet_core_api.dto.UsersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public UsersRequest createUser(UsersRequest user) {
        return usersRepository.save(user);
    }

    public UsersRequest getUserById(Long id){
        Optional<UsersRequest> optionalUsers = usersRepository.findById(id);

        if(optionalUsers.isEmpty()){
            System.out.println("User with this Id: " + id + " not found");
        }

        return optionalUsers.get();
    }

    public UsersRequest updateUser(Long id, UsersRequest user){
        Optional<UsersRequest> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            System.out.println("User with this Id: " + id + " not found");
        }
        return usersRepository.save(user);
    }
}
