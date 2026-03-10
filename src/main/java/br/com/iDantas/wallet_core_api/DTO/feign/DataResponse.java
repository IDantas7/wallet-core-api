package br.com.iDantas.wallet_core_api.DTO.feign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataResponse {

    @JsonProperty("authorization")
    private Boolean authorization;
}
