package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.AlunoController;
import model.Data;

public class AlunoView {
	private JFrame janela;
	private JButton botao1;
	private JButton botao2;
	private JLabel lblNome;
	private JLabel lblMatricula;
	private JLabel lblSexo;
	private JLabel lblDataNascimento;
	private JTextField campoNome;
	private JTextField campoMatricula;
	private JTextField campoSexo;
	private JTextField campoDataNascimento;

	public AlunoView() {
		iniciaGui();
	}

	public void iniciaGui() {
		// definir a tela e suas caracteristicas
		janela = new JFrame();
		janela.setTitle("Cadastro");
		janela.setSize(500, 300);
		janela.getContentPane().setLayout(null);
		janela.setLocationRelativeTo(null);

		// definir o compontente Jbutton (botao1)
		botao1 = new JButton();
		botao1.setText("Salvar");
		botao1.setBounds(130, 200, 100, 30);
		// definir o compontente Jbutton (botao2)
		botao2 = new JButton();
		botao2.setText("Cancelar");
		botao2.setBounds(250, 200, 100, 30);
		// definir o compontente JLabel de rotulo
		lblNome = new JLabel();
		lblNome.setText("Nome: ");
		lblNome.setBounds(50, 30, 40, 20);
		lblMatricula = new JLabel();
		lblMatricula.setText("Numero de Matricula: ");
		lblMatricula.setBounds(50, 70, 150, 20);
		lblSexo = new JLabel();
		lblSexo.setText("Sexo: ");
		lblSexo.setBounds(50, 110, 40, 20);
		lblDataNascimento = new JLabel();
		lblDataNascimento.setText("Data de nascimento: ");
		lblDataNascimento.setBounds(50, 150, 150, 20);
		// definir o campo de texto (JTextField)
		campoNome = new JTextField();
		campoNome.setBounds(200, 30, 200, 20);
		campoMatricula = new JTextField();
		campoMatricula.setBounds(200, 70, 200, 20);
		campoSexo = new JTextField();
		campoSexo.setBounds(200, 110, 200, 20);
		campoDataNascimento = new JTextField();
		campoDataNascimento.setBounds(200, 150, 200, 20);
		// informar a visibilidade da tela
		janela.setVisible(true);
		// adicionar os componentes na tela
		janela.getContentPane().add(botao1);
		janela.getContentPane().add(botao2);
		janela.getContentPane().add(lblNome);
		janela.getContentPane().add(lblMatricula);
		janela.getContentPane().add(lblSexo);
		janela.getContentPane().add(lblDataNascimento);
		janela.getContentPane().add(campoNome);
		janela.getContentPane().add(campoMatricula);
		janela.getContentPane().add(campoSexo);
		janela.getContentPane().add(campoDataNascimento);
		// adicionar o evento no botao salvar;
		botao1.addActionListener(new salvarListener());
		// adicionar o evento no botao cancelar;
		botao2.addActionListener(new cancelarListener());
	}

	public class salvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			AlunoController a1 = new AlunoController();
			Data data = new Data();
			if(campoNome.getText() == null ||campoNome.getText().trim().equals("")|| campoMatricula.getText() == null || campoMatricula.getText().trim().equals("")
					||campoSexo.getText() == null ||campoSexo.getText().trim().equals("")||campoDataNascimento.getText() == null || campoDataNascimento.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Favor preencher todos os campos", "ERRO:01",
						JOptionPane.ERROR_MESSAGE);
			}else {
				if(campoSexo.getText().trim().charAt(0) == 'm' ||campoSexo.getText().trim().charAt(0) == 'M' || campoSexo.getText().trim().charAt(0) == 'f' || campoSexo.getText().trim().charAt(0) == 'F') {					
					if(campoDataNascimento.getText().contains("/")) {
						String data1[] = campoDataNascimento.getText().split("/");
						int ano1 = Integer.parseInt(data1[2]);
						int mes1 = Integer.parseInt(data1[1]);
						int dia1 = Integer.parseInt(data1[0]);
							if(mes1 > 0 && mes1 < 13) {
								if(ano1 >2500) {
									JOptionPane.showMessageDialog(null, "Ano Inválida.", "ERRO:05",
											JOptionPane.ERROR_MESSAGE);
								}else {
									if(mes1 == 1 || mes1 == 3 ||mes1 == 5 ||mes1 == 7 ||mes1 == 8 || mes1 == 10 ||mes1 == 12) {
										if (dia1 >31) {
											JOptionPane.showMessageDialog(null, "Dia inválido.", "ERRO:06",
													JOptionPane.ERROR_MESSAGE);
										}else {
											a1.inserirAluno(campoNome.getText(), campoMatricula.getText(), campoSexo.getText().charAt(0),
													campoDataNascimento.getText());
											JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "Aviso",
													JOptionPane.INFORMATION_MESSAGE);
											campoNome.setText("");
											campoMatricula.setText("");
											campoSexo.setText("");
											campoDataNascimento.setText("");
										}
										
									}else {
										if(mes1 == 4||mes1 == 6||mes1 == 8||mes1 == 11) {
											if(dia1 > 30) {
												JOptionPane.showMessageDialog(null, "Dia inválido.", "ERRO:06",
														JOptionPane.ERROR_MESSAGE);
											}else {
												a1.inserirAluno(campoNome.getText(), campoMatricula.getText(), campoSexo.getText().charAt(0),
														campoDataNascimento.getText());
												JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "Aviso",
														JOptionPane.INFORMATION_MESSAGE);
												campoNome.setText("");
												campoMatricula.setText("");
												campoSexo.setText("");
												campoDataNascimento.setText("");
											}
										}else {
											if(mes1 == 2) {
												if(dia1 > 29) {
													JOptionPane.showMessageDialog(null, "Dia inválido.", "ERRO:06",
															JOptionPane.ERROR_MESSAGE);
												}else {
													a1.inserirAluno(campoNome.getText(), campoMatricula.getText(), campoSexo.getText().charAt(0),
															campoDataNascimento.getText());
													JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "Aviso",
															JOptionPane.INFORMATION_MESSAGE);
													campoNome.setText("");
													campoMatricula.setText("");
													campoSexo.setText("");
													campoDataNascimento.setText("");
												}
											}
										}
									}
									
									
								}
						}else {
							JOptionPane.showMessageDialog(null, "O mês digitado é inválido.", "ERRO:04",
									JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Por favor, coloque '/' para separar o dia, mes e ano.", "ERRO:03",
								JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Caractere inválido, digite m para masculino ou f para feminino", "ERRO:02",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}
	}
	
		public class cancelarListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}

		}
	
}
