package prova;

import javax.swing.*;
import java.io.*;
public class LerTxt {
	public void LerTXT(){
		CriarTxt nome = new CriarTxt();
		String mostrar = ""; //Local para armazenar o conteudo do arquivo
		String nomeDoArq = nome.nomeDoArquivo; // nome do do arquivo (eu importei da classe 'CriarTxt' para manter o mesmo nome)
		String linha = "";
		File arquivo = new File(nomeDoArq); 
		if(arquivo.exists()){ //retorna valor verdadeiro ou falso
			mostrar = "Arquivo: " + nomeDoArq + "\n";
			try{
				mostrar += "Conteúdo: \n";
				//abrindo arquivo para leitura
				FileReader reader = new FileReader(nomeDoArq);
				//leitor do arquivo	
				BufferedReader leitor = new BufferedReader(reader);
				while(true){
					linha = leitor.readLine();
					if(linha == null){
						break;
					}
				mostrar += linha + "\n";
				}
			}
			catch (Exception erro) {}
			JOptionPane.showMessageDialog(null, mostrar, nomeDoArq, 1);
		} else {
			JOptionPane.showMessageDialog(null, "Arquivo não existe", "Erro", 0);
		}
	}
}

	

