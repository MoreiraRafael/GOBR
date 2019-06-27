package br.com.gobr.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RelacaoClienteController {

	@FXML
	private Button btnVoltar;

	@FXML
	private TableView<Cliente> tableCliente;

	@FXML
	private TableColumn<Integer, Cliente> colID;

	@FXML
	private TableColumn<String, Cliente> colNome;

	@FXML
	private TableColumn<String, Cliente> colCPF;

	@FXML
	private TableColumn<String, Cliente> colRG;

	@FXML
	void retornar(ActionEvent event) throws IOException {

	}
	
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public static class Cliente {
		private final SimpleIntegerProperty id;
		private final SimpleStringProperty nome;
		private final SimpleStringProperty cpf;
		private final SimpleStringProperty rg;

		public Cliente(int id, String nome, String cpf, String rg) {
			this.id = new SimpleIntegerProperty(id);
			this.nome = new SimpleStringProperty(nome);
			this.cpf = new SimpleStringProperty(cpf);
			this.rg = new SimpleStringProperty(rg);
		}

		public SimpleIntegerProperty getId() {
			return id;
		}

		public SimpleStringProperty getNome() {
			return nome;
		}

		public SimpleStringProperty getCpf() {
			return cpf;
		}

		public SimpleStringProperty getRg() {
			return rg;
		}
	}
}
