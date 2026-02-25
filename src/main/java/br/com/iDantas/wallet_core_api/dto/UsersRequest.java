package br.com.iDantas.wallet_core_api.dto;

import br.com.iDantas.wallet_core_api.enums.ClientType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersRequest {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String cpf;
    private ClientType type;
    private BigDecimal balance;

}
