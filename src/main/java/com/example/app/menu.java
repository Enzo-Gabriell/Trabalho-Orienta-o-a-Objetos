package com.example.app;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class menu {
    private static void pvp(){
        Jogo partida;
        

    }
    public static void main(String[] args){
        //printa menu principal
        Object[] options = { "Jogar PvP", "Jogar PvE", "Sair do jogo" };
        int opcao = JOptionPane.showOptionDialog(null, "BEM VINDO!", "Duelo de Personagens", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[2]);
        
        //inicia a partida 
        // switch (opcao) {
        //     case 0:
        //         pvp();
        //         break;
        //     case 1:
        //         JOptionPane.showMessageDialog(null, "Tela PvE");
        //         break;
        //     default:
        //         break;
        // }
        
        JFrame frame = new JFrame("Tabuleiro de Xadrez");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(565, 588);
        frame.setLocationRelativeTo(null);
        
        // O painel do tabuleiro será adicionado aqui
        DesenhaTabuleiro tabuleiro = new DesenhaTabuleiro();
        frame.add(tabuleiro);
        
        frame.setVisible(true);
	    

    }
}
