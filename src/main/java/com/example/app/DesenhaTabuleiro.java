package com.example.app;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DesenhaTabuleiro extends JPanel {
    private final int TAMANHO_CASA = 55;
    private final int NUM_CASAS = 10;
    private int[][] pieces = new int[NUM_CASAS][NUM_CASAS]; // 0: vazio, 1: peça preta, 2: peça branca

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int linha = 0; linha < NUM_CASAS; linha++) {
            for (int coluna = 0; coluna < NUM_CASAS; coluna++) {
                int x = coluna * TAMANHO_CASA;
                int y = linha * TAMANHO_CASA;

                // Alterna a cor das casas
                if ((linha + coluna) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(x, y, TAMANHO_CASA, TAMANHO_CASA);
            }
        }
        
        for (int linha = 0; linha < NUM_CASAS; linha++) {
            for (int coluna = 0; coluna < NUM_CASAS; coluna++) {
                if (pieces[linha][coluna] != 0) {
                    int x = coluna * TAMANHO_CASA + TAMANHO_CASA / 4;
                    int y = linha * TAMANHO_CASA + TAMANHO_CASA / 4;
                    int size = TAMANHO_CASA / 2;

                    if (pieces[linha][coluna] == 1) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.RED); // Peça "branca" como vermelha para contraste
                    }
                    g.fillOval(x, y, size, size);
                }
            }
        }
    }
    //     //addMouseListener(new MouseAdapter() {
    // //@Override
    // public void mouseClicked(MouseEvent e) {
    //     int col = e.getX() / TAMANHO_CASA;
    //     int row = e.getY() / TAMANHO_CASA;

    //     System.out.println("Clicou na casa: " + row + ", " + col);
    //     // Lógica para selecionar e mover peças pode ser adicionada aqui
    // }
    // //});
}