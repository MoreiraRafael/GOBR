package br.com.gobr.controller;

import java.io.IOException;

//import br.com.gobr.dao.FuncionarioJPA;
//import br.com.gobr.model.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField txtLogin;

	@FXML
	private Button btnLogin;

	@FXML
	private Button btnCadastrar;

	@FXML
	private PasswordField txtSenha;

	@FXML
    void login(ActionEvent event) throws IOException {
		if(txtLogin.getText().equals("admin") && txtSenha.getText().equals("admin")) {
    		Stage stage = (Stage) btnLogin.getScene().getWindow();
        	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_main.fxml"));
    		Scene scene = new Scene(root);
    		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
    		stage.setTitle("GOBR - Tela Principal");
    		stage.setScene(scene);
    		stage.show();
    	}
    	/*
    	Funcionario f = new Funcionario();
    	FuncionarioJPA fjpa = new FuncionarioJPA();
    	*/
    	
    }
}
