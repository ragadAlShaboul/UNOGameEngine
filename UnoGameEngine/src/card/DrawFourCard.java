package card;

import card.Card;

import java.util.ArrayList;
public class DrawFourCard extends Card {
    public DrawFourCard(String cardCode, String cardColor) {
        super(cardCode, cardColor);
        setFunction(new PlayDrawFour());
        setWildity(new ActWild());
    }

    @Override
    public int getCardScore() {
        return 50;
    }


}
