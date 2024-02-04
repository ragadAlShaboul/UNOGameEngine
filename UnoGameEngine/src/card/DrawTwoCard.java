package card;
public class DrawTwoCard extends Card{
    public DrawTwoCard(String cardCode, String cardColor) {
        super(cardCode, cardColor);
        setFunction(new PlayDrawTwo());
        setWildity(new ActNoWild());
    }

    @Override
    public int getCardScore() {
        return 20;
    }
}
