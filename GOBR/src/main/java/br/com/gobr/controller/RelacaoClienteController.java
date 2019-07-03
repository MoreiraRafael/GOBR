package br.com.gobr.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.gobr.dao.ClienteJPA;
import br.com.gobr.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RelacaoClienteController implements Initializable {

	@FXML
	private Button btnVoltar;

	@FXML
	private TableView<Cliente> tableCliente = new TableView<Cliente>();

	@FXML
	private TableColumn<Integer, Cliente> colID = new TableColumn<Integer, Cliente>();

	@FXML
	private TableColumn<String, Cliente> colNome = new TableColumn<String, Cliente>();

	@FXML
	private TableColumn<String, Cliente> colCPF = new TableColumn<String, Cliente>();

	@FXML
	private TableColumn<String, Cliente> colRG = new TableColumn<String, Cliente>();

	@FXML
	private TableColumn<String, Cliente> colRua = new TableColumn<String, Cliente>();

	@FXML
	private TableColumn<String, Cliente> colBairro = new TableColumn<String, Cliente>();

	@FXML
	private TableColumn<String, Cliente> colCidade = new TableColumn<String, Cliente>();

	@FXML
	private TableColumn<String, Cliente> colEstado = new TableColumn<String, Cliente>();

	@FXML
	void retornar(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnVoltar.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_menu_cadastro.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("Menu - Cadastro");
		stage.setScene(scene);
		stage.show();
	}

	public void initialize(URL location, ResourceBundle resources) {
		colID.setCellValueFactory(new PropertyValueFactory<Integer, Cliente>("idPessoa"));
		colNome.setCellValueFactory(new PropertyValueFactory<String, Cliente>("nome"));
		colCPF.setCellValueFactory(new PropertyValueFactory<String, Cliente>("cpf"));
		colRG.setCellValueFactory(new PropertyValueFactory<String, Cliente>("rg"));
		colRua.setCellValueFactory(new PropertyValueFactory<String, Cliente>("rua"));
		colBairro.setCellValueFactory(new PropertyValueFactory<String, Cliente>("bairro"));
		colCidade.setCellValueFactory(new PropertyValueFactory<String, Cliente>("cidade"));
		colEstado.setCellValueFactory(new PropertyValueFactory<String, Cliente>("estado"));

		ClienteJPA cjpa = new ClienteJPA();
		ObservableList<Cliente> listacliente = FXCollections.observableArrayList(cjpa.getAll());
		tableCliente.setItems(listacliente);
	}
}
