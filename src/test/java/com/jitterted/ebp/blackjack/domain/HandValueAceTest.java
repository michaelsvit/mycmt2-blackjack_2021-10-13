package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.domain.Card;
import com.jitterted.ebp.blackjack.domain.Hand;
import com.jitterted.ebp.blackjack.domain.Rank;
import com.jitterted.ebp.blackjack.domain.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit DUMMY_SUIT = Suit.CLUBS;

    @Test
    public void handWithOneAceAndOtherCardValuedLessThan10ThenAceIsValuedAt11() throws Exception {
        Hand hand = createHand(Rank.ACE, Rank.FIVE);

        assertThat(hand.valueEquals(11 + 5))
                .isTrue();
    }

    @Test
    public void handWithOneAceAndOtherCardsValuedAt10ThenAceIsValuedAt11() throws Exception {
        Hand hand = createHand(Rank.ACE, Rank.TEN);

        assertThat(hand.valueEquals(11 + 10))
                .isTrue();
    }

    @Test
    public void handWithOneAceAndOtherCardsValuedAs11ThenAceIsValuedAt1() throws Exception {
        Hand hand = createHand(Rank.ACE, Rank.EIGHT, Rank.THREE);

        assertThat(hand.valueEquals(1 + 8 + 3))
                .isTrue();
    }

    @Test
    void handWithAceAndFaceCardIsBlackjack() {
        Hand hand = createHand(Rank.ACE, Rank.JACK);

        assertThat(hand.isBlackjack()).isTrue();
    }

    @Test
    void handWithAceAndTenCardIsBlackjack() {
        Hand hand = createHand(Rank.ACE, Rank.TEN);

        assertThat(hand.isBlackjack()).isTrue();
    }

    @Test
    void handWithAceAndLessThanTenCardIsNotBlackjack() {
        Hand hand = createHand(Rank.ACE, Rank.FIVE);

        assertThat(hand.isBlackjack()).isFalse();
    }

    private Hand createHand(Rank... ranks) {
        List<Card> cards = new ArrayList<>();
        for (Rank rank : ranks) {
            cards.add(new Card(DUMMY_SUIT, rank));
        }
        return new Hand(cards);
    }

}
