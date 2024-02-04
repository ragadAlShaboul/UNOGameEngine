package card;

import java.util.ArrayList;

public class SkipCard extends Card{
    public SkipCard(String cardCode, String cardColor) {
        super(cardCode, cardColor);
        setFunction(new PlaySkip());
        setWildity(new ActNoWild());
    }

    @Override
    public int getCardScore() {
        return 20;
    }
}
