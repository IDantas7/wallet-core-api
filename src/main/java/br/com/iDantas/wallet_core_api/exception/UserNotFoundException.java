package br.com.iDantas.wallet_core_api.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message)
    {super(message);}
}
