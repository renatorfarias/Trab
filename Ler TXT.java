package prova;

import javax.swing.*;
import java.io.*;
public class LerTxt {
	public void LerTXT(){
		CriarTxt nome = new CriarTxt();
		int a = 0; //parametro apra mudar a leitura de usuario e senha
		int k = 0;
		String loginUsuario[] = new String[5];
		String loginSenha[] = new String[5];
		String dados = "";
		String mostrar = ""; //Local para armazenar o conteudo do arquivo
		String nomeDoArq = nome.nomeDoArquivo; // nome do do arquivo (eu importei da classe 'CriarTxt' para manter o mesmo nome)
		String linha = "";
		File arquivo = new File(nomeDoArq); 
		if(arquivo.exists()){ //retorna valor verdadeiro ou falso
			mostrar = "Arquivo: " + nomeDoArq + "\n";
			try{
				mostrar += "Dados:\n";
				//abrindo arquivo para leitura
				FileReader reader = new FileReader(nomeDoArq);
				//leitor do arquivo
				BufferedReader leitor = new BufferedReader(reader);
				while(true){
					loginUsuario[a] = leitor.readLine();
					loginSenha[a] = leitor.readLine();
					linha = leitor.readLine();
					if((linha == null) || (loginUsuario[a] == null) || (loginSenha[a] == null)){
						break;
					}
					a++;
				mostrar += linha;
				}
			}
			catch (Exception erro) {}
			/*
			for(int i = 0; i < 5; i++){
				loginUsuario[a] = 0;
				loginSenha[a] = 0; 
			}
			*/
			for(int i = 0; i <= a; i++){
				dados += loginUsuario[a] + "\n" + loginSenha[a] + "\n";
			}
			JOptionPane.showMessageDialog(null, mostrar + "\n" + dados, nomeDoArq, 1);
		} else {
			JOptionPane.showMessageDialog(null, "Arquivo não existe", "Erro", 0);
		}
	}
}
