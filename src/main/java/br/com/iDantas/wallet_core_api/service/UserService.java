package br.com.iDantas.wallet_core_api.service;

import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public Users createUser(Users user) {
        return usersRepository.save(user);
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
}
