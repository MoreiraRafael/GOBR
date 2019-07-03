package br.com.gobr.controller;

import br.com.gobr.model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PdvController {

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

    }

    @FXML
    void buscaProduto(ActionEvent event) {

    }

    @FXML
    void cancelaVenda(ActionEvent event) {

    }

    @FXML
    void encerrarVenda(ActionEvent event) {

    }

    @FXML
    void iniciarVenda(ActionEvent event) {

    }

    @FXML
    void sair(ActionEvent event) {

    }

}
