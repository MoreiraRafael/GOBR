package br.com.gobr.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnPDV;

    @FXML
    private Button btnADC;

    @FXML
    private Button btnSair;

    @FXML
    void abrirADC(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnADC.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_function_areaCompra.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("ADC - Area de Compra");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void abrirMenuCadastro(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnADC.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_menu_cadastro.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("Menu - Cadastro");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void abrirPDV(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnADC.getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../view/ui_function_pontoVenda.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("PDV - Ponto de Venda");
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void sairSistema(ActionEvent event) {

    }
}
