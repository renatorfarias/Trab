package prova;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Prova {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner (System.in);
        Monstros dragon = new Dragao();
        Monstros gigante = new Gigante();
        Monstros bomba = new Moises_Bomba();
        dragon.setAtaque(rand.nextInt(10));
        dragon.setDefesa(rand.nextInt(10));
        gigante.setAtaque(rand.nextInt(10));
        gigante.setDefesa(rand.nextInt(10));
        bomba.setAtaque(rand.nextInt(10));
        bomba.setDefesa(rand.nextInt(10));
        int a = 0;
        Object[] herois = {"Mage", "Tanker", "Sniper"};
        int escolha = JOptionPane.showOptionDialog(null, "Selecione uma classe para escolher o seu herói", " ", JOptionPane.DEFAULT_OPTION, 3, null, herois, herois[0]);
        if (escolha == 0){
            Herois mago = new Mago();
            mago.setNome() = JOptionPane.InputDialog("Escolha o seu nome:");
            mago.setAtaque(rand.nextInt(10));
            mago.setDefesa(rand.nextInt(10));
        }  

        if (escolha == 1){
            Herois guerreiro = new Guerreiro();
            guerreiro.setNome() = JOptionPane.InputDialog("Escolha o seu nome:");
            guerreiro.setAtaque(rand.nextInt(10));
            guerreiro.setDefesa(rand.nextInt(10));

        }

        if (escolha == 2){
            Herois arqueiro = new Arqueiro();
            arqueiro.setNome() = JOptionPane.InputDialog("Escolhe o seu nome:");
            arqueiro.setAtaque(rand.nextInt(10));
            arqueiro.setDefesa(rand.nextInt(10));
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
        JOptionPane.showMessageDialog(null, g.getNome()+"\n"+"Cor: "+g.getCor()+"\n"+"Ataque: "+g.getAtaque()+"\n"+"Defesa: "+g.getDefesa()+"\n"+"*******************************"+"\n"+m.getNome()+"\n"+"Tipo: "+m.getTipo()+"\n"+"Ataque: "+m.getAtaque()+"\n"+"Defesa: "+m.getDefesa(), "Adversários da batalha: ", 1);
        JOptionPane.showMessageDialog(null, "Que comece a batalha!");
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
        }       }
        /*
        if (g.ataque>m.defesa){
            JOptionPane.showMessageDialog(null, "Vencedor: Guerreiro "+g.cor+"\n"+g.nome+"\n"+"Ataque: "+g.ataque+" +10"+"\n"+"Defesa: "+g.defesa+" +5"+"\n"+"Vida: "+g.vida);
            }
        else if (m.ataque>g.defesa)
            JOptionPane.showMessageDialog(null, "Vencedor: "+m.tipo+"\n"+m.nome+"\n"+"Vida: "+m.vida);
        else if (g.ataque<m.defesa|m.ataque<g.defesa){
            if (g.ataque>m.ataque)
                JOptionPane.showMessageDialog(null, "Vencedor: Guerreiro "+g.cor+"\n"+g.nome+"\n"+"Ataque: "+g.ataque+" +10"+"\n"+"Defesa: "+g.defesa+" +5"+"\n"+"Vida: "+g.vida);
            else if (g.ataque<m.ataque)
                JOptionPane.showMessageDialog(null, "Vencedor: "+m.tipo+"\n"+m.nome+"\n"+"Vida: "+m.vida);
        }
        else if(g.ataque==m.ataque|g.defesa==m.defesa)
            JOptionPane.showMessageDialog(null, "Empate");
        }
                */
    }
    

abstract class Personagem{
    private int defesa, pontuacao, vida = 10;
    private String nome;
    private int golpePrimario; //habilidade primaria
    private int golpeSecundario; //habilidade secundaria
    private int golpeUltimate; //ultimate
    private String nomeGolpePrimario; //nome da primeira habilidade
    private String nomeGolpeSecundario; //nome da segunda habilidade
    private String nomeDoUltimate; //nome da ultimate

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
    
    public void setGolpeSecundario(int golpeSecundario) {
        this.golpeSecundario = golpeSecundario;
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

    public void setGolpeEspecial(int golpeEspecial) {
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
  

class Sniper extends Personagem{

}

class Guerreiro extends Personagem{

}

class Monstros extends Personagem{
    String nome;
    private int primarySkill; //habilidade primaria
    private int secondarySkill; //habilidade secundaria
    private int ultimate; //habilidade ultimate
    private String nameOfPrimarySkill; //nome da primeira habilidade
    private String nameOfsecondarySkill; //nome da segunda habilidade
    private String nameOfultimate; //nome da ultimate



}

class Dragao extends Monstros{

}

class Gigante extends Monstros{

}

class Moises_Bomba extends Monstros{

}

