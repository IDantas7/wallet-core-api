package br.com.iDantas.wallet_core_api.service;


import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import br.com.iDantas.wallet_core_api.dto.UsersRequest;
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

    private void validateUserUniqueness(UsersRequest dto, String id){
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

    public UsersRequest createUser(UsersRequest users) {
        validateUserUniqueness(users, null);
        return usersRepository.save(users);
    }

    public UsersRequest getUserById(String id){
        Optional<UsersRequest> optionalUsers = usersRepository.findById(id);

        if(optionalUsers.isEmpty()){
            System.out.println("User with this Id: " + id + " not found");
        }

        return optionalUsers.get();
    }

    public List<UsersRequest> getAllUsers(){
       return usersRepository.findAll();
    }

    public UsersRequest updateUser(String id, UsersRequest user){
        if(!usersRepository.existsById(id)){
            throw new BusinessException("User with this Id: " + id + " not found");

        }

        validateUserUniqueness(user, id);
        return usersRepository.save(user);
    }

    public void deleteUser(String id){
        Optional<UsersRequest> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            throw new UserNotFoundException("User with this Id: " + id + " not found");
        }
        usersRepository.deleteById(id);
    }
}
