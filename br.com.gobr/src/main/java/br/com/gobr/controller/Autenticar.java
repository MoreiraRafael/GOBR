package br.com.gobr.controller;

import br.com.gobr.jpa.Conexao;

public class Autenticar {
    
    public String logar(String user, String pass){
        
      
        //lógica de negócio para autenticação
       
        return "Usuário ou senha incorretos!";
    }
    //-------------------------------------------------------------------------
    public void logout(){
        Conexao conn = new Conexao();
        conn.closeEMF();
        //destruir sessão
        
        //redirecionar view
        //web vamos chamar jsf
        
        
        //javaFX: chamar fxml
        
        //mobile: chamar java
    }
    //-------------------------------------------------------------------------
}
