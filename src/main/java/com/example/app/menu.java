package com.example.app;
import javax.swing.JOptionPane;

public class menu {
    public static void main(String[] args){
        int opcao = JOptionPane.showConfirmDialog(null, "Selecione o modo de jogo:", "Bem Vindo!", 0);
        switch (opcao) {
            case 1:
                System.out.println("Boa escolha");
                break;
        
            default:
                break;
        }
        
        System.out.println("Duelo de Presonagens");
        
        System.out.println("(1) Jogar PvP");
        System.out.println("(2) Jogar PvE");
        System.out.println("(3) Sair do jogo");
        System.out.print(": ");
    }
}
