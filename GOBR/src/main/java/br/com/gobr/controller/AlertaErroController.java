package br.com.gobr.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AlertaErroController {

    @FXML
    private Button btnOK;

    @FXML
    void retornar(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnOK.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_menu_cadastro.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("Menu - Cadastro");
		stage.setScene(scene);
		stage.show();
    }
}