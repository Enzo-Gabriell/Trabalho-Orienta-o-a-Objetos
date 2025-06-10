package com.example.app;

public class Mago extends Personagens {

    public Mago(int linha, int coluna, boolean p1) {
        super(linha, coluna, 10, 3, 7, p1 ? 'M' : 'm');
    }

    @Override
    protected void specialPower(Personagens alvo) {
        if (!isSpecialAtivo()) {
            System.out.println(getNome() + " ativa Trocar vida");
            int aux = getPontosDeVida();
            setPontosDeVida(alvo.getPontosDeVida());
            alvo.setPontosDeVida(aux);
        }
    }
}
