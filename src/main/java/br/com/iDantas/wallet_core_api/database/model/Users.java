package br.com.iDantas.wallet_core_api.database.model;

import br.com.iDantas.wallet_core_api.enums.ClientType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

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
