package com.jitterted.ebp.blackjack.domain;

import java.util.Arrays;
import java.util.Iterator;

public class StubDeck extends Deck {
    private final Iterator<Card> iter;

    public StubDeck(Card... cards) {
        this.iter = Arrays.stream(cards).iterator();
    }

    @Override
    public Card draw() {
        return iter.next();
    }
}
