package com.jitterted.ebp.blackjack.domain;

public class Game {
    private final Deck deck;
    private final Hand dealerHand = new Hand();
    private final Hand playerHand = new Hand();
    private boolean playerDone;

    public Game(Deck deck) {
        this.deck = deck;
    }

    public Hand dealerHand() {
        return this.dealerHand;
    }

    public Hand playerHand() {
        return this.playerHand;
    }

    public void initialDeal() {
        dealRoundOfCards();
        dealRoundOfCards();
        if (playerHand.isBlackjack()) {
            this.playerDone = true;
        }
    }

    public void dealRoundOfCards() {
        playerHand.drawFrom(deck);
        dealerHand.drawFrom(deck);
    }

    public GameOutcome determineOutcome() {
        if (playerHand.isBlackjack()) {
            return GameOutcome.BLACKJACK;
        } else if (playerHand.isBusted()) {
            return GameOutcome.PLAYER_BUSTS;
        } else if (dealerHand.isBusted()) {
            return GameOutcome.DEALER_BUSTS;
        } else if (playerHand.beats(dealerHand)) {
            return GameOutcome.PLAYER_BEATS_DEALER;
        } else if (playerHand.pushes(dealerHand)) {
            return GameOutcome.PLAYER_PUSHES_DEALER;
        } else {
            return GameOutcome.PLAYER_LOSES;
        }
    }

    public void dealerTurn() {
        // Dealer makes its choice automatically based on a simple heuristic (<=16 must hit, =>17 must stand)
        if (!playerHand.isBusted()) {
            while (dealerHand.dealerMustDrawCard()) {
                dealerHand.drawFrom(deck);
            }
        }
    }

    public void playerHits() {
        playerHand.drawFrom(deck);
        playerDone = playerHand.isBusted();
    }

    public void playerStands() {
        playerDone = true;
    }

    public boolean isPlayerDone() {
        return playerDone;
    }

}
