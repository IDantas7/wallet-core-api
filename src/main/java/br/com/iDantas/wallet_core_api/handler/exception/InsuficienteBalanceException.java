package br.com.iDantas.wallet_core_api.handler.exception;

public class InsuficienteBalanceException extends RuntimeException {
    public InsuficienteBalanceException(String message) {
        super(message);
    }
}
