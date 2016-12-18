package prova;

import javax.swing.*;
import java.util.Formatter;
public class CriarTxt {
	String nomeDoArquivo = "DadosDeCadastro.txt";	
	String nomeDeUsuario[] = new String [5];
	String senha[] = new String[5];
	String informacoes ="";
	String login[][] = new String[5][2];
	int i = 0;
	int a = 0;
	boolean control = false;
	
	public void CriarTXT(){
		try {
			Formatter saida = new Formatter(this.nomeDoArquivo);
			JOptionPane.showMessageDialog(null, "Digite os dados do seu cadastro:");
			this.nomeDeUsuario[i] = JOptionPane.showInputDialog("Nome de usuário:");
			this.senha[i] = JOptionPane.showInputDialog("Senha:");
			login[a][0] = nomeDeUsuario[a];
			login[a][1] = senha[a];
			informacoes += this.nomeDeUsuario[i] + "\n" + this.senha[i] + "\n\n";
			saida.format(informacoes);
			a++;
			saida.close();
			JOptionPane.showMessageDialog(null,"Arquivo " + this.nomeDoArquivo + " criado!", "Arquivo",1 );
		}
		catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Arquivo não põde ser gerado");
		}
	}
}
