package card;

import card.Card;

import java.util.ArrayList;
public class ReverseCard extends Card {
    public ReverseCard(String cardCode, String cardColor) {
        super(cardCode, cardColor);
        setFunction(new PlayReverse());
        setWildity(new ActNoWild());
    }

    @Override
    public int getCardScore() {
        return 20;
    }

}
