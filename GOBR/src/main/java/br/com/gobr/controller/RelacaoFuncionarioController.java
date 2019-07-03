package br.com.gobr.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.com.gobr.dao.FuncionarioJPA;
import br.com.gobr.model.Funcionario;
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

public class RelacaoFuncionarioController implements Initializable{

	@FXML
	private TableView<Funcionario> tableCliente = new TableView<Funcionario>();

	@FXML
	private TableColumn<String, Funcionario> colNome = new TableColumn<String, Funcionario>();

	@FXML
	private TableColumn<String, Funcionario> colCPF = new TableColumn<String, Funcionario>();

	@FXML
	private TableColumn<String, Funcionario> colRG = new TableColumn<String, Funcionario>();

	@FXML
	private TableColumn<String, Funcionario> colFuncao = new TableColumn<String, Funcionario>();

	@FXML
	private TableColumn<Double, Funcionario> colSalario = new TableColumn<Double, Funcionario>();

	@FXML
	private TableColumn<String, Funcionario> colUsuario = new TableColumn<String, Funcionario>();

	@FXML
	private TableColumn<String, Funcionario> colSenha = new TableColumn<String, Funcionario>();

	@FXML
	private Button btnVoltar;

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
		colNome.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("nome"));
		colCPF.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("cpf"));
		colRG.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("rg"));
		colFuncao.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("funcao"));
		colSalario.setCellValueFactory(new PropertyValueFactory<Double, Funcionario>("salario"));
		colUsuario.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("nomeusuario"));
		colSenha.setCellValueFactory(new PropertyValueFactory<String, Funcionario>("senha"));
		
		FuncionarioJPA fjpa = new FuncionarioJPA();
		ObservableList<Funcionario> listafuncionario = FXCollections.observableArrayList(fjpa.getAll());
		tableCliente.setItems(listafuncionario);
	}

}
