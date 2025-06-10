package com.example.app;

public class Bot {

    public static int decideAcao(Personagens bot, Personagens player1) {
        if(bot.getSimbolo() == 'G' && !bot.isSpecialAtivo()) // caso o bot seja guerreio já ativa special de cara
            return 4;
        else if(bot.getSimbolo() == 'M' && !bot.isSpecialAtivo() && bot.getPontosDeVida() < (player1.getPontosDeVida() * 2)) // caso seja mago ativa special se a vida for menos da metade da do oponente
            return 4;
        else if(Tabuleiro.validaAlcance(bot, player1)) // se der pra bater bate
            return 1;
        else if(bot.getSimbolo() == 'A') // se for arqueiro e não alcançar aumenta alcance
            return 4;
        else if(bot.getForcaDefesa() == 0) // defesa = 0, ele defende
            return 2;
        else // ultimo caso anda
            return 3;
    }
    
    public static char direcaoDeMovimento(Personagens bot, Personagens player1) {
        if(Math.abs(bot.getLinha() - player1.getLinha()) > Math.abs(bot.getColuna() - player1.getColuna()))
            if(player1.getLinha() > bot.getLinha())
                return 'B';
            else
                return 'C';
        else
            if(player1.getColuna() > bot.getColuna())
                return 'D';
            else
                return 'E';
    }
}