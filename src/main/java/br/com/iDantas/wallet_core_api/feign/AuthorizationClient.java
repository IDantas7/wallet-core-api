package br.com.iDantas.wallet_core_api.feign;

import br.com.iDantas.wallet_core_api.DTO.feign.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthorizationClient", url = "https://util.devi.tools/api")
public interface AuthorizationClient {

    @GetMapping(value = "/v2/authorize")
    AuthorizationResponse getAuthorization();
}
