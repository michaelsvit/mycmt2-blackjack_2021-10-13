package com.jitterted.ebp.blackjack;

public class Blackjack {
    public static void main(String[] args) {
        Game game = new Game();
        ConsoleGame consoleGame = new ConsoleGame(game);
        consoleGame.start();
    }
}
