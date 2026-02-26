package br.com.iDantas.wallet_core_api.database.model;

import br.com.iDantas.wallet_core_api.enums.ClientType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String username;

    @Column
    @Size(min=8)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 11, unique = true, nullable = false)
    @NotBlank
    @Size(min = 11, max = 11, message = "CPF must have exactly 11 digits")
    private String cpf;

    @Column
    @Enumerated(EnumType.STRING)
    private ClientType type;

    @Column
    private BigDecimal balance;
}
