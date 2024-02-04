package card;

import player.Player;

import java.util.LinkedList;

public abstract class Card {
    protected Functionality function;
    protected Wildity wildity;
    private final String cardCode;
    private String cardColor;


    protected Card(String cardCode,String cardColor){
        this.cardCode = cardCode;
        this.cardColor = cardColor;
    }
    public abstract int getCardScore();
    public void setFunction(Functionality f){
        this.function = f;
    }
    public void setWildity(Wildity wildity) {
        this.wildity = wildity;
    }
    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String toString(){
        return "( "+cardColor+", "+cardCode+" )";
    }
    public Player performFunction(LinkedList<Card>cards, LinkedList<Player> players, Player player){
        return function.function(cards, players, player);
    }
    public void performWildity(LinkedList<Card>cards,Card globalCard){
        wildity.act(cards,globalCard);
    }

    public String getCardCode() {
        return cardCode;
    }

    public String getCardColor() {
        return cardColor;
    }

}
