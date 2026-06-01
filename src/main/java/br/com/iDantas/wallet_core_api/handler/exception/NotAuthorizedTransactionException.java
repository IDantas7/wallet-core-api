package br.com.iDantas.wallet_core_api.handler.exception;

public class NotAuthorizedTransactionException extends RuntimeException {
    public NotAuthorizedTransactionException() {
        super("Transacao nao autorizada");
    }
}
