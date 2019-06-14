package br.com.gobr.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControllerLogin {
	private static final Logger LOG = LogManager.getLogger(ControllerLogin.class);
    @FXML
    private TextField txtLogin;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCadastrar;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void cadastrar(ActionEvent event) {
    	LOG.info("Inicializar cadastro");
    }

    @FXML
    void login(ActionEvent event) {
    	LOG.info("Inicializar login");
    }

}
