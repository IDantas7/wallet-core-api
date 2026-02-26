package br.com.iDantas.wallet_core_api.DTO;

import br.com.iDantas.wallet_core_api.enums.ClientType;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersRequest {

    private String name;
    private String password;
    private String email;
    private String cpf;
    private ClientType type;
    private BigDecimal balance;



}
