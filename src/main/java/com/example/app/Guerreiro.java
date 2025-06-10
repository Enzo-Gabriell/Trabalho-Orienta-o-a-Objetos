package com.example.app;

public class Guerreiro extends Personagens {
    
    public Guerreiro(int linha, int coluna, boolean p1) {
        super(linha, coluna, 15, 1, 10, p1 ? 'G' : 'g');
    }

    @Override
    protected void specialPower(Personagens alvo) {
        System.out.println(getNome() + " ativa Carga Brutal");
        if(!isSpecialAtivo())
            setForcaAtaque(getForcaAtaque() * 2);
    }
}
