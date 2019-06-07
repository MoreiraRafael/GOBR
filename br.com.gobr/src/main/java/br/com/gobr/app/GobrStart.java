package br.com.gobr.app;

import br.com.gobr.jpa.Conexao;
import javax.persistence.EntityManagerFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class GobrStart {
    
    private static Logger LOG = Logger.getLogger(GobrStart.class);
    
    public static void main(String[] args) {
        
        BasicConfigurator.configure();
        //LOG.info("Iniciando conexão");
        Conexao conn = new Conexao();
        
        conn.getEntity();
        
        System.out.println("Hello, world!");
    }
}