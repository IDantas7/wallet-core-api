package br.com.iDantas.wallet_core_api.service;


import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.UsersRepository;
import br.com.iDantas.wallet_core_api.DTO.UsersRequest;
import br.com.iDantas.wallet_core_api.handler.exception.CpfAlreadyExistsException;
import br.com.iDantas.wallet_core_api.handler.exception.EmailAlreadyExistsException;
import br.com.iDantas.wallet_core_api.handler.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;



    public void createUser(UsersRequest request) throws Exception {
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

    public void save(Users user){
        usersRepository.save(user);
    }

    private void validateEmailAndCPF(UsersRequest request)throws Exception{
        Users user = usersRepository.findByCpf(request.getCpf()).orElse(null);
        if (user!=null) throw new CpfAlreadyExistsException(request.getCpf());

        user = usersRepository.findByEmail(request.getEmail()).orElse(null);
        if (user!=null) throw new EmailAlreadyExistsException(request.getEmail());
    }

}
