package br.com.iDantas.wallet_core_api.service;

import br.com.iDantas.wallet_core_api.DTO.TranferRequest;
import br.com.iDantas.wallet_core_api.database.model.Transactions;
import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.TransactionsRepository;
import br.com.iDantas.wallet_core_api.enums.ClientType;
import br.com.iDantas.wallet_core_api.handler.exception.InsuficienteBalanceException;
import br.com.iDantas.wallet_core_api.handler.exception.SenderEqualsReceiverException;
import br.com.iDantas.wallet_core_api.handler.exception.ShopkeeperException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionsRepository transactionsRepository;
    private final UserService userService;
    private final FeignService feignService;

    @Transactional
    public void createTransfer (TranferRequest request){
        Users sender = userService.findById(request.getPayer());
        Users receive = userService.findById(request.getPayee());

        if (sender.getType().name().equals(ClientType.SHOPKEEPER.name())){
            throw new ShopkeeperException(sender.getId());
        }

        if (sender.getBalance().compareTo(request.getValue()) < 0){
            throw new InsuficienteBalanceException("Seu saldo e insuficiente para transacao");
        }

        if (sender.getId().equals(receive.getId())){
            throw new SenderEqualsReceiverException("Voce nao pode transferir para si mesmo");
        }

        sender.setBalance(sender.getBalance().subtract(request.getValue()));
        receive.setBalance(receive.getBalance().add(request.getValue()));

        userService.save(sender);
        userService.save(receive);

        transactionsRepository.save(Transactions.builder()
                .sender(sender)
                .receive(receive)
                .transactionValue(request.getValue())
                .build());

        feignService.sendNotification();
    }




}
