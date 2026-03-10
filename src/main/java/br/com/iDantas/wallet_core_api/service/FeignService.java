package br.com.iDantas.wallet_core_api.service;

import br.com.iDantas.wallet_core_api.DTO.feign.AuthorizationResponse;
import br.com.iDantas.wallet_core_api.exception.BusinessException;
import br.com.iDantas.wallet_core_api.feign.AuthorizationClient;

public class FeignService {
    private AuthorizationClient authorizationClient;

    public AuthorizationClient getAuthorization(){
        try {
            return authorizationClient.getAuthorization();
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
    }
}
