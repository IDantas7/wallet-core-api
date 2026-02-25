package br.com.iDantas.wallet_core_api.dto;

import br.com.iDantas.wallet_core_api.enums.ClientType;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequest {

    private String id;
    private String username;
    private String password;
    private String email;
    private String cpf;
    private ClientType type;

    public UsersRequest(String id, String username, String password, String email, String cpf, ClientType type, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cpf = cpf;
        this.type = type;
    }
}
