package br.com.iDantas.wallet_core_api.service;

import br.com.iDantas.wallet_core_api.DTO.TranferRequest;
import br.com.iDantas.wallet_core_api.database.model.Users;
import br.com.iDantas.wallet_core_api.database.repository.TransactionsRepository;
import br.com.iDantas.wallet_core_api.enums.ClientType;
import br.com.iDantas.wallet_core_api.exception.InsuficienteBalanceException;
import br.com.iDantas.wallet_core_api.exception.SenderEqualsReceiverException;
import br.com.iDantas.wallet_core_api.exception.ShopkeeperException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionsRepository transactionsRepository;
    private final UserService userService;

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
            throw new SenderEqualsReceiverException("O Pagador nao pode ser o mesmo que recebe");
        }

    }




}
