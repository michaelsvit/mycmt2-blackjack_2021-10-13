package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CardDisplayTest {
    @Test
    void displayTenAsString() {
        Card card = new Card(Suit.SPADES, Rank.TEN);
        String display = ConsoleCard.display(card);

        assertThat(display).isEqualTo("[30m┌─────────┐[1B[11D│10       │[1B[11D│         │[1B[11D│    ♠    │[1B[11D│         │[1B[11D│       10│[1B[11D└─────────┘");
    }

    @Test
    void displayNonTenAsString() {
        Card card = new Card(Suit.SPADES, Rank.NINE);
        String display = ConsoleCard.display(card);

        assertThat(display).isEqualTo("[30m┌─────────┐[1B[11D│9        │[1B[11D│         │[1B[11D│    ♠    │[1B[11D│         │[1B[11D│        9│[1B[11D└─────────┘");
    }
}
