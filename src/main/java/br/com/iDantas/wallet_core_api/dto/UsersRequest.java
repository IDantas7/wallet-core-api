package br.com.iDantas.wallet_core_api.dto;

import br.com.iDantas.wallet_core_api.enums.ClientType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class UsersRequest {

    private String id;
    private String username;
    private String password;
    private String email;
    private String cpf;
    private ClientType type;
    private BigDecimal balance;



}
