package br.com.iDantas.wallet_core_api.DTO.feign;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationResponse {

    @JsonProperty("status")
    private String status;


    @JsonProperty("data")
    private DataResponse data;
}
