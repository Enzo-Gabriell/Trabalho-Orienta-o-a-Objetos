package com.example.app;
import javax.swing.JOptionPane;

public class menu {
    private static void pvp(){
        //Personagens personagem1, personagem2;
        

    }
        public static void main(String[] args){
        //printa menu principal
        Object[] options = { "Jogar PvP", "Jogar PvE", "Sair do jogo" };
        int opcao = JOptionPane.showOptionDialog(null, "BEM VINDO!", "Duelo de Personagens", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[2]);
        
        //inicia a partida 
        switch (opcao) {
            case 0:
                pvp();
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Tela PvE");
                break;
            default:
                break;
        }
    }
}
