package rules.v1Rules;

import card.Card;

import player.Player;
import rules.DistributeCards;

import java.util.Collections;
import java.util.LinkedList;

public class DistributeCardsV1 implements DistributeCards {
    private final LinkedList<Card> cardDeck ;
    private final LinkedList<Player> players ;
    public DistributeCardsV1(LinkedList<Card> cardDeck, LinkedList<Player> players) {
        this.cardDeck = cardDeck;
        this.players = players;
    }

    @Override
    public void shuffleCards() {
        Collections.shuffle(cardDeck);
    }

    @Override
    public void dealCards() {
        for(Player player:players){
            for(int i = 0 ; i < 7 ; i++){
                player.drawCard(cardDeck.pop());
            }
        }
    }

    @Override
    public Card globalCard() {
        int index = cardDeck.size()-1;
        while(cardDeck.get(index).getCardColor().equals("Black")) {
            index--;
        }
        return cardDeck.remove(index);
    }
}
