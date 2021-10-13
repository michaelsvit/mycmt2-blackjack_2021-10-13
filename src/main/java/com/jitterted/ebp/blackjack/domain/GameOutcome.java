package com.jitterted.ebp.blackjack.domain;

public enum GameOutcome {
    PLAYER_BEATS_DEALER("You beat the Dealer! 💵"),
    PLAYER_BUSTS("You Busted, so you lose.  💸"),
    PLAYER_PUSHES_DEALER("Push: Nobody wins, we'll call it even."),
    PLAYER_LOSES("You lost to the Dealer. 💸"),
    DEALER_BUSTS("Dealer went BUST, Player wins! Yay for you!! 💵");

    private final String msg;

    GameOutcome(String msg) {
        this.msg = msg;
    }

    public String message() {
        return msg;
    }
}
