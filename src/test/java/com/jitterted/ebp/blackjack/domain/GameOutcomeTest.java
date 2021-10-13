package com.jitterted.ebp.blackjack.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameOutcomeTest {
    @Test
    void playerBeatsDealer() {
        Deck deck = new StubDeck(
                new Card(Suit.HEARTS, Rank.TEN), // player
                new Card(Suit.CLUBS, Rank.TEN), // dealer
                new Card(Suit.HEARTS, Rank.NINE), // player
                new Card(Suit.SPADES, Rank.TEN), // dealer
                new Card(Suit.HEARTS, Rank.TWO) // player
        );
        Game game = new Game(deck);
        game.initialDeal();
        game.playerHits();
        assertThat(game.determineOutcome()).isEqualTo(GameOutcome.PLAYER_BEATS_DEALER);
    }

    @Test
    void playerGoesBust() {
        Deck deck = new StubDeck(
                new Card(Suit.HEARTS, Rank.TEN), // player
                new Card(Suit.CLUBS, Rank.TEN), // dealer
                new Card(Suit.HEARTS, Rank.NINE), // player
                new Card(Suit.SPADES, Rank.TEN), // dealer
                new Card(Suit.HEARTS, Rank.FIVE) // player
        );
        Game game = new Game(deck);
        game.initialDeal();
        game.playerHits();
        assertThat(game.determineOutcome()).isEqualTo(GameOutcome.PLAYER_BUSTS);
    }
}
