package br.com.gobr.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GobrStart extends Application {

	// private static Logger LOG = Logger.getLogger(GobrStart.class);
	@SuppressWarnings("unused")
	private static final Logger LOG = LogManager.getLogger(GobrStart.class);

	public static void main(String[] args) {

		// LOG.info("Iniciando conexão");
		//Conexao conn = new Conexao();
		//conn.getEntity();
		launch(args);
	}

	@Override
	public void start(Stage args) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		args.setTitle("Login");
		args.setScene(scene);
		args.show();
	}
}