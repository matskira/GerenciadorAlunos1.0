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

import model.Aluno;
import model.Data;

public class AlunoController {
	//receber os dados do aluno e gravar em um arquivo de saida "aluno.txt";
	public void inserirAluno(String nome,String numeroMatricula,char sexo,String dataNascimento) {
		Aluno a1 = new Aluno();
		String data [] = dataNascimento.split("/");
		Data data1 = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
		
		a1.setNomeAluno(nome);
		a1.setNumeroMatricula(numeroMatricula);
		a1.setSexo(sexo);
		a1.setDataNascimento(data1);
		
		try {
			File arquivo = new File("alunos.txt");
			FileOutputStream arquivoOutput;
			arquivoOutput = new FileOutputStream(arquivo,true);
			PrintStream gravador = new PrintStream(arquivoOutput);
			gravador.print(a1.getNomeAluno());
			gravador.print(";");			
			gravador.print(a1.getNumeroMatricula());
			gravador.print(";");
			gravador.print(a1.getSexo());
			gravador.print(";");			
			gravador.print(a1.getDataNascimento());
			gravador.print("\n");
			gravador.close();
			arquivoOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	//le o arquivo de saida e mostra os alunos cadastrados
	public void listarTodos() {
		try {
			InputStream is = new FileInputStream("alunos.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while(texto!=null) {
				String dados [] = texto.split(";");				
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
	//Pesquisar o aniversatiante no mês;
	public void listarAniversariante(int mes) {
		try {
			InputStream is = new FileInputStream("alunos.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();
			while(texto!=null) {
				String dados [] = texto.split(";");
				String data [] = dados[3].split("/");
				int mesDeNascimento = Integer.parseInt(data[1]);
				if (mes == mesDeNascimento) {
					System.out.println("----------------------------------");
					System.out.println("Aluno aniversariante: " + dados[0]);
					System.out.println("Número da Matrícula: " + dados[1]);
					System.out.println("Sexo do aluno: " + dados[2]);
					System.out.println("Data do aniversário: " + dados[3]);
					System.out.println("----------------------------------");
				}
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
	
}

