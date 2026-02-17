package br.com.iDantas.wallet_core_api.dto;

import br.com.iDantas.wallet_core_api.enums.ClientType;
import lombok.*;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class UsersRequest {

    private String username;
    private String password;
    private String email;
    private String cpf;
    private ClientType type;

}
