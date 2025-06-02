package com.example.app;
import javax.swing.JOptionPane;

public class menu {
    public static void main(String[] args){
        Object[] options = { "Jogar PvP", "Jogar PvE", "Sair do jogo" };
        int opcao = JOptionPane.showOptionDialog(null, "BEM VINDO!", "Duelo de Personagens", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[2]);
    
        switch (opcao) {
            case 0:
                JOptionPane.showMessageDialog(null, "Tela PvP");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Tela PvE");
                break;

            default:
                break;
        }
    }
}
