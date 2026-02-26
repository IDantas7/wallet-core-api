package br.com.iDantas.wallet_core_api.dto;

import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.enums.ClientType;
import java.math.BigDecimal;

public record UserRequestDisplay(String id,
        String username,
        String password,
        String email,
        String cpf,
        ClientType type,
        BigDecimal balance) {



    public UserRequestDisplay(Users user) {
        this(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getCpf(),
                user.getType(),
                user.getBalance());
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }


    public String getCpf() {
        return cpf;
    }

    public ClientType getType() {
        return type;
    }


    public BigDecimal getBalance() {
        return balance;
    }
}
