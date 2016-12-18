package prova;

import javax.swing.*;
import java.io.*;
public class LerTxt {
	CriarTxt nome = new CriarTxt();
	String loginUsuario[] = new String[5];
	String loginSenha[] = new String[5];
	String mostrar = ""; //Local para armazenar o conteudo do arquivo
	String nomeDoArq = nome.nomeDoArquivo;
	// nome do do arquivo (eu importei da classe 'CriarTxt' para manter o mesmo nome)
	String linha = "";
	String login[][] = new String[5][2];
	int a = 0; //parametro apra mudar a leitura de usuario e senha
	public void LerTXT(){
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
					login[a][0] = loginUsuario[a];
					login[a][1] = loginSenha[a];
					if((linha == null) || (loginUsuario[a] == null) || (loginSenha[a] == null)){
						break;
					}
					mostrar += "Usuário[" + a + "]: " + "\n" + "Nome: " + loginUsuario[a] + "\n" +
							"Senha: " + loginSenha[a] + linha + "\n\n";
				a++;
				}
				leitor.close();
			}
			catch (Exception erro) {}
			/*
			for(int i = 0; i < 5; i++){
				loginUsuario[a] = 0;
				loginSenha[a] = 0; 
			}
			*/
			JOptionPane.showMessageDialog(null, mostrar + "\n", nomeDoArq, 1);
		} else {
			JOptionPane.showMessageDialog(null, "Arquivo não existe", "Erro", 0);
		}
	}
}
