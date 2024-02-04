package card;

import java.util.ArrayList;

public class GoldenCard extends Card{
    public GoldenCard(String cardCode, String cardColor) {
        super(cardCode, cardColor);
        setFunction(new PlayGolden());
        setWildity(new ActNoWild());
    }

    @Override
    public int getCardScore() {
        return 0;
    }
}
