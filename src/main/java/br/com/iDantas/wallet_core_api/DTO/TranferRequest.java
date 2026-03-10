package br.com.iDantas.wallet_core_api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranferRequest {

    private BigDecimal value;
    private Integer payer;
    private Integer payee;
}
