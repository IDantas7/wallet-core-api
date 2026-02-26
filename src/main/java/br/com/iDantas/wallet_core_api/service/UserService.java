package br.com.iDantas.wallet_core_api.service;


import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import br.com.iDantas.wallet_core_api.dto.UserRequestDisplay;
import br.com.iDantas.wallet_core_api.dto.UsersRequest;
import br.com.iDantas.wallet_core_api.exception.BusinessException;
import br.com.iDantas.wallet_core_api.exception.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
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

    public UserRequestDisplay createUser(UsersRequest dto) {
        Users user = new Users();
        BeanUtils.copyProperties(dto, user);
        validateUserUniqueness(dto, null);
        Users userCreated =  usersRepository.save(user);
        return new UserRequestDisplay(userCreated);
    }

    public UserRequestDisplay getUserById(String id){
        Optional<Users> optionalUsers = usersRepository.findById(id);

        if(optionalUsers.isEmpty()){
            System.out.println("User with this Id: " + id + " not found");
        }
        Users user = optionalUsers.get();
        return new UserRequestDisplay(user);

    }

    public List<UserRequestDisplay> getAllUsers(){
        return usersRepository
                .findAll()
                .stream()
                .map(UserRequestDisplay::new)
                .toList();
    }
    @Transactional
    public UserRequestDisplay updateUser(String id, UsersRequest dto){
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        if (dto.getUsername() != null){
            users.setUsername(dto.getUsername());
        }
        if (dto.getEmail() != null){
            users.setEmail(dto.getEmail());
        }
        if (dto.getCpf() != null){
            users.setCpf(dto.getCpf());
        }
        if (dto.getPassword() != null){
            users.setPassword(dto.getPassword());
        }
        validateUserUniqueness(dto, id);
        return new UserRequestDisplay(usersRepository.save(users));
    }


    public void deleteUser(String id){
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            throw new UserNotFoundException("User with this Id: " + id + " not found");
        }
        usersRepository.deleteById(id);
    }
}
