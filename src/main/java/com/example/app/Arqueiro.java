package com.example.app;

public class Arqueiro extends Personagens {

    public Arqueiro(int linha, int coluna, boolean isPlayer1) {
        super(linha, coluna, 8, 5, 5, isPlayer1, 'A');
    }

    @Override
    protected void specialPower(Personagens alvo) {
        System.out.println(getNome() + " ativa Flecha Precisa");
        setAlcanceAtaque(getAlcanceAtaque() + 1);
    }
}
