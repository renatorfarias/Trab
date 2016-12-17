package prova;

import java.util.Random;import java.util.Scanner;
import javax.swing.JOptionPane;

public class Prova {
    public static void main(String[] args) {
        int habilidade; //Faz a comparação com o valor inteiro amazenado para saber qual hailidade o herṕi utilizou. Linha 36
        int escolha; //Variável interia para fazer comparações e saber qual herói o Jogador escolheu. Linha 25 
        int a = 0; //Parâmetro para printar se o Vencedor foi o herói ou o Monstro
        int i; //Parâmetro para saber qual ataque o monstro vai exectuar (valor randomico)
        int countH = 0; //Contador que irá permitir executar o ataque especial dos herois quando o mesmo atingir um valor específico]  
        int countM = 0; //Contador que irá permitir executar o ataque especial dos monstros quando o mesmo atingir um valor específico]
    	Random rand = new Random();
        Scanner scan = new Scanner (System.in);
        Monstros dragon = new Dragao(); //Criandi o objeto Dragão
        Monstros gigante = new Gigante(); //Criando o objeto Gigante
        Monstros bomba = new Moises_Bomba(); //Criando o objeto Bomba
        dragon.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do dragão 
        dragon.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do dragão
        gigante.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do gigante
        gigante.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do gigante
        bomba.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do bomba
        bomba.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do bomba
        Object[] herois = {"Mage", "Tanker", "Arqueiro", "Sniper"};
        escolha = JOptionPane.showOptionDialog(null, "Selecione uma classe para escolher o seu herói", " ", JOptionPane.DEFAULT_OPTION, 3, null, herois, herois[0]);
        
        if (escolha == 0){
        	Mago mago = new Mago();
        	mago.setClasse("Mago"); //Atribuição da Classe ao personagem
        	mago.setTipo("Magic Power"); //Atribuição do Tipo de personagem
        	mago.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            mago.setAtaque(rand.nextInt(10)); //valor randomico para o ataque do mago
            mago.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do mago
            JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Classe: " + mago.getClasse() + "\n"  + "Tipo de Dano: " + mago.getTipo() + "\n" + "Vida: " + mago.getVida() + "\n" + "Ataque: " + mago.getAtaque() + "\n" + "Defesa: " + mago.getDefesa() + "\n" + "Habilidade Primária: " + mago.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + mago.getNomeGolpeSecundario() + "\n" + "Ultimate: " + mago.getNomeDoEspecial() + "\n" + "*******************************" + "\n" + dragon.getNome() + "\n" + "Ataque: " + dragon.getAtaque() + "\n" + "Defesa: " + dragon.getDefesa() + "\n" + "Habilidade Primária: " + dragon.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + dragon.getNomeGolpeSecundario() + "\n" + "Especial: " + dragon.getNomeDoEspecial(), "Detalhes da Batalha: ", 1); //printar os atributos do mago e do monstro.
            JOptionPane.showMessageDialog(null, "Que comece a batalha!");
            
            while(true){
            	JOptionPane.showMessageDialog(null, "Sua vez de jogar");
            	Object[] golpesDoHeroi= {(mago.getNomeGolpePrimario()), (mago.getNomeGolpeSecundario()), (mago.getNomeDoEspecial())};
            	habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesDoHeroi, golpesDoHeroi[0]);
            	
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		mago.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		mago.golpeSecundario(); //Se aplica o método golpePrimario()
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		mago.golpeEspecial(); //Se aplica o método golpeUltimate()
            	}
            	
               	if(mago.getVida() <= 0){
                    a = 0;
                    JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
                    break;
            	} else if (dragon.getVida() <= 0){
                    a = 1;
                    JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
                    break;
            	}

               	JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
               	JOptionPane.showMessageDialog(null, "Eu invoco...");
               	//Gambiarra para usar tru Catch
               	i = rand.nextInt(3);
               	if(countM > 4){
               		switch (i){ //Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
               			case 0: JOptionPane.showMessageDialog(null, dragon.getNomeGolpePrimario()); //Printar o ataque primário
               					countM++;
               					break;
               			case 1: JOptionPane.showMessageDialog(null, dragon.getNomeGolpeSecundario()); //Printar o ataque Secundário
               					countM++;
               					break;
               			case 2: JOptionPane.showMessageDialog(null, dragon.getNomeDoEspecial()); //Printar o ataque Especial 
								countM++;	
								break;
               		}
               	} else {
               		i = rand.nextInt(2); //Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
               		switch (i){//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
               			case 0: JOptionPane.showMessageDialog(null, dragon.getNomeGolpePrimario()); //Printar o ataque primário
               					countM++;
               					break;
               			case 1: JOptionPane.showMessageDialog(null, dragon.getNomeGolpeSecundario()); //Printar o ataque secundário 
               					countM++;
               					break;
               		}
               	}
               	countM = 0;
               	                    	
            	if(mago.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
                    a = 0;
                    JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
                    break;
            	} else if (dragon.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
                    a = 1;
                    JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
                    break;
            	}
            }
            
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + mago.getNome() + "\n" + "\n"+"Ataque: " + mago.getAtaque() + "\n" + "Defesa: " + mago.getDefesa() + "\n" + "Vida: " + mago.getVida() + "*******************************" + "\n" + "Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
           		//JOptionPane.showMessageDialog(null, "//frase de vitoria do dragão"
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + dragon.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
          		JOptionPane.showMessageDialog(null, "Vencedor: " + dragon.getNome() + "n" + "Vida: " + dragon.getVida() + "*******************************" + "\n" + "Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
           		//JOptionPane.showMessageDialog(null, "//frase de derrota do dragão"
           	}
        }
        
        if (escolha == 1){
            Guerreiro guerreiro = new Guerreiro();
            guerreiro.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            guerreiro.setAtaque(rand.nextInt(10)); //valor randomico para o ataque do mago
            guerreiro.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do mago
            JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + "Ataque: " + guerreiro.getAtaque() + "\n" + "Defesa: " + guerreiro.getDefesa() + "\n" + "Habilidade Primária: " + guerreiro.getNomeGolpePrimario() + "Habilidade Secundária: " + guerreiro.getNomeGolpeSecundario() + "\n" + "Ultimate: " + guerreiro.getNomeDoEspecial() + "*******************************" + "\n" + gigante.getNome() + "\n" + "Ataque: " + gigante.getAtaque() + "\n" + "Defesa: " + gigante.getDefesa() + "Habilidade Primária: " + gigante.getNomeGolpePrimario() + "Habilidade Secundária: " + gigante.getNomeGolpeSecundario() + "\n" + "Ultimate: " + gigante.getNomeDoEspecial(), "Adversários da batalha: ", 1); //printar os atributos do mago e do monstro.
            JOptionPane.showMessageDialog(null, "Que comece a batalha!");
            
            while(true){
            	Object[] golpesDoHeroi= {guerreiro.getNomeGolpePrimario(), guerreiro.getNomeGolpeSecundario(), guerreiro.getNomeDoEspecial()};
            	habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesDoHeroi, golpesDoHeroi[0]);
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		guerreiro.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		guerreiro.golpeSecundario(); //Se aplica o método golpePrimario()
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		guerreiro.golpeEspecial(); //Se aplica o método golpeUltimate()
            	}
            	
               	if(guerreiro.getVida() <= 0){
                    a = 0;
                    JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + gigante.getNome() + "\n" + "Vida: " + gigante.getVida());
                    break;
            	} else if (gigante.getVida() <= 0){
                    a = 1;
                    JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + gigante.getNome() + "\n" + "Vida: " + gigante.getVida());
                    break;
            	}

               	JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
               	JOptionPane.showMessageDialog(null, "Eu invoco...");
            	i = rand.nextInt(3);
            	if(countM > 4){
               		switch (i){ //Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
               			case 0: JOptionPane.showMessageDialog(null, dragon.getNomeGolpePrimario()); //Printar o ataque primário
               					countM++;
               					break;
               			case 1: JOptionPane.showMessageDialog(null, dragon.getNomeGolpeSecundario()); //Printar o ataque Secundário
               					countM++;
               					break;
               			case 2: JOptionPane.showMessageDialog(null, dragon.getNomeDoEspecial()); //Printar o ataque Especial 
								countM++;	
								break;
               		}
               	} else {
               		i = rand.nextInt(2); //Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
               		switch (i){//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
               			case 0: JOptionPane.showMessageDialog(null, dragon.getNomeGolpePrimario()); //Printar o ataque primário
               					countM++;
               					break;
               			case 1: JOptionPane.showMessageDialog(null, dragon.getNomeGolpeSecundario()); //Printar o ataque secundário 
               					countM++;
               					break;
               		}
               	}
               	countM = 0;
               	
            	if(guerreiro.getVida() <= 0){
                    a = 0;
                    JOptionPane.showMessageDialog(null, gigante.getNome() + "\n" + "Vida: " + gigante.getVida() + "\n" + gigante.getNome() + "\n" + "Vida: " + gigante.getVida());
                    break;
            	} else if (gigante.getVida() <= 0){
                    a = 1;
                    JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + guerreiro.getNome() + "\n" + "Vida: " + gigante.getVida());
                    break;
            	}
            }
            
           	if(a == 1){
           		JOptionPane.showMessageDialog(null, "Vencedor: " + guerreiro.getNome() + "\n" + "\n"+"Ataque: " + guerreiro.getAtaque() + "\n" + "Defesa: " + guerreiro.getDefesa() + "\n" + "Vida: " + guerreiro.getVida() + "*******************************" + "\n" + "Perdedor: " +  gigante.getNome() + "\n" + "Vida: " + gigante.getVida());
           		//JOptionPane.showMessageDialog(null, "//frase de vitoria do gigante"
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + gigante.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           	} else if(a == 0){
           		JOptionPane.showMessageDialog(null, "Vencedor: " + gigante.getNome() + "n" + "Vida: " + gigante.getVida() + "*******************************" + "\n" + "Perdedor: " +  gigante.getNome() + "\n" + "Vida: " + gigante.getVida());
           		JOptionPane.showMessageDialog(null, "Derrota!!");
           		//JOptionPane.showMessageDialog(null, "//frase de derrota do gigante"
           	}
        }
        
        if (escolha == 2){
            Arqueiro arqueiro = new Arqueiro();
            arqueiro.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            arqueiro.setAtaque(rand.nextInt(10)); //valor randomico para o ataque do mago
            arqueiro.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do mago
            JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + "Ataque: " + arqueiro.getAtaque() + "\n" + "Defesa: " + arqueiro.getDefesa() + "\n" + "Habilidade Primária: " + arqueiro.getNomeGolpePrimario() + "Habilidade Secundária: " + arqueiro.getNomeGolpeSecundario() + "\n" + "Ultimate: " + arqueiro.getNomeDoEspecial() + "*******************************" + "\n" + bomba.getNome() + "\n" + "Ataque: " + bomba.getAtaque() + "\n" + "Defesa: " + bomba.getDefesa() + "Habilidade Primária: " + bomba.getNomeGolpePrimario() + "Habilidade Secundária: " + bomba.getNomeGolpeSecundario() + "\n" + "Ultimate: " + bomba.getNomeDoEspecial(), "Adversários da batalha: ", 1); //printar os atributos do mago e do monstro.
            JOptionPane.showMessageDialog(null, "Que comece a batalha!");
            
            while(true){
            	Object[] golpesDoHeroi= {arqueiro.getNomeGolpePrimario(), arqueiro.getNomeGolpeSecundario(), arqueiro.getNomeDoEspecial()};
            	habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesDoHeroi, golpesDoHeroi[0]);
            	
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		arqueiro.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		arqueiro.golpeSecundario(); //Se aplica o método golpePrimario()
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		arqueiro.golpeEspecial(); //Se aplica o método golpeUltimate()
            	}
            	
               	if(arqueiro.getVida() <= 0){
                    a = 0;
                    JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + bomba.getNome() + "\n" + "Vida: " + bomba.getVida());
                    break;
            	} else if (bomba.getVida() <= 0){
                    a = 1;
                    JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + bomba.getNome() + "\n" + "Vida: " + bomba.getVida());
                    break;
            	}

               	JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
               	JOptionPane.showMessageDialog(null, "Eu invoco...");
            	i = rand.nextInt(3);
            	if(countM > 4){
               		switch (i){ //Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
               			case 0: JOptionPane.showMessageDialog(null, dragon.getNomeGolpePrimario()); //Printar o ataque primário
               					countM++;
               					break;
               			case 1: JOptionPane.showMessageDialog(null, dragon.getNomeGolpeSecundario()); //Printar o ataque Secundário
               					countM++;
               					break;
               			case 2: JOptionPane.showMessageDialog(null, dragon.getNomeDoEspecial()); //Printar o ataque Especial 
								countM++;	
								break;
               		}
               	} else {
               		i = rand.nextInt(2); //Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
               		switch (i){//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
               			case 0: JOptionPane.showMessageDialog(null, dragon.getNomeGolpePrimario()); //Printar o ataque primário
               					countM++;
               					break;
               			case 1: JOptionPane.showMessageDialog(null, dragon.getNomeGolpeSecundario()); //Printar o ataque secundário 
               					countM++;
               					break;
               		}
               	}
               	countM = 0;
               	
            	if(arqueiro.getVida() <= 0){
                    a = 0;
                    JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + bomba.getNome() + "\n" + "Vida: " + bomba.getVida());
                    break;
            	} else if (arqueiro.getVida() <= 0){
                    a = 1;
                    JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + bomba.getNome() + "\n" + "Vida: " + bomba.getVida());
                    break;
            	}
            }
            
           	if(a == 1){
           		JOptionPane.showMessageDialog(null, "Vencedor: " + arqueiro.getNome() + "\n" + "\n"+"Ataque: " + arqueiro.getAtaque() + "\n" + "Defesa: " + arqueiro.getDefesa() + "\n" + "Vida: " + arqueiro.getVida() + "*******************************" + "\n" + "Perdedor: " +  bomba.getNome() + "\n" + "Vida: " + bomba.getVida());
           		//JOptionPane.showMessageDialog(null, "//frase de vitoria do dragão"
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + bomba.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           	} else if(a == 0){
           		JOptionPane.showMessageDialog(null, "Vencedor: " + bomba.getNome() + "n" + "Vida: " + bomba.getVida() + "*******************************" + "\n" + "Perdedor: " +  bomba.getNome() + "\n" + "Vida: " + bomba.getVida());
           		JOptionPane.showMessageDialog(null, "Derrota!!");
           		//JOptionPane.showMessageDialog(null, "//frase de derrota do dragão"
           	}
        }
    }
}


/*
        if (escolha == 3) //Podemos colocar mais classes de herois
            g.setNome("Lennonidas");
        if (escolha == 4)
            g.setNome("Maysés");
        if (escolha == 5)
            g.setNome("Doisqueixos");
        Object[] cor = {"Azul", "Vermelho"};
        int op = JOptionPane.showOptionDialog(null, "Selecione a cor do Guerreiro:", "Cor do Guerreiro ", JOptionPane.DEFAULT_OPTION, 3, null, cor, g);
        if(op==0)
            g.setCor("Azul");
        else if(op==1)
            g.setCor("Vermelho");
    }
}
*/

abstract class Personagem{
    private int ataque, defesa, pontuacao, vida = 10;
    private String nome;
    private int golpePrimario; //habilidade primaria
    private int golpeSecundario; //habilidade secundaria
    private int golpeEspecial; //ultimate
    private String nomeGolpePrimario; //nome da primeira habilidade
    private String nomeGolpeSecundario; //nome da segunda habilidade
    private String nomeDoEspecial; //nome da ultimate

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    
    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNomeGolpePrimario() {
        return nomeGolpePrimario;
    }

    public int getDanoGolpePrimario() {
        return golpePrimario;
    }
    
    public void setDanoGolpePrimario(int golpePrimario) {
        this.golpePrimario = golpePrimario;
    }
        
    public String getNomeGolpeSecundario() {
    	return nomeGolpeSecundario;    	
    }
    
    public int getDanoDoGolpeSecundario() {
        return golpeSecundario;
    }

    public void setDanoDoGolpeSecundario(int golpeSecundario) {
        this.golpeSecundario = golpeSecundario;
    }

    public String getNomeDoEspecial() {
        return nomeDoEspecial;
    }
    
    public int getDanoDoEspecial() {
        return golpeEspecial;
    }

    public void setGolpeEspecial(int golpeEspecial) {
        this.golpeEspecial= golpeEspecial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
	void golpePrimario(){
		
	}
	
	void golpeSecundario(){
		
	}
	
	void golpeEspecial(){
		
	}
	
}

class Herois extends Personagem{
    int experiencia, nivel = 0;
    private String classe;
	private String tipo;
	
	public String getTipo(){
		return tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
    public String getClasse(){
    	return classe;
    }
    
    public void setClasse(String classe){
    	this.classe = classe;
    }
}

class Mago extends Herois{
	
}


class Arqueiro extends Herois{
	
}
  
class Sniper extends Herois{

}

class Guerreiro extends Herois{
	
}

class Monstros extends Personagem{
	private String mensagemDeVitoria = "";
	private String mensagemDeDerrota = "";
	public String getMensagemDeVitoria(){
		return "";
	}
	public String getMensagemDeDerrota(){
		return "";
	}
}

class Dragao extends Monstros{
	@Override
	public String getMensagemDeVitoria(){
		return "//frase de vitoria";
	}
	
	@Override
	public String getMensagemDeDerrota(){
		return "//frase de vitoria";
	}
}

class Gigante extends Monstros{
	@Override
	public String getMensagemDeVitoria(){
		return "//frase de vitoria";
	}
	
	@Override
	public String getMensagemDeDerrota(){
		return "//frase de vitoria";
	}
}

class Moises_Bomba extends Monstros{
	@Override
	public String getMensagemDeVitoria(){
		return "//frase de vitoria";
	}
	
	@Override
	public String getMensagemDeDerrota(){
		return "//frase de vitoria";
	}
}
