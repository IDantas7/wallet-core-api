package br.com.iDantas.wallet_core_api.handler.exception;

public class CpfAlreadyExistsException extends RuntimeException {
    public CpfAlreadyExistsException(String cpf) {
        super((String.format("Você não pode usar este cpf %s", cpf)));
    }
}
