package br.com.gobr.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.gobr.model.Funcionario;
import br.com.gobr.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PdvController {

	private EntityManager em;
	ObservableList<Produto> listaItens = FXCollections.observableArrayList();

	@FXML
	private Button btnIniciarVenda;

	@FXML
	private Button btnCancelarVenda;

	@FXML
	private Button btnConsultaProduto;

	@FXML
	private TextField txtAdd;

	@FXML
	private Button btnAdd;

	@FXML
	private TextField txtIdCliente;

	@FXML
	private TextField txtNomeCliente;

	@FXML
	private Button btnFinalizarVenda;

	@FXML
	private TextField txtIdVenda;

	@FXML
	private TableView<Produto> tableListaProduto;

	@FXML
	private TableColumn<Produto, Integer> colNumItem;

	@FXML
	private TableColumn<Produto, String> colDescricao;

	@FXML
	private TableColumn<Produto, Float> colQtde;

	@FXML
	private TableColumn<Produto, Float> colTotal;

	@FXML
	private TextField txtValorGeral;

	@FXML
	private Button btnSair;

	@FXML
	void addTable(ActionEvent event) {
		String texto = txtAdd.getText();
		Produto p = addProduto(texto);
		System.out.println(p.getDescricao());
		listaItens.add(p);
		tableListaProduto.setItems(listaItens);
	}

	// Metodo de procura do produto
	public Produto addProduto(String codBarras) {
		String sql = "FROM Produto p WHERE p.codbarras = :codbarras";
		Query query = em.createQuery(sql);
		query.setParameter("codbarras", codBarras);
		Produto result = (Produto) query.getResultList();
		return result;
	}

	@FXML
	void buscaProduto(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnConsultaProduto.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_pdv_buscaProduto.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("Consulta de Produtos");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void cancelaVenda(ActionEvent event) {
		btnCancelarVenda.setDisable(true);
		btnFinalizarVenda.setDisable(true);
		btnAdd.setDisable(true);
		txtAdd.setDisable(true);
		txtIdCliente.setDisable(true);
		tableListaProduto.setDisable(true);
	}

	@FXML
	void encerrarVenda(ActionEvent event) {

	}

	@FXML
	void iniciarVenda(ActionEvent event) {
		btnCancelarVenda.setDisable(false);
		btnFinalizarVenda.setDisable(false);
		btnAdd.setDisable(false);
		txtAdd.setDisable(false);
		txtIdCliente.setDisable(false);
		tableListaProduto.setDisable(false);
	}

	@FXML
	void sair(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnSair.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_main.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("GOBR - Tela Principal");
		stage.setScene(scene);
		stage.show();
	}

}
