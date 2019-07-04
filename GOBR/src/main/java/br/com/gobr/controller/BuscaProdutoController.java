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

public class BuscaProdutoController implements Initializable{

    @FXML
    private TableView<Produto> tableListaProduto;

    @FXML
    private TableColumn<String, Produto> colCodBarras;

    @FXML
    private TableColumn<String, Produto> colDescricao;

    @FXML
    private TableColumn<Float, Produto> colValor;
    
    @FXML
    private Button btnRetornarPDV;

    @FXML
    void retornarPDV(ActionEvent event) throws IOException {
    	Stage stage = (Stage) btnRetornarPDV.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_function_pontoVenda.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("PDV - Ponto de Venda");
		stage.setScene(scene);
		stage.show();
    }

    public void initialize(URL location, ResourceBundle resources) {
    	colCodBarras.setCellValueFactory(new PropertyValueFactory<String, Produto>("codBarras"));
    	colDescricao.setCellValueFactory(new PropertyValueFactory<String, Produto>("descricao"));
    	colValor.setCellValueFactory(new PropertyValueFactory<Float, Produto>("valorVarejo"));
    	
    	ProdutoJPA pjpa = new ProdutoJPA();
    	ObservableList<Produto> listaproduto = FXCollections.observableArrayList(pjpa.getAll()); 
    	tableListaProduto.setItems(listaproduto);
    }
}
