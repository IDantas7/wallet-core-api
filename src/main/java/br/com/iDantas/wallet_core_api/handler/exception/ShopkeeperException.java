package br.com.iDantas.wallet_core_api.handler.exception;

public class ShopkeeperException extends RuntimeException{
    public  ShopkeeperException(Integer id){
        super(String.format("O Usuario %s e lojista, e nao pode realizar transacoes", id));
    }
}
