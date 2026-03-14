package br.com.iDantas.wallet_core_api.service;

import br.com.iDantas.wallet_core_api.feign.AuthorizationClient;
import br.com.iDantas.wallet_core_api.feign.NotificationClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeignService {
    private AuthorizationClient authorizationClient;
    private final NotificationClient notificationClient;

    public AuthorizationClient getAuthorization(){
        try {
            return authorizationClient.getAuthorization();
        }catch (Exception e){
            log.error("Erro ao chamar api de autorizacao: " + e.getMessage());
            throw e;
        }
    }

    @Async
    public void sendNotification(){
        try {
            notificationClient.sendNotification();
        }catch (Exception e){
            log.error("Erro ao chamar api de autorizacao: " + e.getMessage());
            throw e;
        }
    }
}
