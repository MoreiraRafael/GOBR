package br.com.gobr.jpa;

@SuppressWarnings("serial")
public class ConexaoException extends Exception{
    
    public void JPAException(String ex){
        System.out.printf("Erro na conexão: \n" + ex);
    }
}
