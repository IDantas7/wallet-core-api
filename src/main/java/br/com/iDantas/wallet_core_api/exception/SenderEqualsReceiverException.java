package br.com.iDantas.wallet_core_api.exception;

public class SenderEqualsReceiverException extends RuntimeException {
    public SenderEqualsReceiverException(String message) {
        super(message);
    }
}
