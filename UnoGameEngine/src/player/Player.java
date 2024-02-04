package player;

import card.Card;
import java.util.ArrayList;

public class Player {
    private final String name;
    private final ArrayList<Card> playerCards = new ArrayList<>();
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public int remainingCardsScore(){
        int cardsScore = 0;
        for(Card card: playerCards)
            cardsScore+=card.getCardScore();
        return cardsScore;
    }
    public void displayPlayerCards(){
        System.out.print("[");
        for (int i = 0 ; i <playerCards.size();i++)
            System.out.print(" "+playerCards.get(i)+" ("+i+") "+(i==playerCards.size()-1?"":","));
        System.out.println("]");
    }
    public void drawCard(Card card){
        this.playerCards.add(card);
    }
    public void removeCard(Card card){
        this.playerCards.remove(card);
    }
    public String getName() {
        return name;
    }
    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
