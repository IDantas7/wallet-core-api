package br.com.iDantas.wallet_core_api.handler.exception;

public class SenderEqualsReceiverException extends RuntimeException {
    public SenderEqualsReceiverException(String message) {
        super(message);
    }
}
