package br.com.iDantas.wallet_core_api.handler.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super(String.format("Você não pode usar este cpf %s", email));
    }
}
