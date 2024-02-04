package card;

public class WildCard extends Card{
    public WildCard(String cardCode, String cardColor) {
        super(cardCode, cardColor);
        setFunction(new PlayNoFunction());
        setWildity(new ActWild());
    }

    @Override
    public int getCardScore() {
        return 50;
    }
}
