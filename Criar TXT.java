package prova;

import javax.swing.*;
import java.util.Formatter;
public class CriarTxt {
	String nomeDoArquivo = "DadosDeCadastro.txt";	
	String nomeDeUsuario[] = new String [5];
	String senha[] = new String[5];
	String informacoes ="";
	int i = 0;
	boolean control = false;
	
	public void CriarTXT(){
		try {
			Formatter saida = new Formatter(this.nomeDoArquivo);
			JOptionPane.showMessageDialog(null, "Digite os dados do seu cadastro:");
			this.nomeDeUsuario[i] = JOptionPane.showInputDialog("Nome de usuário:");
			this.senha[i] = JOptionPane.showInputDialog("Senha:");
			//informacoes += "usuario[" + i + "]" + " = {" + this.nomeDeUsuario[i] + ", " + this.senha[i] + "}; \n";
			informacoes += this.nomeDeUsuario[i] + "\n" + this.senha[i] + "\n";
			saida.format(informacoes);
			i++;
			saida.close();
			JOptionPane.showMessageDialog(null,"Arquivo " + this.nomeDoArquivo + " criado!", "Arquivo",1 );
			control = true;
		}
		catch (Exception erro){
			JOptionPane.showMessageDialog(null, "Arquivo não põde ser gerado");
		}
	}
}
