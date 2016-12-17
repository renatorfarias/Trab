package prova;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;;
public class Prova {
    public static void main(String[] args) {
    	LerTxt lertxt = new LerTxt();
    	CriarTxt criartxt = new CriarTxt();
    	loginDoJogo login = new loginDoJogo();
    	lertxt.LerTXT();
    	criartxt.CriarTXT();
    	
    	login.login();
    	int habilidade = 0;
         //Faz a comparação com o valor inteiro amazenado para saber qual hailidade o herṕi utilizou. Linha 36
        int escolha; //Variável interia para fazer comparações e saber qual herói o Jogador escolheu. Linha 25 
        int a = 0; //Parâmetro para printar se o Vencedor foi o herói ou o Monstro
        int i; //Parâmetro para saber qual ataque o monstro vai exectuar (valor randomico)
        int countH = 0;
         //Contador que irá permitir executar o ataque especial dos herois quando o mesmo atingir um valor específico  
        int countM = 0;
         //Contador que irá permitir executar o ataque especial dos monstros quando o mesmo atingir um valor específico]
        int option; //Variável utilizada quando o personagem morre. Linha 198
    	Random rand = new Random();
        Scanner scan = new Scanner (System.in);
        Monstros dragon = new Dragao(); //Criandi o objeto Dragão
        Monstros gigante = new Gigante(); //Criando o objeto Gigante
        Monstros kraken = new Kraken(); //Criando o objeto Bomba
        dragon.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do dragão 
        dragon.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do dragão
        gigante.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do gigante
        gigante.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do gigante
        kraken.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do bomba
        kraken.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do bomba
        JOptionPane.showMessageDialog(null, "Você só possui uma vida");
        JOptionPane.showMessageDialog(null, "Jogue com sabedoria...");
        Object[] herois = {"Mage", "Tanker", "Arqueiro", "Sniper"};
        escolha = JOptionPane.showOptionDialog(null, "Selecione uma classe para escolher o seu herói", " ", JOptionPane.DEFAULT_OPTION, 3, null,
        		herois, herois[0]);
        
        if (escolha == 0){
        	Mago mago = new Mago();
        	mago.setClasse("Mago"); //Atribuição da Classe ao personagem
        	mago.setTipo("Magic Power"); //Atribuição do Tipo de personagem
        	mago.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            mago.setAtaque(rand.nextInt(10)); //valor randomico para o ataque do mago
            mago.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do mago
            JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Classe: " + mago.getClasse() + "\n"  + "Tipo de Dano: " + mago.getTipo() +
            		"\n" + "Vida: " + mago.getVida() + "\n" + "Ataque: " + mago.getAtaque() + "\n" + "Defesa: " + mago.getDefesa() + "\n" +
            		"Habilidade Primária: " + mago.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + mago.getNomeGolpeSecundario() +
            		"\n" + "Ultimate: " + mago.getNomeDoEspecial() + "\n" + "*******************************" + "\n" + dragon.getNome() + "\n" +
            		"Ataque: " + dragon.getAtaque() + "\n" + "Defesa: " + dragon.getDefesa() + "\n" + "Habilidade Primária: " +
            		dragon.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + dragon.getNomeGolpeSecundario() + "\n" + "Especial: " +
            		dragon.getNomeDoEspecial(), "Detalhes da Batalha: ", 1); //printar os atributos do mago e do monstro.
            JOptionPane.showMessageDialog(null, "Que comece a batalha!");
            
            while(true){
            	JOptionPane.showMessageDialog(null, "Sua vez de jogar");
            	Object[] golpesDoHeroi= {mago.getNomeGolpePrimario(), mago.getNomeGolpeSecundario(), mago.getNomeDoEspecial()};
            	Object[] golpesDoHeroiSEspecial = {(mago.getNomeGolpePrimario()), (mago.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		mago.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		mago.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		mago.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
            	
               	if(mago.getVida() <= 0){
                    a = 0;
                    JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + dragon.getNome() + "\n" +
                    "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 39
            	} else if (dragon.getVida() <= 0){
                    a = 1; 
                    JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + dragon.getNome() + "\n" +
                    "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 39
            	}

               	JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
               	JOptionPane.showMessageDialog(null, "Eu invoco...");
               	//Gambiarra para usar tru Catch
               	i = rand.nextInt(3);
               	if(countM > 4){
               		switch (i){
               		//Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
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
               		i = rand.nextInt(2); 
               		//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
               		switch (i){
               		//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
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
                    JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + dragon.getNome() + "\n" +
                    "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 39
            	} else if (dragon.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
                    a = 1;
                    JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + dragon.getNome() + "\n" +
                    "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 39
            	}
            }
            
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + mago.getNome() + "\n" + "\n"+"Ataque: " + mago.getAtaque() + "\n" + "Defesa: " +
           		mago.getDefesa() + "\n" + "Vida: " + mago.getVida() + "*******************************" + "\n" + "Perdedor: " +  dragon.getNome() +
           		"\n" + "Vida: " + dragon.getVida());
           		JOptionPane.showMessageDialog(null, dragon.getMensagemDeVitoria()); //printar frase de vitória do oponente
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + gigante.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
          		JOptionPane.showMessageDialog(null, "Vencedor: " + dragon.getNome() + "n" + "Vida: " + dragon.getVida() +
          				"*******************************" + "\n" + "Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
          		JOptionPane.showMessageDialog(null, dragon.getMensagemDeDerrota()); //printar frase de derrota do oponente
          		Object[] tentarNovamente = {"Sim", "Desistir"};
          		option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
          				tentarNovamente[0]);
          	}
        
           	JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Classe: " + mago.getClasse() + "\n"  + "Tipo de Dano: " + mago.getTipo() +
           			"\n" + "Vida: " + mago.getVida() + "\n" + "Ataque: " + mago.getAtaque() + "\n" + "Defesa: " + mago.getDefesa() + "\n" +
           			"Habilidade Primária: " + mago.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + mago.getNomeGolpeSecundario() +
           			"\n" + "Ultimate: " + mago.getNomeDoEspecial() + "\n" + "*******************************" + "\n" + gigante.getNome() + "\n" +
           			"Ataque: " + gigante.getAtaque() + "\n" + "Defesa: " + gigante.getDefesa() + "\n" + "Habilidade Primária: " +
           			gigante.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + gigante.getNomeGolpeSecundario() + "\n" + "Especial: " +
           			gigante.getNomeDoEspecial(), "Detalhes da Batalha: ", 1); //printar os atributos do mago e do monstro.
           	JOptionPane.showMessageDialog(null, "Que comece a batalha!");
        
           	while(true){
           		JOptionPane.showMessageDialog(null, "Sua vez de jogar");
           		Object[] golpesDoHeroi= {(mago.getNomeGolpePrimario()), (mago.getNomeGolpeSecundario()), (mago.getNomeDoEspecial())};
            	Object[] golpesDoHeroiSEspecial = {(mago.getNomeGolpePrimario()), (mago.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		mago.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		mago.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		mago.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
           		
           		if(mago.getVida() <= 0){
           			a = 0;
           			JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + gigante.getNome() + "\n" +
           			"Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 126
           		} else if (gigante.getVida() <= 0){
           			a = 1;
           			JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + gigante.getNome() + "\n" +
           			"Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 126
           		}
           		
           		JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
           		JOptionPane.showMessageDialog(null, "Eu invoco...");
           		//Gambiarra para usar tru Catch
           		i = rand.nextInt(3);
           		if(countM > 4){
           			switch (i){
           			//Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
           			case 0: JOptionPane.showMessageDialog(null, gigante.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, gigante.getNomeGolpeSecundario()); //Printar o ataque Secundário
           						countM++;
           						break;
           				case 2: JOptionPane.showMessageDialog(null, gigante.getNomeDoEspecial()); //Printar o ataque Especial 
           				countM++;	
								break;
           			}
           		} else {
           			i = rand.nextInt(2); 
           			//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
           			switch (i){
           			//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
           				case 0: JOptionPane.showMessageDialog(null, gigante.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, gigante.getNomeGolpeSecundario()); //Printar o ataque secundário 
           						countM++;
           						break;
           			}
           		}
           		countM = 0;
           	                    	
           		if(mago.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
           			a = 0;
           			JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + gigante.getNome() + "\n" +
           			"Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 126
           		} else if (gigante.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
           			a = 1;
           			JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + gigante.getNome() + "\n" +
           			"Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 126
           		}
           	}
           	
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + mago.getNome() + "\n" + "\n"+"Ataque: " + mago.getAtaque() + "\n" + "Defesa: " +
           		mago.getDefesa() + "\n" + "Vida: " + mago.getVida() + "*******************************" + "\n" + "Perdedor: " +  dragon.getNome() +
           		"\n" + "Vida: " + dragon.getVida());
           		JOptionPane.showMessageDialog(null, gigante.getMensagemDeVitoria()); //printar frase de vitória do oponente
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + kraken.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + gigante.getNome() + "n" + "Vida: " + gigante.getVida() +
           				"*******************************" + "\n" + "Perdedor: " +  mago.getNome() + "\n" + "Vida: " + mago.getVida());
           		JOptionPane.showMessageDialog(null, gigante.getMensagemDeDerrota()); //printar frase de derrota do oponente
           		Object[] tentarNovamente = {"Sim", "Desistir"};
           		option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
           				tentarNovamente[0]);
           	}
           	
           	JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Classe: " + mago.getClasse() + "\n"  + "Tipo de Dano: " + mago.getTipo() +
           			"\n" + "Vida: " + mago.getVida() + "\n" + "Ataque: " + mago.getAtaque() + "\n" + "Defesa: " + mago.getDefesa() + "\n" +
           			"Habilidade Primária: " + mago.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + mago.getNomeGolpeSecundario() +
           			"\n" + "Ultimate: " + mago.getNomeDoEspecial() + "\n" + "*******************************" + "\n" + kraken.getNome() + "\n" +
           			"Ataque: " + kraken.getAtaque() + "\n" + "Defesa: " + kraken.getDefesa() + "\n" + "Habilidade Primária: " +
           			kraken.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + kraken.getNomeGolpeSecundario() + "\n" + "Especial: " +
           			kraken.getNomeDoEspecial(), "Detalhes da Batalha: ", 1); //printar os atributos do mago e do monstro.
           	JOptionPane.showMessageDialog(null, "Que comece a batalha!");
           	
           	while(true){
           		JOptionPane.showMessageDialog(null, "Sua vez de jogar");
           		Object[] golpesDoHeroi= {(mago.getNomeGolpePrimario()), (mago.getNomeGolpeSecundario()), (mago.getNomeDoEspecial())};
            	Object[] golpesDoHeroiSEspecial = {(mago.getNomeGolpePrimario()), (mago.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, 
            			golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		mago.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		mago.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		mago.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
           		
           		if(mago.getVida() <= 0){
           			a = 0;
           			JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + kraken.getNome() + "\n" +
           			"Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 213
           		} else if (gigante.getVida() <= 0){
           			a = 1;
           			JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + kraken.getNome() + "\n" +
           			"Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 213
           		}
           		
           		JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
           		JOptionPane.showMessageDialog(null, "Eu invoco...");
           		//	Gambiarra para usar tru Catch
           		i = rand.nextInt(3);
           		if(countM > 4){
           			switch (i){
           			//Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
           			case 0: JOptionPane.showMessageDialog(null, kraken.getNomeGolpePrimario()); //Printar o ataque primário
           					countM++;
           					break;
           			case 1: JOptionPane.showMessageDialog(null, kraken.getNomeGolpeSecundario()); //Printar o ataque Secundário
           					countM++;
           					break;
           			case 2: JOptionPane.showMessageDialog(null, kraken.getNomeDoEspecial()); //Printar o ataque Especial 
							countM++;	
							break;
           			}
           		} else {
           			i = rand.nextInt(2);
           			//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
           			switch (i){
           			//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
           				case 0: JOptionPane.showMessageDialog(null, kraken.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, kraken.getNomeGolpeSecundario()); //Printar o ataque secundário 
           						countM++;
           						break;
           			}
           		}
           		countM = 0;
           	                    	
           		if(mago.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
           			a = 0;
           			JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + kraken.getNome() + "\n" +
           			"Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 213
           		} else if (kraken.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
           			a = 1;
           			JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + kraken.getNome() + "\n" +
           			"Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 213
           		}
           	}	        
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + mago.getNome() + "\n" + "\n"+"Ataque: " + mago.getAtaque() + "\n" + "Defesa: " +
           		mago.getDefesa() + "\n" + "Vida: " + mago.getVida() + "*******************************" + "\n" + "Perdedor: " +  dragon.getNome() +
           		"\n" + "Vida: " + dragon.getVida());
           		JOptionPane.showMessageDialog(null, kraken.getMensagemDeVitoria()); //printar frase de vitória do oponente
           		JOptionPane.showMessageDialog(null, "Congratulations");
           		JOptionPane.showMessageDialog(null, "You has finished this game. You are the best player of the UFPA");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + kraken.getNome() + "n" + "Vida: " + kraken.getVida() +
           				"*******************************" + "\n" + "Perdedor: " +  kraken.getNome() + "\n" + "Vida: " + kraken.getVida());
           		JOptionPane.showMessageDialog(null, kraken.getMensagemDeDerrota()); //printar frase de derrota do oponente
           		Object[] tentarNovamente = {"Sim", "Desistir"};
           		option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
           				tentarNovamente[0]);
           
//Falta a ajeitar para reiniciar o game
           		
           	}
           	
        }
        
        if (escolha == 1){
            Guerreiro guerreiro = new Guerreiro();
            guerreiro.setClasse("Guerreiro"); //Atribuição da Classe ao personagem
            guerreiro.setTipo("Physical Damage"); //Atribuição do Tipo de personagem
            guerreiro.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            guerreiro.setAtaque(rand.nextInt(10)); //valor randomico para o ataque do mago
            guerreiro.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do mago
            JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Classe: " + guerreiro.getClasse() + "\n" + "Tipo de Dano: " +
            guerreiro.getTipo() + ""+ "Vida: " + guerreiro.getVida() + "\n" + "Ataque: " + guerreiro.getAtaque() + "\n" + "Defesa: " +
            		guerreiro.getDefesa() + "\n" + "Habilidade Primária: " + guerreiro.getNomeGolpePrimario() + "Habilidade Secundária: " +
            guerreiro.getNomeGolpeSecundario() + "\n" + "Ultimate: " + guerreiro.getNomeDoEspecial() + "*******************************" +
            		"\n" + dragon.getNome() + "\n" + "Ataque: " + dragon.getAtaque() + "\n" + "Defesa: " + dragon.getDefesa() +
            		"Habilidade Primária: " + dragon.getNomeGolpePrimario() + "Habilidade Secundária: " + dragon.getNomeGolpeSecundario() +
            		"\n" + "Ultimate: " + dragon.getNomeDoEspecial(), "Adversários da batalha: ", 1); //printar os atributos do mago e do monstro.
            JOptionPane.showMessageDialog(null, "Que comece a batalha!");
            
            while(true){
            	JOptionPane.showMessageDialog(null, "Sua vez de jogar");
            	Object[] golpesDoHeroi= {(guerreiro.getNomeGolpePrimario()), (guerreiro.getNomeGolpeSecundario()), (guerreiro.getNomeDoEspecial())};
            	Object[] golpesDoHeroiSEspecial = {(guerreiro.getNomeGolpePrimario()), (guerreiro.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		guerreiro.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		guerreiro.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		guerreiro.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
            	
               	if(guerreiro.getVida() <= 0){
                    a = 0;
                    JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + dragon.getNome() +
                    		"\n" + "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 309
            	} else if (dragon.getVida() <= 0){
                    a = 1;
                    JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + dragon.getNome() +
                    		"\n" + "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 309
            	}

               	JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
               	JOptionPane.showMessageDialog(null, "Eu invoco...");
               	//Gambiarra para usar tru Catch
               	i = rand.nextInt(3);
               	if(countM > 4){
               		switch (i){ 
               		//Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
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
               		i = rand.nextInt(2);
               		//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
               		switch (i){
               		//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
               		case 0: JOptionPane.showMessageDialog(null, dragon.getNomeGolpePrimario()); //Printar o ataque primário
               					countM++;
               					break; //Quebra o while(true) da linha 309
               			case 1: JOptionPane.showMessageDialog(null, dragon.getNomeGolpeSecundario()); //Printar o ataque secundário 
               					countM++;
               					break; //Quebra o while(true) da linha 309 
               		}
               	}
               	countM = 0;
               	                    	
            	if(guerreiro.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
                    a = 0;
                    JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + dragon.getNome() + 
                    		"\n" + "Vida: " + dragon.getVida());
                    break;
            	} else if (dragon.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
                    a = 1;
                    JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + dragon.getNome() +
                    		"\n" + "Vida: " + dragon.getVida());
                    break;
            	}
            }
            
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + guerreiro.getNome() + "\n" + "\n"+"Ataque: " + guerreiro.getAtaque() + "\n" +
           		"Defesa: " + guerreiro.getDefesa() + "\n" + "Vida: " + guerreiro.getVida() + "*******************************" + "\n" +
           				"Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
           		JOptionPane.showMessageDialog(null, dragon.getMensagemDeVitoria()); //printar frase de vitória do oponente
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + gigante.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
          		JOptionPane.showMessageDialog(null, "Vencedor: " + dragon.getNome() + "n" + "Vida: " + dragon.getVida() +
          				"*******************************" + "\n" + "Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
          		JOptionPane.showMessageDialog(null, dragon.getMensagemDeDerrota()); //printar frase de derrota do oponente
          		Object[] tentarNovamente = {"Sim", "Desistir"};
          		option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
          				tentarNovamente[0]);
          	}
        
           	JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Classe: " + guerreiro.getClasse() + "\n"  + "Tipo de Dano: " +
           	guerreiro.getTipo() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + "Ataque: " + guerreiro.getAtaque() + "\n" + "Defesa: " +
           			guerreiro.getDefesa() + "\n" + "Habilidade Primária: " + guerreiro.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " +
           	guerreiro.getNomeGolpeSecundario() + "\n" + "Ultimate: " + guerreiro.getNomeDoEspecial() + "\n" + "*******************************" +
           			"\n" + gigante.getNome() + "\n" + "Ataque: " + gigante.getAtaque() + "\n" + "Defesa: " + gigante.getDefesa() + "\n" +
           	"Habilidade Primária: " + gigante.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + gigante.getNomeGolpeSecundario() + "\n" +
           			"Especial: " + gigante.getNomeDoEspecial(), "Detalhes da Batalha: ", 1); //printar os atributos do mago e do monstro.
           	JOptionPane.showMessageDialog(null, "Que comece a batalha!");
           	
           	while(true){
           		JOptionPane.showMessageDialog(null, "Sua vez de jogar");
           		Object[] golpesDoHeroi= {(guerreiro.getNomeGolpePrimario()), (guerreiro.getNomeGolpeSecundario()), (guerreiro.getNomeDoEspecial())};
            	Object[] golpesDoHeroiSEspecial = {(guerreiro.getNomeGolpePrimario()), (guerreiro.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		guerreiro.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		guerreiro.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		guerreiro.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
           		
           		if(guerreiro.getVida() <= 0){
           			a = 0;
           			JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + gigante.getNome() +
           					"\n" + "Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 396
           		} else if (gigante.getVida() <= 0){
           			a = 1;
           			JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + gigante.getNome() +
           					"\n" + "Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 396
           		}	
           		
           		JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
           		JOptionPane.showMessageDialog(null, "Eu invoco...");
           	//	Gambiarra para usar tru Catch
           		i = rand.nextInt(3);
           		if(countM > 4){
           			switch (i){
           			//Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
           				case 0: JOptionPane.showMessageDialog(null, gigante.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, gigante.getNomeGolpeSecundario()); //Printar o ataque Secundário
           						countM++;
           						break;
           				case 2: JOptionPane.showMessageDialog(null, gigante.getNomeDoEspecial()); //Printar o ataque Especial 
								countM++;	
								break;
           			}
           		} else {
           			i = rand.nextInt(2);
           			//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
           			switch (i){
           			//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
           				case 0: JOptionPane.showMessageDialog(null, gigante.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, gigante.getNomeGolpeSecundario()); //Printar o ataque secundário 
           						countM++;
           						break;
           			}
           		}
           		countM = 0;
           	                    		
           		if(guerreiro.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
           			a = 0;
           			JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + gigante.getNome() +
           					"\n" + "Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 396
           		} else if (gigante.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
           			a = 1;
           			JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + gigante.getNome() +
           					"\n" + "Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 396
           		}
           	}
           	
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + guerreiro.getNome() + "\n" + "\n"+"Ataque: " + guerreiro.getAtaque() + "\n" +
           		"Defesa: " + guerreiro.getDefesa() + "\n" + "Vida: " + guerreiro.getVida() + "*******************************" + "\n" +
           				"Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
           		JOptionPane.showMessageDialog(null, gigante.getMensagemDeVitoria()); //printar frase de vitória do oponente.
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + kraken.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           		} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           			JOptionPane.showMessageDialog(null, "DERROTA!!");
           			JOptionPane.showMessageDialog(null, "Vencedor: " + gigante.getNome() + "n" + "Vida: " + gigante.getVida() +
           					"*******************************" + "\n" + "Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
           			JOptionPane.showMessageDialog(null, gigante.getMensagemDeDerrota()); //printar frase de derrota do oponente.
           			Object	[] tentarNovamente = {"Sim", "Desistir"};
           			option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
           					tentarNovamente[0]);
           		}
      		
           	JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Classe: " + guerreiro.getClasse() + "\n"  + "Tipo de Dano: " +
           	guerreiro.getTipo() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + "Ataque: " + guerreiro.getAtaque() + "\n" + "Defesa: " +
           			guerreiro.getDefesa() + "\n" + "Habilidade Primária: " + guerreiro.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " +
           	guerreiro.getNomeGolpeSecundario() + "\n" + "Ultimate: " + guerreiro.getNomeDoEspecial() + "\n" + "*******************************" +
           			"\n" + kraken.getNome() + "\n" + "Ataque: " + kraken.getAtaque() + "\n" + "Defesa: " + kraken.getDefesa() + "\n" +
           	"Habilidade Primária: " + kraken.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + kraken.getNomeGolpeSecundario() + "\n" +
           			"Especial: " + kraken.getNomeDoEspecial(), "Detalhes da Batalha: ", 1); //printar os atributos do mago e do monstro.
           	JOptionPane.showMessageDialog(null, "Que comece a batalha!");
        	
           	while(true){
           		JOptionPane.showMessageDialog(null, "Sua vez de jogar");
           		Object[] golpesDoHeroi= {(guerreiro.getNomeGolpePrimario()), (guerreiro), (guerreiro.getNomeDoEspecial())};
            	Object[] golpesDoHeroiSEspecial = {(guerreiro.getNomeGolpePrimario()), (guerreiro.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		guerreiro.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		guerreiro.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		guerreiro.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
        	
           		if(guerreiro.getVida() <= 0){
           			a = 0;
           			JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + kraken.getNome() +
           					"\n" + "Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 396
           		} else if (gigante.getVida() <= 0){
           			a = 1;
           			JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + kraken.getNome() +
           					"\n" + "Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 483
           		}

           		JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
           		JOptionPane.showMessageDialog(null, "Eu invoco...");
           	//	Gambiarra para usar tru Catch
           		i = rand.nextInt(3);
           		if(countM > 4){
           			switch (i){
           			//Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
           				case 0: JOptionPane.showMessageDialog(null, kraken.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, kraken.getNomeGolpeSecundario()); //Printar o ataque Secundário
           						countM++;
           						break;
           				case 2: JOptionPane.showMessageDialog(null, kraken.getNomeDoEspecial()); //Printar o ataque Especial 
           						countM++;	
								break;
           			}	
           		} else {
           			i = rand.nextInt(2);
           			//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
           			switch (i){
           			//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
           				case 0: JOptionPane.showMessageDialog(null, kraken.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, kraken.getNomeGolpeSecundario()); //Printar o ataque secundário 
           						countM++;
           						break;
           			}
           		}
           		countM = 0;
           		
           		if(guerreiro.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
           			a = 0;
           			JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + kraken.getNome() +
           					"\n" + "Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 396
           		} else if (kraken.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
           			a = 1;
           			JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Vida: " + guerreiro.getVida() + "\n" + kraken.getNome() +
           					"\n" + "Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 396
           		}	
           	}
           	
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + guerreiro.getNome() + "\n" + "\n"+"Ataque: " + guerreiro.getAtaque() +
           				"\n" + "Defesa: " + guerreiro.getDefesa() + "\n" + "Vida: " + guerreiro.getVida() + "*******************************" +
           				"\n" + "Perdedor: " +  kraken.getNome() + "\n" + "Vida: " + kraken.getVida());
       			JOptionPane.showMessageDialog(null, kraken.getMensagemDeVitoria()); //printar frase de vitória do oponente
           		JOptionPane.showMessageDialog(null, "Congratulations");
           		JOptionPane.showMessageDialog(null, "You has finished this game. You are the best player of the UFPA");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + kraken.getNome() + "n" + "Vida: " + kraken.getVida() +
           				"*******************************" + "\n" + "Perdedor: " +  kraken.getNome() + "\n" + "Vida: " + kraken.getVida());
           		JOptionPane.showMessageDialog(null, kraken.getMensagemDeDerrota()); //printar frase de derrota do oponente
           		Object[] tentarNovamente = {"Sim", "Desistir"};
           		option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
           				tentarNovamente[0]);
           	}
        }
 
        if (escolha == 2){
            Arqueiro arqueiro = new Arqueiro();
            arqueiro.setClasse("Arqueiro");//Classe do tipo Arqueiro
            arqueiro.setTipo("Physical Damage");//Denife o tipo de dano
            arqueiro.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            arqueiro.setAtaque(rand.nextInt(10)); //valor randomico para o ataque do mago
            arqueiro.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do mago
            JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Classe: " + arqueiro.getClasse() + "Tipo de Dano: " +
            arqueiro.getTipo() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + "Ataque: " + arqueiro.getAtaque() + "\n" + "Defesa: " +
            		arqueiro.getDefesa() + "\n" + "Habilidade Primária: " + arqueiro.getNomeGolpePrimario() + "Habilidade Secundária: " +
            arqueiro.getNomeGolpeSecundario() + "\n" + "Ultimate: " + arqueiro.getNomeDoEspecial() + "*******************************" + "\n" +
            		dragon.getNome() + "\n" + "Ataque: " + dragon.getAtaque() + "\n" + "Defesa: " + dragon.getDefesa() + "Habilidade Primária: " +
            dragon.getNomeGolpePrimario() + "Habilidade Secundária: " + dragon.getNomeGolpeSecundario() + "\n" + "Ultimate: " +
            		dragon.getNomeDoEspecial(), "Adversários da batalha: ", 1); //printar os atributos do mago e do monstro.
            JOptionPane.showMessageDialog(null, "Que comece a batalha!");
            
            while(true){
            	JOptionPane.showMessageDialog(null, "Sua vez de jogar");
            	Object[] golpesDoHeroi= {(arqueiro.getNomeGolpePrimario()), (arqueiro.getNomeGolpeSecundario()), (arqueiro.getNomeDoEspecial())};
            	Object[] golpesDoHeroiSEspecial = {(arqueiro.getNomeGolpePrimario()), (arqueiro.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		arqueiro.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		arqueiro.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		arqueiro.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
            	
               	if(arqueiro.getVida() <= 0){
                    a = 0;
                    JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + dragon.getNome() +
                    		"\n" + "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 576
            	} else if (dragon.getVida() <= 0){
                    a = 1;
                    JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + dragon.getNome() +
                    		"\n" + "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 576
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
               		i = rand.nextInt(2);
               		//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
               		switch (i){
               		//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
               			case 0: JOptionPane.showMessageDialog(null, dragon.getNomeGolpePrimario()); //Printar o ataque primário
               					countM++;
               					break;
               			case 1: JOptionPane.showMessageDialog(null, dragon.getNomeGolpeSecundario()); //Printar o ataque secundário 
               					countM++;
               					break;
               		}
               	}
               	countM = 0;
               	                    	
            	if(arqueiro.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
                    a = 0;
                    JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + dragon.getNome() +
                    	"\n" + "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 576
            	} else if (dragon.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
                    a = 1;
                    JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + dragon.getNome() +
                    	"\n" + "Vida: " + dragon.getVida());
                    break; //Quebra o while(true) da linha 576
            	}
            }
            
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + arqueiro.getNome() + "\n" + "\n"+"Ataque: " + arqueiro.getAtaque() + "\n" +
           				"Defesa: " + arqueiro.getDefesa() + "\n" + "Vida: " + arqueiro.getVida() + "*******************************" + "\n" +
           				"Perdedor: " + dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
           		JOptionPane.showMessageDialog(null, dragon.getMensagemDeVitoria()); //printar frase de derrota do oponente
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + gigante.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
          		JOptionPane.showMessageDialog(null, "Vencedor: " + dragon.getNome() + "n" + "Vida: " + dragon.getVida() +
          				"*******************************" + "\n" + "Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
          		JOptionPane.showMessageDialog(null, dragon.getMensagemDeDerrota()); //printar frase de derrota do oponente
          		Object[] tentarNovamente = {"Sim", "Desistir"};
          		option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
          				tentarNovamente[0]);
          	}

           	JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Classe: " + arqueiro.getClasse() + "\n"  + "Tipo de Dano: " +
           			arqueiro.getTipo() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + "Ataque: " + arqueiro.getAtaque() + "\n" +
           			"Defesa: " + arqueiro.getDefesa() + "\n" + "Habilidade Primária: " + arqueiro.getNomeGolpePrimario() + "\n" +
           			"Habilidade Secundária: " + arqueiro.getNomeGolpeSecundario() + "\n" + "Ultimate: " + arqueiro.getNomeDoEspecial() + "\n" +
           			"*******************************" + "\n" + gigante.getNome() + "\n" + "Ataque: " + gigante.getAtaque() + "\n" + "Defesa: " +
           			gigante.getDefesa() + "\n" + "Habilidade Primária: " + gigante.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " +
           			gigante.getNomeGolpeSecundario() + "\n" + "Especial: " + gigante.getNomeDoEspecial(), "Detalhes da Batalha: ", 1);
           			//printar os atributos do mago e do monstro.
           	JOptionPane.showMessageDialog(null, "Que comece a batalha!");
           	
           	while(true){
           		JOptionPane.showMessageDialog(null, "Sua vez de jogar");
           		Object[] golpesDoHeroi= {(arqueiro.getNomeGolpePrimario()), (arqueiro.getNomeGolpeSecundario()), (arqueiro.getNomeDoEspecial())};
            	Object[] golpesDoHeroiSEspecial = {(arqueiro.getNomeGolpePrimario()), (arqueiro.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		arqueiro.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		arqueiro.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		arqueiro.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
           		
           		if(arqueiro.getVida() <= 0){
           			a = 0;
           			JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + gigante.getNome() +
           					"\n" + "Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 663
           		} else if (gigante.getVida() <= 0){
           			a = 1;
           			JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + gigante.getNome() +
           					"\n" + "Vida: " + gigante.getVida());
                	break; //Quebra o while(true) da linha 663
           		}
           		
           		JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
           		JOptionPane.showMessageDialog(null, "Eu invoco...");
           	//	Gambiarra para usar tru Catch
           		i 	= rand.nextInt(3);
           		if(countM > 4){
           			switch (i){
           			//Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
           				case 0: JOptionPane.showMessageDialog(null, gigante.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, gigante.getNomeGolpeSecundario()); //Printar o ataque Secundário
           						countM++;
           						break;
           				case 2: JOptionPane.showMessageDialog(null, gigante.getNomeDoEspecial()); //Printar o ataque Especial 
								countM++;	
								break;
           			}
           		} else {
           			i = rand.nextInt(2); 
           			//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
           			switch (i){
           			//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
           				case 0: JOptionPane.showMessageDialog(null, gigante.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, gigante.getNomeGolpeSecundario()); //Printar o ataque secundário 
           						countM++;
           						break;
           			}
           		}
           		countM = 0;
           		
           		if(arqueiro.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
           			a = 0;
           			JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + gigante.getNome() +
           					"\n" + "Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 663
           		} else if (gigante.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
           			a = 1;
           			JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + gigante.getNome() +
           					"\n" + "Vida: " + gigante.getVida());
           			break; //Quebra o while(true) da linha 663
           		}
           	}
           	
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + arqueiro.getNome() + "\n" + "\n"+"Ataque: " + arqueiro.getAtaque() +
           				"\n" + "Defesa: " + arqueiro.getDefesa() + "\n" + "Vida: " + arqueiro.getVida() + "*******************************" +
           				"\n" + "Perdedor: " +  dragon.getNome() + "\n" + "Vida: " + dragon.getVida());
           		JOptionPane.showMessageDialog(null, gigante.getMensagemDeVitoria()); //printar frase de vitória do oponente
           		JOptionPane.showMessageDialog(null, "Parabéns!! \nPróxima fase: " + kraken.getNome());
           		JOptionPane.showMessageDialog(null, "Boa sorte!! \n(Vai precisar...)");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + gigante.getNome() + "n" + "Vida: " + gigante.getVida() +
           				"*******************************" + "\n" + "Perdedor: " +  gigante.getNome() + "\n" + "Vida: " + gigante.getVida());
           		JOptionPane.showMessageDialog(null, gigante.getMensagemDeDerrota()); //printar frase de derrota do oponente
           		Object	[] tentarNovamente = {"Sim", "Desistir"};
      			option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
      					tentarNovamente[0]);
           	}
           	
           	JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Classe: " + arqueiro.getClasse() + "\n"  + "Tipo de Dano: " +
           	arqueiro.getTipo() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + "Ataque: " + arqueiro.getAtaque() + "\n" + "Defesa: " +
           			arqueiro.getDefesa() + "\n" + "Habilidade Primária: " + arqueiro.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " +
           	arqueiro.getNomeGolpeSecundario() + "\n" + "Ultimate: " + arqueiro.getNomeDoEspecial() + "\n" + "*******************************" +
           			"\n" + kraken.getNome() + "\n" + "Ataque: " + kraken.getAtaque() + "\n" + "Defesa: " + kraken.getDefesa() + "\n" +
           	"Habilidade Primária: " + kraken.getNomeGolpePrimario() + "\n" + "Habilidade Secundária: " + kraken.getNomeGolpeSecundario() + "\n" +
           			"Especial: " + kraken.getNomeDoEspecial(), "Detalhes da Batalha: ", 1); //printar os atributos do mago e do monstro.
           	JOptionPane.showMessageDialog(null, "Que comece a batalha!");
        
           	while(true){
           		JOptionPane.showMessageDialog(null, "Sua vez de jogar");
           		Object[] golpesDoHeroi= {(arqueiro.getNomeGolpePrimario()), (arqueiro.getNomeGolpeSecundario()), (arqueiro.getNomeDoEspecial())};
            	Object[] golpesDoHeroiSEspecial = {(arqueiro.getNomeGolpePrimario()), (arqueiro.getNomeGolpeSecundario())};
            	if(countH >= 2){
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroi, golpesDoHeroi[0]);
            	} else {
            		habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null,
            				golpesDoHeroiSEspecial, golpesDoHeroiSEspecial[0]);
            	}
            	if(habilidade == 0){ //Comparação: se a habilidade secelcionada for o golpe primário
            		arqueiro.golpePrimario(); //Comparação: se a habilidade secelcionada for o golpe primário
            		countH++;//contador para disponibilizar o uso do poder especial
            	} else if (habilidade == 1){ ////Comparação: se a habilidade secelcionada for o golpe secundário
            		arqueiro.golpeSecundario(); //Se aplica o método golpePrimario()
            		countH++;
            	} else if (habilidade == 2){ ////Comparação: se a habilidade secelcionada for o golpe ultimate
            		arqueiro.golpeEspecial(); //Se aplica o método golpeUltimate()
            		countH = 0;
            	}
           		
           		if(arqueiro.getVida() <= 0){
           			a = 0;
                JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + kraken.getNome() +
                		"\n" + "Vida: " + kraken.getVida());
                	break; //Quebra o while(true) da linha 750
           		} else if (gigante.getVida() <= 0){
           			a = 1;
           			JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + kraken.getNome() +
           					"\n" + "Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 750
           		}
           			
           		JOptionPane.showMessageDialog(null, "Rodada do Inimigo...");
           		JOptionPane.showMessageDialog(null, "Eu invoco...");
           		
           	//	Gambiarra para usar try Catch
           		i 	= rand.nextInt(3);
           		if(countM > 4){
           			switch (i){
           				//Se countM for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo 
           				case 0: JOptionPane.showMessageDialog(null, kraken.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, kraken.getNomeGolpeSecundario()); //Printar o ataque Secundário
           						countM++;
           						break;
           				case 2: JOptionPane.showMessageDialog(null, kraken.getNomeDoEspecial()); //Printar o ataque Especial 
           						countM++;	
           						break;
           			}
           		} else {
           			i = rand.nextInt(2);
           			//Como o especial não poderá ser utilizado, o valor de i terá de ser sorteado novamente, pois não há mais 3 possibilidades de ataque
           			switch (i){
           			//Se countM não for maior que 4, o valor de 'i' será verificado para identificar qual ataque foi feito pelo monstro e printá-lo
           				case 0: JOptionPane.showMessageDialog(null, kraken.getNomeGolpePrimario()); //Printar o ataque primário
           						countM++;
           						break;
           				case 1: JOptionPane.showMessageDialog(null, kraken.getNomeGolpeSecundario()); //Printar o ataque secundário 
           						countM++;
           						break;
           			}
           		}
           		countM = 0;
           	                    		
           		if(arqueiro.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Herói morreu
           			a = 0;
           			JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + kraken.getNome() +
           					"\n" + "Vida: " + kraken.getVida());
                	break; //Quebra o while(true) da linha 750
           		} else if (kraken.getVida() <= 0){ //Verficação para saber se a vida está negativa. Nesse caso, se o Monstro morreu
           			a = 1;
           			JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Vida: " + arqueiro.getVida() + "\n" + kraken.getNome() +
           					"\n" + "Vida: " + kraken.getVida());
           			break; //Quebra o while(true) da linha 750
           		}
           	}	
        
           	if(a == 1){ //se 'a' for igual a 1, printar o Herói como vencendor da batalha
           		JOptionPane.showMessageDialog(null, "VITÓRIA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + arqueiro.getNome() + "\n" + "\n"+"Ataque: " + arqueiro.getAtaque() + "\n" +
           		"Defesa: " + arqueiro.getDefesa() + "\n" + "Vida: " + arqueiro.getVida() + "*******************************" + "\n" + "Perdedor: " +
           		kraken.getNome() + "\n" + "Vida: " + kraken.getVida());
           		JOptionPane.showMessageDialog(null, kraken.getMensagemDeVitoria()); //printar frase de vitória do oponente
           		JOptionPane.showMessageDialog(null, "Congratulations");
           		JOptionPane.showMessageDialog(null, "You has finished this game. You are the best player of the UFPA");
           	} else if(a == 0){ //se 'a' for igual a 0, printar o Monstro como Vencedor da batalha
           		JOptionPane.showMessageDialog(null, "DERROTA!!");
           		JOptionPane.showMessageDialog(null, "Vencedor: " + kraken.getNome() + "n" + "Vida: " + kraken.getVida() +
           				"*******************************" + "\n" + "Perdedor: " +  kraken.getNome() + "\n" + "Vida: " + kraken.getVida());
           		JOptionPane.showMessageDialog(null, kraken.getMensagemDeDerrota()); //printar frase de derrota do oponente
           		Object[] tentarNovamente = {"Sim", "Desistir"};
           		option = JOptionPane.showOptionDialog(null, "E então?", "Novo jogo?", JOptionPane.DEFAULT_OPTION, 3, null, tentarNovamente,
           				tentarNovamente[0]);
           	}
           	
           	//JOptionPane.showConfirmDialog(null, "Você deseja jogar novamente?");
           	
           	
        }
    }
}
	
abstract class Personagem{
    private int ataque, defesa, pontuacao, vida = 10;
    private String nome;
    private int golpePrimario; //habilidade primaria
    private int golpeSecundario; //habilidade secundaria
    private int golpeEspecial; //ultimate
    private String nomeGolpePrimario = "s"; //nome da primeira habilidade
    private String nomeGolpeSecundario = "s"; //nome da segunda habilidade
    private String nomeDoEspecial = "s"; //nome da ultimate

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
    int experiencia; //podemos fazer para somar um valor fixo de experiência (mas nesse caso sempre seria aconteceria a mesma coisa).
    //eu proponho muda de "Experiência para nível (String)
    int level = 1;//e aqui podemos fazer a separação dos níveis, em números
    private String tipo;
    private String classe;
    public void setClasse(String classe){
    	this.classe = classe;
    }
    	
   	public String getClasse(){
    	return classe;
   	}
    	
	/*
	private String nivel;
	
	public void setNivel(String level){
	this.level = level;
	}
	
	public String getNivel(){
	return nivel;
	}
*/	
	public String getTipo(){
		return tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
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

class Kraken extends Monstros{
	@Override
	public String getMensagemDeVitoria(){
		return "//frase de vitoria";
	}
	
	@Override
	public String getMensagemDeDerrota(){
		return "//frase de vitoria";
	}
}
