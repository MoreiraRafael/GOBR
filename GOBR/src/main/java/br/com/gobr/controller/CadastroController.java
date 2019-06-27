package br.com.gobr.controller;

import java.io.IOException;

import br.com.gobr.dao.ClienteJPA;
import br.com.gobr.dao.EnderecoJPA;
import br.com.gobr.dao.FuncionarioJPA;
import br.com.gobr.dao.ProdutoJPA;
import br.com.gobr.model.Cliente;
import br.com.gobr.model.Endereco;
import br.com.gobr.model.Funcionario;
import br.com.gobr.model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroController {

	// Variáveis do Cliente
	@FXML
	private Button btnNovoCliente;

	@FXML
	private Button btnVoltarCliente;

	@FXML
	private TextField txtNomeCliente;

	@FXML
	private TextField txtCpfCliente;

	@FXML
	private Button btnRelacaoCliente;

	@FXML
	private TextField txtRuaCliente;

	@FXML
	private TextField txtBairroCliente;

	@FXML
	private TextField txtCidadeCliente;

	@FXML
	private TextField txtEstadoCliente;

	@FXML
	private Button btnSalvarCliente;

	@FXML
	private TextField txtRgCliente;

	@FXML
	private ChoiceBox<String> cboxGeneroCliente;

	// Variáveis do funcionario
	@FXML
	private Button btnNovoFuncionario;

	@FXML
	private Button btnVoltarFuncionario;

	@FXML
	private TextField txtNomeFuncionario;

	@FXML
	private TextField txtCpfFuncionario;

	@FXML
	private Button btnRelacaoFuncionario;

	@FXML
	private TextField txtRuaFuncionario;

	@FXML
	private TextField txtBairroFuncionario;

	@FXML
	private TextField txtCidadeFuncionario;

	@FXML
	private TextField txtEstadoFuncionario;

	@FXML
	private Button btnSalvarFuncionario;

	@FXML
	private TextField txtRgFuncionario;

	@FXML
	private ChoiceBox<String> txtGeneroFuncionario;

	@FXML
	private TextField txtFuncaoFuncionario;

	@FXML
	private TextField txtSalarioFuncionario;

	@FXML
	private TextField txtUsuarioFuncionario;

	@FXML
	private PasswordField txtSenhaFuncionario;

	// Variáveis do produto
	@FXML
	private Button btnNovoProduto;

	@FXML
	private Button btnVoltarProduto;

	@FXML
	private TextField txtCodBarras;

	@FXML
	private TextField txtDescricao;

	@FXML
	private Button btnRelacaoProduto;

	@FXML
	private TextField txtQtdEst;

	@FXML
	private TextField txtQtdMin;

	@FXML
	private TextField txtQtdMax;

	@FXML
	private TextField txtValorVarejo;

	@FXML
	private Button btnSalvarProduto;

	@FXML
	private TextField txtMarca;

	@FXML
	private TextField txtValorAtacado;

	// Métodos para ativar campos dos formulários
	@FXML
	void ativarCamposCliente(ActionEvent event) {
		if (btnSalvarCliente.isDisable()) {
			txtNomeCliente.setDisable(false);
			txtCpfCliente.setDisable(false);
			txtRuaCliente.setDisable(false);
			txtBairroCliente.setDisable(false);
			txtCidadeCliente.setDisable(false);
			txtEstadoCliente.setDisable(false);
			btnSalvarCliente.setDisable(false);
			txtRgCliente.setDisable(false);
			cboxGeneroCliente.setDisable(false);
			cboxGeneroCliente.getItems().add("Masculino");
			cboxGeneroCliente.getItems().add("Feminino");
			cboxGeneroCliente.getItems().add("Outros");
		}
	}

	@FXML
	void ativarCamposFuncionario(ActionEvent event) {
		if (btnSalvarFuncionario.isDisable()) {
			txtNomeFuncionario.setDisable(false);
			txtCpfFuncionario.setDisable(false);
			txtRuaFuncionario.setDisable(false);
			txtBairroFuncionario.setDisable(false);
			txtCidadeFuncionario.setDisable(false);
			txtEstadoFuncionario.setDisable(false);
			btnSalvarFuncionario.setDisable(false);
			txtRgFuncionario.setDisable(false);
			txtFuncaoFuncionario.setDisable(false);
			txtSalarioFuncionario.setDisable(false);
			txtUsuarioFuncionario.setDisable(false);
			txtSenhaFuncionario.setDisable(false);
			txtGeneroFuncionario.setDisable(false);
			txtGeneroFuncionario.getItems().add("Masculino");
			txtGeneroFuncionario.getItems().add("Feminino");
			txtGeneroFuncionario.getItems().add("Outros");
		}
	}

	@FXML
	void ativarCamposProduto(ActionEvent event) {
		if (btnSalvarProduto.isDisable()) {
			txtCodBarras.setDisable(false);
			txtDescricao.setDisable(false);
			txtMarca.setDisable(false);
			txtQtdEst.setDisable(false);
			txtQtdMin.setDisable(false);
			txtQtdMax.setDisable(false);
			txtValorVarejo.setDisable(false);
			txtValorAtacado.setDisable(false);
			btnSalvarProduto.setDisable(false);
		}
	}

	// Métodos para salvar dados do formulário
	@FXML
	void salvarCliente(ActionEvent event) throws IOException {
		if (txtNomeCliente.getText().equals("") && txtCpfCliente.getText().equals("")
				&& txtRuaCliente.getText().equals("") && txtCidadeCliente.getText().equals("")
				&& txtEstadoCliente.getText().equals("")) {
			Stage stage = (Stage) btnSalvarCliente.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../view/ui_alerta_erro.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
			stage.setTitle("Alerta: ERRO!");
			stage.setScene(scene);
			stage.show();
		} else {
			Endereco e = new Endereco();
			e.setRua(txtRuaCliente.getText());
			e.setBairro(txtBairroCliente.getText());
			e.setCidade(txtCidadeCliente.getText());
			e.setEstado(txtEstadoCliente.getText());

			Cliente c = new Cliente();
			c.setNome(txtNomeCliente.getText());
			c.setCpf(txtCpfCliente.getText());
			c.setRg(txtRgCliente.getText());
			c.setIdGenero(cboxGeneroCliente.getValue());
			c.setIdEndereco(e);

			EnderecoJPA ejpa = new EnderecoJPA();
			ejpa.save(e);

			ClienteJPA cjpa = new ClienteJPA();
			cjpa.save(c);

			txtNomeCliente.setDisable(true);
			txtCpfCliente.setDisable(true);
			txtRuaCliente.setDisable(true);
			txtCidadeCliente.setDisable(true);
			txtEstadoCliente.setDisable(true);
			btnSalvarCliente.setDisable(true);
			txtRgCliente.setDisable(true);
			cboxGeneroCliente.setDisable(true);
			txtBairroCliente.setDisable(true);
			
			Stage stage = (Stage) btnSalvarCliente.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../view/ui_alerta_dadosSalvos.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
			stage.setTitle("Alerta: Sucesso!");
			stage.setScene(scene);
			stage.show();
		}
	}

	
	@FXML
	void salvarFuncionario(ActionEvent event) throws IOException {
		if (txtNomeFuncionario.getText().equals("") && txtCpfFuncionario.getText().equals("") && txtRuaFuncionario.getText().equals("") && txtBairroFuncionario.getText().equals("") && txtCidadeFuncionario.getText().equals("") && txtEstadoFuncionario.getText().equals("") && txtRgFuncionario.getText().equals("") && txtFuncaoFuncionario.getText().equals("") && txtSalarioFuncionario.getText().equals("")	&& txtUsuarioFuncionario.getText().equals("") && txtSenhaFuncionario.getText().equals("")) {
			Stage stage = (Stage) btnSalvarFuncionario.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../view/ui_alerta_erro.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
			stage.setTitle("Alerta: ERRO!");
			stage.setScene(scene);
			stage.show();
		} else {
			Endereco e = new Endereco();
			e.setRua(txtRuaFuncionario.getText());
			e.setBairro(txtBairroFuncionario.getText());
			e.setCidade(txtCidadeFuncionario.getText());
			e.setEstado(txtEstadoFuncionario.getText());

			Funcionario f = new Funcionario();
			f.setNome(txtNomeFuncionario.getText());
			f.setCpf(txtCpfFuncionario.getText());
			f.setRg(txtRgFuncionario.getText());
			f.setIdGenero(txtGeneroFuncionario.getValue());
			f.setIdEndereco(e);
			f.setFuncao(txtFuncaoFuncionario.getText());
			f.setSalario(Float.parseFloat(txtSalarioFuncionario.getText()));
			f.setNomeusuario(txtUsuarioFuncionario.getText());
			f.setSenha(txtSenhaFuncionario.getText());

			EnderecoJPA ejpa = new EnderecoJPA();
			ejpa.save(e);

			FuncionarioJPA fjpa = new FuncionarioJPA();
			fjpa.save(f);

			txtNomeFuncionario.setDisable(true);
			txtCpfFuncionario.setDisable(true);
			txtRuaFuncionario.setDisable(true);
			txtBairroFuncionario.setDisable(true);
			txtCidadeFuncionario.setDisable(true);
			txtEstadoFuncionario.setDisable(true);
			btnSalvarFuncionario.setDisable(true);
			txtRgFuncionario.setDisable(true);
			txtFuncaoFuncionario.setDisable(true);
			txtSalarioFuncionario.setDisable(true);
			txtUsuarioFuncionario.setDisable(true);
			txtSenhaFuncionario.setDisable(true);
			txtGeneroFuncionario.setDisable(true);
			
			Stage stage = (Stage) btnSalvarFuncionario.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../view/ui_alerta_dadosSalvos.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
			stage.setTitle("Alerta: Sucesso!");
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	void salvarProduto(ActionEvent event) throws IOException {
		if (txtCodBarras.getText().equals("") && txtDescricao.getText().equals("") && txtQtdEst.getText().equals("")
				&& txtQtdMin.getText().equals("") && txtQtdMax.getText().equals("") && txtMarca.getText().equals("")
				&& txtValorVarejo.getText().equals("") && txtValorAtacado.getText().equals("")
				&& btnSalvarProduto.getText().equals("")) {
			Stage stage = (Stage) btnSalvarProduto.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../view/ui_alerta_erro.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
			stage.setTitle("Alerta: ERRO!");
			stage.setScene(scene);
			stage.show();
		}
		else {
			Produto p = new Produto();
			p.setCodBarras(txtCodBarras.getText());
			p.setDescricao(txtDescricao.getText());
			p.setMarca(txtMarca.getText());
			p.setQuantEstoque(Float.parseFloat(txtQtdEst.getText()));
			p.setQuantMax(Float.parseFloat(txtQtdMax.getText()));
			p.setQuantMin(Float.parseFloat(txtQtdMin.getText()));
			p.setValorAtacado(Float.parseFloat(txtValorAtacado.getText()));
			p.setValorVarejo(Float.parseFloat(txtValorVarejo.getText()));
			
			ProdutoJPA pjpa = new ProdutoJPA();
			pjpa.save(p);
			
			txtCodBarras.setDisable(true);
			txtDescricao.setDisable(true);
			txtMarca.setDisable(true);
			txtQtdEst.setDisable(true);
			txtQtdMin.setDisable(true);
			txtQtdMax.setDisable(true);
			txtValorVarejo.setDisable(true);
			txtValorAtacado.setDisable(true);
			btnSalvarProduto.setDisable(true);
			
			Stage stage = (Stage) btnSalvarProduto.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../view/ui_alerta_dadosSalvos.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
			stage.setTitle("Alerta: Sucesso!");
			stage.setScene(scene);
			stage.show();
		}
	}

	// Métodos para abrir tela de tabela dos dados cadastrados
	@FXML
	void abrirRelacaoCliente(ActionEvent event) {
		
	}

	@FXML
	void abrirRelacaoFuncionario(ActionEvent event) {

	}

	@FXML
	void abrirRelacaoProduto(ActionEvent event) {

	}

	// Métodos para voltar para a tela principal
	@FXML
	void voltarCliente(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnVoltarCliente.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_main.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("GOBR - Tela Principal");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void voltarFuncionario(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnVoltarFuncionario.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_main.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("GOBR - Tela Principal");
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void voltarProduto(ActionEvent event) throws IOException {
		Stage stage = (Stage) btnVoltarProduto.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("../view/ui_main.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/css/estilo.css").toExternalForm());
		stage.setTitle("GOBR - Tela Principal");
		stage.setScene(scene);
		stage.show();
	}

}
