package br.com.iDantas.wallet_core_api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "AuthorizationClient", url = "https://util.devi.tools/api")
public interface NotificationClient {

    @PostMapping(value = "/v1/notify")
    void sendNotification();

}
