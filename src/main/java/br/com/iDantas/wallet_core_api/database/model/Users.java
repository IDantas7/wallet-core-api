package br.com.iDantas.wallet_core_api.database.model;

import br.com.iDantas.wallet_core_api.enums.ClientType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Data
@Table(name = "tb_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column(length = 11)
    private String cpf;

    @Column
    @Enumerated(EnumType.STRING)
    private ClientType type;

    @Column
    private BigDecimal balance;
}
