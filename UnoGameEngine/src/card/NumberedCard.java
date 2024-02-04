package card;
public class NumberedCard extends Card{
    public NumberedCard(String cardCode, String cardColor) {
        super(cardCode, cardColor);
        setFunction(new PlayNoFunction());
        setWildity(new ActNoWild());
    }

    @Override
    public int getCardScore() {
        return 1;
    }

}
