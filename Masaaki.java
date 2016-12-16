package prova;

import java.util.Random;import java.util.Scanner;
import javax.swing.JOptionPane;

public class Prova {
    public static void main(String[] args) {
        int habilidade; //Faz a comparação com o valor inteiro amazenado para saber qual hailidade o herṕi utilizou. Linha 36
        int escolha; //Variável interia para fazer comparações e saber qual herói o Jogador escolheu. Linha 25 
        int a = 0;
    	Random rand = new Random();
        Scanner scan = new Scanner (System.in);
        Monstros dragon = new Dragao();
        Monstros gigante = new Gigante();
        Monstros bomba = new Moises_Bomba();
        dragon.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do dragão 
        dragon.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do dragão
        gigante.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do gigante
        gigante.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do gigante
        bomba.setAtaque(rand.nextInt(10)); //valor randomico para a defesa do bomba
        bomba.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do bomba
        Object[] herois = {"Mage", "Tanker", "Sniper"};
        escolha = JOptionPane.showOptionDialog(null, "Selecione uma classe para escolher o seu herói", " ", JOptionPane.DEFAULT_OPTION, 3, null, herois, herois[0]);
        
        if (escolha == 0){
            Mago mago = new Mago();
            mago.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            mago.setAtaque(rand.nextInt(10)); //valor randomico para o ataque do mago
            mago.setDefesa(rand.nextInt(10)); //valor randomico para a defesa do mago
            JOptionPane.showMessageDialog(null, mago.getNome() + "\n" + "Vida: " + mago.getVida() + "\n" + "Ataque: " + mago.getAtaque() + "\n" + "Defesa: " + mago.getDefesa() + "\n" + "Habilidade Primária: " + mago.getNomeGolpePrimario() + "Habilidade Secundária: " + mago.getNomeGolpeSecundario() + "\n" + "Ultimate: " + mago.getNomeDoUltimate() + "*******************************" + "\n" + dragon.getNome() + "\n" + "Ataque: " + dragon.getAtaque() + "\n" + "Defesa: " + dragon.getDefesa() + "Habilidade Primária: " + dragon.getNomeGolpePrimario() + "Habilidade Secundária: " + dragon.getNomeGolpeSecundario() + "\n" + "Ultimate: " + dragon.getNomeDoUltimate(), "Adversários da batalha: ", 1); //printar os atributos do mago e do monstro.
            JOptionPane.showMessageDialog(null, "Que comece a batalha!");
            
            while(true){
                if(escolha == 0){
                    Object[] golpesDoMago = {mago.getNomeGolpePrimario(), mago.getNomeGolpeSecundario(), mago.getNomeDoUltimate()};
                    habilidade = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesDoMago, golpesDoMago[0]);
                    if(habilidade == 0)
                        mago.chute();
                    else if (opg==1)
                        m.vida();
                }
                if(op==1){
                    Object[] golpesg2 = {"Soco", "Fogo"};
                    int opg2 = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesg2, g);
                    if(opg2==0)
                        m.soco();
                    else if (opg2==1)
                        m.fogo();}
                if(opm==0){
                    //m.tipo = "Dragão";
                    Object[] golpesm = {"Golpe com a cauda", "Fogo"};
                    int opmb = JOptionPane.showOptionDialog(null, "Selecione o ataque do monstro:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesm, m);
                    if(opmb==0)
                        g.cauda();
                    else if (opmb==1)
                        g.fogo();
                }
                else if(opm==1){
                    //m.tipo = "Zumbi";
                    Object[] golpesm2 = {"Reviver", "Vida"};
                    int opmb2 = JOptionPane.showOptionDialog(null, "Selecione o ataque do monstro:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesm2, m);
                    if(opmb2==0)
                        g.reviver();
                    else if (opmb2==1)
                        g.vida();
                }
                else if(opm==2){                                     
                    //m.tipo = "Gigante";
                    Object[] golpesm3 = {"Pisar", "Pisotear"};
                    int opmb3 = JOptionPane.showOptionDialog(null, "Selecione o ataque do monstro:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesm3, m);
                    if(opmb3==0)
                        g.pisa();
                    else if (opmb3==1)
                        g.pisotear();
                    }
                if(g.getVida() <= 0){
                    a = 0;
                    break;
                }
                else if (m.getVida() <= 0){
                    a = 1;
                    break;
                }
                JOptionPane.showMessageDialog(null, "Guerreiro \n" + "Vida: " + g.getVida() + "\nMonstro \n"+ "Vida: " + m.getVida());
                }
                if(a == 1){
                    JOptionPane.showMessageDialog(null, "Vencedor: Guerreiro "+g.getCor()+"\n"+g.getNome()+"\n"+"Ataque: "+g.getAtaque()+" +10"+"\n"+"Defesa: "+g.getDefesa()+" +5"+"\n"+"Vida: "+g.getVida());
                    JOptionPane.showMessageDialog(null, "Guerreiro é um homão da porra");
                }
                else if(a == 0){
                    JOptionPane.showMessageDialog(null, "Vencedor: "+m.getTipo()+"\n"+m.getNome()+"\n"+"Vida: "+m.getVida());
                    JOptionPane.showMessageDialog(null, "Ce é  bixão mesmo eim doido");
                }       }
            
            
            
            
            
            
        if (escolha == 1){
            Guerreiro guerreiro = new Guerreiro();
            guerreiro.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            guerreiro.setAtaque(rand.nextInt(10));
            guerreiro.setDefesa(rand.nextInt(10));
            JOptionPane.showMessageDialog(null, guerreiro.getNome() + "\n" + "Ataque: " + guerreiro.getAtaque() + "\n" + "Defesa: " + guerreiro.getDefesa()+"\n"+"*******************************"+"\n" + dragon.getNome() + "\n" + "Ataque: " + dragon.getAtaque()+"\n"+"Defesa: " + dragon.getDefesa(), "Adversários da batalha: ", 1);
            JOptionPane.showMessageDialog(null, "Que comece a batalha!");


        }

        if (escolha == 2){
            Arqueiro arqueiro = new Arqueiro();
            arqueiro.setNome(JOptionPane.showInputDialog("Escolha o seu nome:"));
            arqueiro.setAtaque(rand.nextInt(10));
            arqueiro.setDefesa(rand.nextInt(10));
            JOptionPane.showMessageDialog(null, arqueiro.getNome() + "\n" + "Ataque: " + arqueiro.getAtaque() + "\n" + "Defesa: " + arqueiro.getDefesa()+"\n"+"*******************************"+"\n" + dragon.getNome() + "\n" + "Ataque: " + dragon.getAtaque()+"\n"+"Defesa: " + dragon.getDefesa(), "Adversários da batalha: ", 1);
            JOptionPane.showMessageDialog(null, "A batalha irá começar!!");

            
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
*/

        //m.nome = JOptionPane.showInputDialog("Nome do Monstro: ");
/*        Object[] monstop = {"Dragão", "Zumbi", "Gigante"};
        int opm = JOptionPane.showOptionDialog(null, "Selecione o tipo do Monstro:", "Tipo do Monstro ", JOptionPane.DEFAULT_OPTION, 3, null, monstop, m);
        if(opm==0){
            m.setTipo("Dragão");
            m.setNome("dragão");}
        else if(opm==1)
            m.setTipo("Zumbi");
        else if(opm==2)
            m.setTipo("Gigante");
*/
        while(true){
        if(op==0){
            Object[] golpesg = {"Chutar", "Drenar vida"};
            int opg = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesg, g);
            if(opg==0)
                m.chute();
            else if (opg==1)
                m.vida();
        }
        if(op==1){
            Object[] golpesg2 = {"Soco", "Fogo"};
            int opg2 = JOptionPane.showOptionDialog(null, "Selecione o ataque:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesg2, g);
            if(opg2==0)
                m.soco();
            else if (opg2==1)
                m.fogo();}
        if(opm==0){
            //m.tipo = "Dragão";
            Object[] golpesm = {"Golpe com a cauda", "Fogo"};
            int opmb = JOptionPane.showOptionDialog(null, "Selecione o ataque do monstro:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesm, m);
            if(opmb==0)
                g.cauda();
            else if (opmb==1)
                g.fogo();
        }
        else if(opm==1){
            //m.tipo = "Zumbi";
            Object[] golpesm2 = {"Reviver", "Vida"};
            int opmb2 = JOptionPane.showOptionDialog(null, "Selecione o ataque do monstro:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesm2, m);
            if(opmb2==0)
                g.reviver();
            else if (opmb2==1)
                g.vida();
        }
        else if(opm==2){                                     
            //m.tipo = "Gigante";
            Object[] golpesm3 = {"Pisar", "Pisotear"};
            int opmb3 = JOptionPane.showOptionDialog(null, "Selecione o ataque do monstro:", "Usar o golpe", JOptionPane.DEFAULT_OPTION, 3, null, golpesm3, m);
            if(opmb3==0)
                g.pisa();
            else if (opmb3==1)
                g.pisotear();
            }
        if(g.getVida() <= 0){
            a = 0;
            break;
        }
        else if (m.getVida() <= 0){
            a = 1;
            break;
        }
        JOptionPane.showMessageDialog(null, "Guerreiro \n" + "Vida: " + g.getVida() + "\nMonstro \n"+ "Vida: " + m.getVida());
        }
        if(a == 1){
            JOptionPane.showMessageDialog(null, "Vencedor: Guerreiro "+g.getCor()+"\n"+g.getNome()+"\n"+"Ataque: "+g.getAtaque()+" +10"+"\n"+"Defesa: "+g.getDefesa()+" +5"+"\n"+"Vida: "+g.getVida());
            JOptionPane.showMessageDialog(null, "Guerreiro é um homão da porra");
        }
        else if(a == 0){
            JOptionPane.showMessageDialog(null, "Vencedor: "+m.getTipo()+"\n"+m.getNome()+"\n"+"Vida: "+m.getVida());
            JOptionPane.showMessageDialog(null, "Ce é  bixão mesmo eim doido");
        }
}

abstract class Personagem{
    private int ataque, defesa, pontuacao, vida = 10;
    private String nome;
    private int golpePrimario; //habilidade primaria
    private int golpeSecundario; //habilidade secundaria
    private int golpeUltimate; //ultimate
    private String nomeGolpePrimario; //nome da primeira habilidade
    private String nomeGolpeSecundario; //nome da segunda habilidade
    private String nomeDoUltimate; //nome da ultimate

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

    public int getGolpePrimario() {
        return golpePrimario;
    }
    
    public void setGolpePrimario(int golpePrimario) {
        this.golpePrimario = golpePrimario;
    }
        
    public String getNomeGolpeSecundario() {
    	return nomeGolpeSecundario;    	
    }
    
    public int getGolpeSecundario() {
        return golpeSecundario;
    }

    public void setGolpeSecundario(int golpeSecundario) {
        this.golpeSecundario = golpeSecundario;
    }

    public String getNomeDoUltimate() {
        return nomeDoUltimate;
    }
    
    public int getDoUltimate() {
        return golpeUltimate;
    }

    public void setGolpeUltimate(int golpeEspecial) {
        this.golpeUltimate = golpeEspecial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Herois extends Personagem{
    int experiencia, nivel = 0; 
    
}

class Mago extends Personagem{

}

class Arqueiro extends Personagem{

}
  

class Sniper extends Personagem{

}

class Guerreiro extends Personagem{

}

class Monstros extends Personagem{
	
}

class Dragao extends Monstros{

}

class Gigante extends Monstros{

}

class Moises_Bomba extends Monstros{

}
