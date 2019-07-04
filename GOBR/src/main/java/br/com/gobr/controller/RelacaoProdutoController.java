package br.com.gobr.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import br.com.gobr.dao.ProdutoJPA;
import br.com.gobr.model.Produto;
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

public class RelacaoProdutoController implements Initializable{

    @FXML
    private TableView<Produto> tableCliente;

    @FXML
    private TableColumn<String, Produto> colCodBarras = new TableColumn<String, Produto>();

    @FXML
    private TableColumn<String, Produto> colDescricao = new TableColumn<String, Produto>();

    @FXML
    private TableColumn<Float, Produto> colQtdEst = new TableColumn<Float, Produto>();

    @FXML
    private TableColumn<Float, Produto> colQtdMin = new TableColumn<Float, Produto>();

    @FXML
    private TableColumn<Float, Produto> colQtdMax = new TableColumn<Float, Produto>();

    @FXML
    private TableColumn<Float, Produto> colValorAtacado = new TableColumn<Float, Produto>();

    @FXML
    private TableColumn<Float, Produto> colValorVarejo = new TableColumn<Float, Produto>();

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
		colCodBarras.setCellValueFactory(new PropertyValueFactory<String, Produto>("codBarras"));
		colDescricao.setCellValueFactory(new PropertyValueFactory<String, Produto>("descricao"));
		colQtdEst.setCellValueFactory(new PropertyValueFactory<Float, Produto>("quantEstoque"));
		colQtdMin.setCellValueFactory(new PropertyValueFactory<Float, Produto>("quantMin"));
		colQtdMax.setCellValueFactory(new PropertyValueFactory<Float, Produto>("quantMax"));
		colValorVarejo.setCellValueFactory(new PropertyValueFactory<Float, Produto>("valorVarejo"));
		colValorAtacado.setCellValueFactory(new PropertyValueFactory<Float, Produto>("valorAtacado"));

		ProdutoJPA pjpa = new ProdutoJPA();
		ObservableList<Produto> listacliente = FXCollections.observableArrayList(pjpa.getAll());
		tableCliente.setItems(listacliente);
	}

}
