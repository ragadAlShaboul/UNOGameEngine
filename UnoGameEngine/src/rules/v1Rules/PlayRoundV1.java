package rules.v1Rules;

import card.Card;
import player.Player;
import rules.PlayRound;

import java.util.LinkedList;
import java.util.Scanner;

public class PlayRoundV1 implements PlayRound {
    Scanner s = new Scanner(System.in);
    private final LinkedList<Card> cardDeck;
    private final LinkedList<Player> players;
    private Card globalCard;
    private Player player ;
    public PlayRoundV1(LinkedList<Card> cardDeck, LinkedList<Player> players, Card globalCard) {
        this.cardDeck = cardDeck;
        this.players = players;
        this.globalCard = globalCard;
        player = players.get(0);
    }
    @Override
    public void dropCard() {
        System.out.println("Global Card is: "+globalCard);
        while (!drawNoMatchingCard());
        System.out.println("Player "+ player.getName()+", ");
        player.displayPlayerCards();
        System.out.println("Enter the index of the card to play indexing from 0:");
        int index = s.nextInt();
        while (!matchCard(player.getPlayerCards().get(index)) || index<0 || index>player.getPlayerCards().size()-1){
            System.out.println("Please select the right card");
            index = s.nextInt();
        }
        cardDeck.addLast(globalCard);
        globalCard = player.getPlayerCards().get(index);
        player.removeCard(player.getPlayerCards().get(index));
    }

    @Override
    public boolean matchCard(Card card) {
        if(globalCard.getCardCode().equals(card.getCardCode()) || globalCard.getCardColor().equals(card.getCardColor()))
            return true;
        else return card.getCardColor().equals("Black");
    }

    @Override
    public void implementCard() {
        player = globalCard.performFunction(cardDeck,players,player);
        if(!roundWin())
            player = getNextPlayer();
        globalCard.performWildity(cardDeck,globalCard);
    }
    @Override
    public Player getNextPlayer() {
        int index = players.indexOf(player);
        Player nextPlayer;
        if(index == players.size()-1)
            nextPlayer = players.get(0);
        else nextPlayer = players.get(index+1);
        return nextPlayer;
    }
    @Override
    public Player getRoundWinner() {
        return player;
    }
    @Override
    public boolean roundWin(){
        for (Player player1:players)
            if(player1.getPlayerCards().isEmpty()){
                return true;
            }
        return false;
    }
    @Override
    public void updateScore() {
        int score = player.getScore();
        for (Player player1:players)
            score+=player1.remainingCardsScore();
        player.setScore(score);
    }
    @Override
    public boolean drawNoMatchingCard(){
        for(Card card:player.getPlayerCards())
            if( card.getCardColor().equals("Black") || card.getCardColor().equals(globalCard.getCardColor()) || card.getCardCode().equals(globalCard.getCardCode()))
                return true;
        player.drawCard(cardDeck.pop());
        System.out.println("Player "+player.getName()+", a card is drawn ");
        player.displayPlayerCards();
        for(Card card:player.getPlayerCards())
            if(card.getCardColor().equals("Black") || card.getCardColor().equals(globalCard.getCardColor()) || card.getCardCode().equals(globalCard.getCardCode()))
                return true;
        player = getNextPlayer();
        return false;
    }
}
