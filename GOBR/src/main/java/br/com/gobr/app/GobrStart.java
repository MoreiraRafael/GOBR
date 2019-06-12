package br.com.gobr.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gobr.jpa.Conexao;

public class GobrStart {

	// private static Logger LOG = Logger.getLogger(GobrStart.class);
	private static final Logger logger = LogManager.getLogger(GobrStart.class);

	public static void main(String[] args) {

		// LOG.info("Iniciando conexão");
		Conexao conn = new Conexao();
		conn.getEntity();
	}
}