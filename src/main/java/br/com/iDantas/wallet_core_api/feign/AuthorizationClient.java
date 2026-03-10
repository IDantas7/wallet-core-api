package br.com.iDantas.wallet_core_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "AuthorizationClient", url = "https://util.devi.tools/api", configuration =  FeignClientProperties.FeignClientConfiguration.class)
public interface AuthorizationClient {

    @GetMapping(value = "/v2/authorize")
    AuthorizationClient getAuthorization();
}
