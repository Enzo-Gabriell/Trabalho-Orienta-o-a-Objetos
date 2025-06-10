package com.example.app;

public class Guerreiro extends Personagens {

    public Guerreiro(int linha, int coluna, boolean isPlayer1) {
        super(linha, coluna, 15, 1, 10, isPlayer1, 'G');
    }

    @Override
    protected void specialPower(Personagens alvo) {
        if (!isSpecialAtivo()) {
            System.out.println(getNome() + " ativa Carga Brutal");
            setForcaAtaque(getForcaAtaque() * 2);
        } else
            System.out.println(getNome() + " já está com Carga Brutal ativa");
    }
}
