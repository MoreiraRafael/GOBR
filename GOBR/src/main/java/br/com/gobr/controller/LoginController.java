package br.com.gobr.controller;

import java.io.IOException;

import br.com.gobr.dao.FuncionarioJPA;
//import br.com.gobr.dao.FuncionarioJPA;
//import br.com.gobr.model.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

		FuncionarioJPA fjpa = new FuncionarioJPA();
		if (fjpa.getLogin(txtLogin.getText(), txtSenha.getText())) {
			Stage stage = (Stage) txtLogin.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../view/ui_main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
			stage.setTitle("GOBR - Tela Principal");
			stage.setScene(scene);
			stage.show();
		} else {
			// exibir alerta de login e senha invalidos
			Alert msg = new Alert(AlertType.ERROR);
			msg.setContentText("Nome do Usuario ou Senha Incorretos! ");
			msg.setHeaderText("Erro na Autenticação ");
			msg.show();

		}

	}
}
