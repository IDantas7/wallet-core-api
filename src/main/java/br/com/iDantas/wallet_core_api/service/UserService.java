package br.com.iDantas.wallet_core_api.service;

import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import br.com.iDantas.wallet_core_api.exception.BusinessException;
import br.com.iDantas.wallet_core_api.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    private void validateUserUniqueness(Users dto, String id){
        if (usersRepository.existsByUsername(dto.getUsername())){
            throw new BusinessException("Username already exists");
        }
        if (usersRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("Email already exists");
        }
        if (usersRepository.existsByCpf(dto.getCpf())){
            throw new BusinessException("Cpf already exists");
        }
    }

    public Users createUser(Users users) {
        validateUserUniqueness(users, null);
        return usersRepository.save(users);
    }

    public Users getUserById(String id){
        Optional<Users> optionalUsers = usersRepository.findById(id);

        if(optionalUsers.isEmpty()){
            System.out.println("User with this Id: " + id + " not found");
        }

        return optionalUsers.get();
    }

    public List<Users> getAllUsers(){
       return usersRepository.findAll();
    }

    public Users updateUser(String id, Users user){
        if(!usersRepository.existsById(id)){
            throw new BusinessException("User with this Id: " + id + " not found");
        }
        validateUserUniqueness(user, id);
        return usersRepository.save(user);
    }

    public void deleteUser(String id){
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            throw new UserNotFoundException("User with this Id: " + id + " not found");
        }
        usersRepository.deleteById(id);
    }
}
