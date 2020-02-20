package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.AlunoController;

public class AlunoView {//inicio classe AlunoView
	//ATRIBUTOS(inicio):
	private JFrame janela;
	private JPanel painelDaJanela;
	//Rotulos da parte Info Basicas:
	private JLabel lblInfoBasicas;
	private JLabel lblNome;
	private JLabel lblSexo; //vai ser um radioButton
	private JLabel lblMatricula;
	private JLabel lblDataNascimento;//vai ter mascara
	private JLabel lblRg;//mascara
	private JLabel lblCpf;//mascara
	private JLabel lblTelefone;//mascara
	private JLabel lblSenha;
	private JLabel lblEspaco;
	//Rotulo da parte info endereco
	private JLabel lblInfoEndereco;
	private JLabel lblLogradouro;
	private JLabel lblCidade;//box
	private JLabel lblEstado;//box
	private JLabel lblBairro;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblCep;//mascara
	private JLabel lblUf;
	//Campos Basicos de info basicas
	private JTextField campoNome;
	private JTextField campoDataNascimento;//vai ter mascara
	private JTextField campoMatricula;
	private JTextField campoRg;//vai ter mascara
	private JTextField campoCpf;//vai ter mascara
	private JTextField campoTelefone;//vai ter mascara
	//Campos Basicos de info Endereco;
	private JTextField campoLogradouro;
	private JTextField campoNumero;
	private JTextField campoComplemento;
	private JTextField campoCep;//vai ter mascara
	private JTextField campoBairro;
	private JTextField campoUf;
	//Campos Especiais de info basicas
	private JRadioButton rbtSexoMasculino;//Radio Button do genero
	private JRadioButton rbtSexoFeminino;
	private JPasswordField jpwSenha;
	//Campos Especiais de info endereco
	private JComboBox cboxCidade;
	private JComboBox cboxEstado;
	//Botoes
	private JButton btnSalvar;
	private JButton btnCancelar;
	//Grupo botoes
	private ButtonGroup grpRadio;
	//Vetor com Cidades e Estado
	private String [] Estado = {"--Escolha uma opção--","SP - São Paulo", "RJ - Rio de Janeiro", "MG - Minas Gerais", "RS - Rio Grande Do Sul", "BH - Bahia" };
	private String [] Cidade = {"--Escolha uma opção--","Osasco", "Barueri", "Búzios", "Belo Horizonte", "São José dos Pinhais" };
	//ATRIBUTOS(FIM)
	
	public void iniciarGui() {//Inicio metodo iniciarGui
		//CRIAR INSTANCIAS
		//instancias da janela e to painel
		janela = new JFrame("Cadastro de Aluno");
		painelDaJanela = (JPanel) janela.getContentPane();
		//instancias parte info basica(rotulo)
		lblInfoBasicas = new JLabel();
		lblNome = new JLabel();
		lblSexo = new JLabel();
		lblMatricula = new JLabel();
		lblDataNascimento = new JLabel();
		lblRg = new JLabel();
		lblCpf = new JLabel();
		lblTelefone = new JLabel();
		lblSenha = new JLabel();
		lblEspaco = new JLabel();
		//instancias parte info endereco(rotulo)
		lblInfoEndereco = new JLabel();
		lblLogradouro = new JLabel();
		lblCidade = new JLabel();
		lblEstado = new JLabel();
		lblNumero = new JLabel();
		lblComplemento = new JLabel();
		lblCep = new JLabel();
		lblUf = new JLabel();
		lblBairro = new JLabel();
		//instancias campo basico info basica
		campoNome = new JTextField();
		campoMatricula = new JTextField();
		campoDataNascimento = new JTextField();
		campoRg = new JTextField();
		campoCpf = new JTextField();
		campoTelefone = new JTextField();
		//instancias campo basico info endereco
		campoLogradouro = new JTextField();
		campoNumero = new JTextField();
		campoComplemento = new JTextField();
		campoCep = new JTextField();
		campoUf = new JTextField();
		campoBairro = new JTextField();
		//instancias campo especial info basica
		rbtSexoMasculino = new JRadioButton();
		rbtSexoFeminino = new JRadioButton();
		jpwSenha = new JPasswordField();
		//instancias campo especial info endereco
		cboxCidade = new JComboBox(Cidade);
		cboxEstado = new JComboBox(Estado);
		//instanciar botoes
		btnSalvar = new JButton("Salvar");
		btnCancelar = new JButton("Cancelar");
		//instanciar grupo de botoes
		grpRadio = new ButtonGroup();
		
		//FIM INSTANCIAS
		
		//Adicionar o radiobutton no grupo de botoes
		grpRadio.add(rbtSexoMasculino);
		grpRadio.add(rbtSexoFeminino);
		
		
		
		//Configuracao da tela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(620, 500);
		janela.setVisible(true);
		janela.setResizable(false);
		
		//CONFIGURACAO INFO BASICA
		lblInfoBasicas.setText("REGISTRO DE ALUNO");
		lblInfoBasicas.setBounds(20, 5, 300, 30);
		lblInfoBasicas.setForeground(Color.ORANGE);
		
		//CONFIGURACAO ROTULO E CAMPO NOME
		lblNome.setText("*Nome: ");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(20, 30, 50, 30);
		try {
			javax.swing.text.MaskFormatter name = new javax.swing.text.MaskFormatter("***************************");
			campoNome = new javax.swing.JFormattedTextField(name);
		} catch (Exception e) {
		}
		campoNome.setBounds(70, 36, 220, 19);
		campoNome.setBackground(Color.LIGHT_GRAY);
		
		//CONFIGURACAO DO RADIO BUTTON(Ainda nao esta verificando)
		lblSexo.setText("*Sexo do aluno: ");
		lblSexo.setBounds(20, 60, 100, 30);
		lblSexo.setForeground(Color.WHITE);
		rbtSexoMasculino.setText("Masculino");
		rbtSexoMasculino.setBounds(110, 61, 100, 30);
		rbtSexoMasculino.setBackground(Color.DARK_GRAY);
		rbtSexoMasculino.setForeground(Color.WHITE);
		rbtSexoFeminino.setText("Feminino");
		rbtSexoFeminino.setBounds(110, 90, 100, 30);
		rbtSexoFeminino.setBackground(Color.DARK_GRAY);
		rbtSexoFeminino.setForeground(Color.WHITE);
		
		//CONFIGURACAO DO NUMERO DE MATRICULA
		lblMatricula.setText("*Matricula: ");
		lblMatricula.setBounds(20, 115, 100, 30);
		lblMatricula.setForeground(Color.WHITE);
		
		try {
			javax.swing.text.MaskFormatter mt = new javax.swing.text.MaskFormatter("AAAAAAA-AA");
			campoMatricula = new javax.swing.JFormattedTextField(mt);
		} catch (Exception e) {
		}
		campoMatricula.setBounds(90, 120, 200, 19);
		campoMatricula.setBackground(Color.LIGHT_GRAY);
		
		
		//CONFIGURACAO DA DATA DE NASCIMENTO
		lblDataNascimento.setText("*Data de nascimento: ");
		lblDataNascimento.setBounds(20, 150, 150, 30);
		lblDataNascimento.setForeground(Color.WHITE);
		
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			campoDataNascimento = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		campoDataNascimento.setBackground(Color.LIGHT_GRAY);
		campoDataNascimento.setBounds(150, 155, 140, 19);
		
		//CONFIGURACAO DO RG
		lblRg.setText("*RG: ");
		lblRg.setBounds(340, 30, 50, 30);
		lblRg.setForeground(Color.WHITE);		
		try {
			javax.swing.text.MaskFormatter rg = new javax.swing.text.MaskFormatter("##.###.###-#");
			campoRg = new javax.swing.JFormattedTextField(rg);
		} catch (Exception e) {
		}
		campoRg.setBackground(Color.LIGHT_GRAY);
		campoRg.setBounds(375, 36, 200, 19);
				
		//CONFIGURACAO CPF
		lblCpf.setText("*CPF: ");
		lblCpf.setBounds(340, 70, 50, 30);
		lblCpf.setForeground(Color.WHITE);
		
		try {
			javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
			campoCpf = new javax.swing.JFormattedTextField(cpf);
		} catch (Exception e) {
		}
		campoCpf.setBackground(Color.LIGHT_GRAY);
		campoCpf.setBounds(375, 75, 200, 19);
		
		//CONFIGURACAO TELEFONE
		lblTelefone.setText("*Telefone: ");
		lblTelefone.setBounds(340, 110, 80, 30);
		lblTelefone.setForeground(Color.WHITE);
		campoTelefone.setBackground(Color.LIGHT_GRAY);
		campoTelefone.setBounds(400, 115, 175, 19);
		try {
			javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##)#####-####");
			campoTelefone = new javax.swing.JFormattedTextField(telefone);
		} catch (Exception e) {
		}
		campoTelefone.setBackground(Color.LIGHT_GRAY);
		campoTelefone.setBounds(400, 115, 175, 19);
		
		//CONFIGURACAO SENHA
		lblSenha.setText("*Senha: ");
		lblSenha.setBounds(340, 150, 50, 30);
		lblSenha.setForeground(Color.WHITE);
		jpwSenha.setBounds(390, 155, 185, 19);
		jpwSenha.setBackground(Color.LIGHT_GRAY);
		
		//CONFIGURACAO INFO ENDERECO
		lblInfoEndereco.setText("ENDEREÇO DO ALUNO");
		lblInfoEndereco.setBounds(20, 200, 300, 30);
		lblInfoEndereco.setForeground(Color.ORANGE);
		lblEspaco.setText("-------------------------------------------------------------------------------------------------"
				+ "------------------------------------------");
		lblEspaco.setBounds(20, 180, 565, 30);
		lblEspaco.setForeground(Color.WHITE);
		
		//CONFIGURACAO LOGRADOURO
		lblLogradouro.setText("*Logradouro: ");
		lblLogradouro.setBounds(20, 225, 100, 30);
		lblLogradouro.setForeground(Color.WHITE);
		campoLogradouro.setBounds(110, 230, 180, 19);
		campoLogradouro.setBackground(Color.LIGHT_GRAY);
		
		//CONFIGURACAO BOX CIDADE
		lblCidade.setText("*Cidade: ");
		lblCidade.setBounds(20, 263, 60, 30);
		lblCidade.setForeground(Color.WHITE);
		cboxCidade.setSelectedIndex(0);
		cboxCidade.setBounds(70, 270, 220, 19);
		cboxCidade.setMaximumRowCount(10);
		cboxCidade.setBackground(Color.LIGHT_GRAY);
		
		//CONFIGURACAO BOX ESTADO
		lblEstado.setText("*Estado: ");
		lblEstado.setBounds(20, 305, 60, 30);
		lblEstado.setForeground(Color.WHITE);
		cboxEstado.setSelectedIndex(0);
		cboxEstado.setBounds(70, 313, 220, 19);
		cboxEstado.setMaximumRowCount(10);
		cboxEstado.setBackground(Color.LIGHT_GRAY);
		
		//CONFIGURACAO NUMERO
		lblNumero.setText("*Numero: ");
		lblNumero.setBounds(340, 225, 60, 30);
		lblNumero.setForeground(Color.WHITE);
		try {
			javax.swing.text.MaskFormatter numb = new javax.swing.text.MaskFormatter("AAAAA");
			campoNumero = new javax.swing.JFormattedTextField(numb);
		} catch (Exception e) {
		}
		campoNumero.setBounds(400, 230, 175, 19);
		campoNumero.setBackground(Color.LIGHT_GRAY);
		
		//CONFIGURACAO COMPLEMENTO
		lblComplemento.setText("Complemento: ");
		lblComplemento.setBounds(340, 263, 90, 30);
		lblComplemento.setForeground(Color.WHITE);
		campoComplemento.setBounds(430, 270, 145, 19);
		campoComplemento.setBackground(Color.LIGHT_GRAY);
		
		//CONFIGURACAO CEP
		lblCep.setText("*CEP: ");
		lblCep.setBounds(340, 305, 50, 30);
		lblCep.setForeground(Color.WHITE);
		campoCep.setBackground(Color.LIGHT_GRAY);
		campoCep.setBounds(380, 310, 195, 19);
		try {
			javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
			campoCep = new javax.swing.JFormattedTextField(cep);
		} catch (Exception e) {
		}
		campoCep.setBackground(Color.LIGHT_GRAY);
		campoCep.setBounds(380, 310, 195, 19);
		
//		//CONFIGURACAO DO UF
//		lblUf.setText("UF: ");
//		lblUf.setBounds(20, 342, 30, 30);
//		lblUf.setForeground(Color.WHITE);
//		campoUf.setBounds(50, 348, 50, 19);
//		campoUf.setBackground(Color.LIGHT_GRAY);
		
		//CONFIGURACAO DO BAIRRO
		lblBairro.setText("*Bairro: ");
		lblBairro.setBounds(20, 345, 50, 30);
		lblBairro.setForeground(Color.WHITE);
		campoBairro.setBounds(70, 350, 221, 19);
		campoBairro.setBackground(Color.LIGHT_GRAY);
		
		// CONFIGURACAO DO BOTAO
		btnSalvar.setText("SALVAR");
		btnSalvar.setBounds(340, 400, 100, 28);
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.setForeground(Color.DARK_GRAY);
		
		// CONFIGURACAO DO BOTAO
		btnCancelar.setText("CANCELAR");
		btnCancelar.setBounds(475, 400, 100, 28);
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setForeground(Color.DARK_GRAY);

		
		// AÇÃO DO BOTÃO SALVAR
		btnSalvar.addActionListener(new ActionListener() {//inicio ação do botao salvar
			
			public void actionPerformed(ActionEvent e) {
				//todo metodo que irá realizar um evento fica qui
				AlunoController a1 = new AlunoController();
				
				String sexo = selecionarSexo();
				String cidadeU = selecionarBoxCidade();
				String estadoU = selecionarBoxEstado();
				
				a1.consistirDados(campoNome.getText(), sexo, campoMatricula.getText(), campoDataNascimento.getText(), campoRg.getText()
						, campoCpf.getText(), campoTelefone.getText(), jpwSenha.getPassword(), campoLogradouro.getText(), cidadeU, estadoU, 
						campoBairro.getText(), campoNumero.getText(), campoComplemento.getText(), campoCep.getText());
				campoNome.setText("");
				sexo = "";
				campoMatricula.setText("");;
				campoDataNascimento.setText("");
				campoRg.setText("");
				campoCpf.setText("");
				campoTelefone.setText("");
				jpwSenha.setText("");
				campoLogradouro.setText("");
				cidadeU = "";
				estadoU = "";
				campoBairro.setText("");
				campoNumero.setText("");
				campoComplemento.setText("");
				campoCep.setText("");
				cboxCidade.setSelectedIndex(0);
				cboxEstado.setSelectedIndex(0);
			
			}
		});//fim ação do botão sakvar
		
		//Ação do botão cancelar
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		//Configuracao do Painel Da Tela
				painelDaJanela.setLayout(null);
				painelDaJanela.setBackground(Color.DARK_GRAY);
				painelDaJanela.add(lblInfoBasicas);
				painelDaJanela.add(lblNome);
				painelDaJanela.add(campoNome);
				painelDaJanela.add(lblSexo);
				painelDaJanela.add(rbtSexoMasculino);
				painelDaJanela.add(rbtSexoFeminino);
				painelDaJanela.add(lblMatricula);
				painelDaJanela.add(campoMatricula);
				painelDaJanela.add(lblDataNascimento);
				painelDaJanela.add(campoDataNascimento);
				painelDaJanela.add(lblRg);
				painelDaJanela.add(campoRg);
				painelDaJanela.add(lblCpf);
				painelDaJanela.add(campoCpf);
				painelDaJanela.add(lblTelefone);
				painelDaJanela.add(campoTelefone);
				painelDaJanela.add(lblSenha);
				painelDaJanela.add(jpwSenha);
				painelDaJanela.add(lblEspaco);
				painelDaJanela.add(lblInfoEndereco);
				painelDaJanela.add(lblLogradouro);
				painelDaJanela.add(campoLogradouro);
				painelDaJanela.add(lblCidade);
				painelDaJanela.add(cboxCidade);
				painelDaJanela.add(lblEstado);
				painelDaJanela.add(cboxEstado);
				painelDaJanela.add(lblNumero);
				painelDaJanela.add(campoNumero);
				painelDaJanela.add(lblComplemento);
				painelDaJanela.add(campoComplemento);
				painelDaJanela.add(lblCep);
				painelDaJanela.add(campoCep);
				painelDaJanela.add(lblUf);
				painelDaJanela.add(campoUf);
				painelDaJanela.add(lblBairro);
				painelDaJanela.add(campoBairro);
				painelDaJanela.add(btnSalvar);
				painelDaJanela.add(btnCancelar);
				
				
				
	}//fim metodo iniciarGui
	
	
	
	public String selecionarSexo() {//inicio do verificar qual radio button foi selecionado
		String respostaSexo = "";
		if(rbtSexoMasculino.isSelected()) {
			respostaSexo += rbtSexoMasculino.getText();
		}
		if(rbtSexoFeminino.isSelected()) {
			respostaSexo += rbtSexoFeminino.getText();
		}
		return respostaSexo;
	}//fim do verificar qual radioButton foi selecionado
	
	
	public String selecionarBoxCidade() {//Inicio do verificar qual CBox foi selecionado
		String respostaBoxCidade = cboxCidade.getSelectedItem().toString();
		if (respostaBoxCidade == "--Escolha uma opção--" ) {
			return "";
		}
		return respostaBoxCidade;
	}//Fim do verificar qual CBox foi selecionado
	
	
	public String selecionarBoxEstado() {//Inicio do verificar qual CBox foi selecionado
		
		String respostaBoxEstado = cboxEstado.getSelectedItem().toString();
		if (respostaBoxEstado == "--Escolha uma opção--" ) {
			return "";
		}
		return respostaBoxEstado;
	}//Fim do verificar qual CBox foi selecionado
	

	
	
}//fim classe AlunoView

