package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;

public class AlunoController {

	public void consistirDados(String nome, String sexo, String matricula, String dataNascimento, String rg, String cpf,
			String telefone, char[] senha, String logradouro, String cidade, String estado, String bairro,
			String numero, String complemento, String cep) {// inicio consistirDados
		String senhaN = "";

		if (nome.equals(null) || nome.equals("") || sexo.equals(null) || sexo.equals("") || matricula.equals(null)
				|| matricula.equals("") || dataNascimento.equals(null) || dataNascimento.equals("") || rg.equals(null)
				|| rg.equals("") || cpf.equals(null) || cpf.equals("") || telefone.equals(null) || telefone.equals("")
				|| senha.equals(null) || senha.equals("") || logradouro.equals(null) || logradouro.equals("")
				|| cidade.equals(null) || cidade.equals("") || estado.equals(null) || estado.equals("")
				|| bairro.equals(null) || bairro.equals("") || numero.equals(null) || numero.equals("")
				|| cep.equals(null) || cep.equals("")) {

			JOptionPane.showMessageDialog(null, "Favor preencher os campos obrigatórios!", "ERRORx001",
					JOptionPane.ERROR_MESSAGE);

		} else {
			String data1[] = dataNascimento.split("/");
			if (Integer.parseInt(data1[2]) > 2500) {
				JOptionPane.showMessageDialog(null, "Ano Inválido!", "ERRORx109", JOptionPane.ERROR_MESSAGE);
			} else {
				if (Integer.parseInt(data1[1]) > 12) {
					JOptionPane.showMessageDialog(null, "Mês inválido", "ERRORx109", JOptionPane.ERROR_MESSAGE);
				} else {
					if (Integer.parseInt(data1[0]) > 31) {
						JOptionPane.showMessageDialog(null, "Dia inválido", "ERRORx109", JOptionPane.ERROR_MESSAGE);
					} else {
						for (int i = 0; i < senha.length; i++) {
							senhaN += senha[i];
						}
						char sexoChar = sexo.charAt(0);
						Aluno novoA1 = new Aluno();
						Cidade novoC1 = new Cidade(cidade);
						Estado estadoE1 = new Estado();
						String separaEstado[] = estado.split("-");
						estadoE1.setNome(separaEstado[1]);
						estadoE1.setUf(separaEstado[0]);
						estadoE1.setNome(estado);
						Endereco novoE1 = new Endereco(logradouro, Integer.parseInt(numero), complemento, bairro,
								novoC1, estadoE1, cep);
						String separaData[] = dataNascimento.split("/");
						Data novaD1 = new Data();
						novaD1.setMes(Integer.parseInt(separaData[1]));
						novaD1.setAno(Integer.parseInt(separaData[2]));
						novaD1.setDia(Integer.parseInt(separaData[0]));
						novoA1.setNomeAluno(nome);
						novoA1.setSexo(sexoChar);
						novoA1.setNumeroMatricula(matricula);
						novoA1.setDataNascimento(novaD1);
						novoA1.setRg(rg);
						novoA1.setCpf(cpf);
						novoA1.setTelefone(telefone);
						novoA1.setSenha(senhaN);
						novoA1.setEndereco(novoE1);
						inserirAluno(novoA1);

					}
				}

			}

		}

//Só vai colocar no final da consistencia		
//		Aluno novoA1 = new Aluno();
//		inserirAluno(novoA1);
	}// sair consistirDados

	// receber os dados do aluno e gravar em um arquivo de saida "aluno.txt";
	public void inserirAluno(Aluno aluno) {

		try {
			File arquivo = new File("alunos.txt");
			FileOutputStream arquivoOutput;
			arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			gravador.print(aluno.getNomeAluno());
			gravador.print(";");
			gravador.print(aluno.getNumeroMatricula());
			gravador.print(";");
			gravador.print(aluno.getSexo());
			gravador.print(";");
			gravador.print(aluno.getRg());
			gravador.print(";");
			gravador.print(aluno.getCpf());
			gravador.print(";");
			gravador.print(aluno.getSenha());
			gravador.print(";");
			gravador.print(aluno.getDataNascimento());
			gravador.print(";");
			gravador.print(aluno.getTelefone());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getNumero());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getComplemento());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getEstado().getUf());
			gravador.print(";");
			gravador.print(aluno.getEndereco().getCep());
			gravador.print("\n");
			gravador.close();
			arquivoOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// le o arquivo de saida e mostra os alunos cadastrados
	public void listarTodos() {
		try {
			InputStream is = new FileInputStream("alunos.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while (texto != null) {
				String dados[] = texto.split(";");
				System.out.println("Nome do Aluno: " + dados[0]);
				System.out.println("Número de Matrícula: " + dados[1]);
				System.out.println("Sexo do Aluno: " + dados[2]);
				System.out.println("Data de Nascimento: " + dados[3] + "\n");
				texto = leitor.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo de entrada não encontrada");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Arquivo de entrada não encontrada");
			e.printStackTrace();
		}
	}

	// Pesquisar o aniversatiante no mês;
//	public void listarAniversariante(int mes) {
//		try {
//			InputStream is = new FileInputStream("alunos.txt");
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader leitor = new BufferedReader(isr);
//			String texto = leitor.readLine();
//			while (texto != null) {
//				String dados[] = texto.split(";");
//				String data[] = dados[3].split("/");
//				int mesDeNascimento = Integer.parseInt(data[1]);
//				if (mes == mesDeNascimento) {
//					System.out.println("----------------------------------");
//					System.out.println("Aluno aniversariante: " + dados[0]);
//					System.out.println("Número da Matrícula: " + dados[1]);
//					System.out.println("Sexo do aluno: " + dados[2]);
//					System.out.println("Data do aniversário: " + dados[3]);
//					System.out.println("----------------------------------");
//				}
//				texto = leitor.readLine();
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("Arquivo de entrada não encontrada");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("Arquivo de entrada não encontrada");
//			e.printStackTrace();
//		}
//	}

}
