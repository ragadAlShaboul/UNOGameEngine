package rules.v1Rules;

import card.*;
import player.Player;
import rules.InitializeGame;

import java.util.LinkedList;
import java.util.Scanner;

public class InitializeGameV1 implements InitializeGame {
    private final LinkedList<Card> cardDeck = new LinkedList<>();
    private final LinkedList<Player> players = new LinkedList<>();
    @Override
    public LinkedList<Card> createCardDeck() {
        String[] colors = {"Red", "Yellow", "Blue", "Green"};
        String[] numbers = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        for(int i = 0 ; i < 2 ; i++){
            //initialize numbered cards
            for (String color : colors) {
                for (String number : numbers) {
                    if (!number.equals("Zero") || i !=0) {
                        cardDeck.add(new NumberedCard(number, color));
                    }
                }
                //initialize action cards
                cardDeck.add(new ReverseCard("Reverse",color));
                cardDeck.add(new SkipCard("Skip", color));
                cardDeck.add(new DrawTwoCard("DrawTwo", color));
                //initialize wild cards
                if(i == 0) {
                    cardDeck.add(new DrawFourCard("DrawFour", "Black"));
                    cardDeck.add(new WildCard("Wild", "Black"));
                }
            }
        }
        return cardDeck;
    }

    @Override
    public LinkedList<Player> initiatePlayers() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        int numOfPlayers = s.nextInt();
        while(numOfPlayers<2 || numOfPlayers > 7){
            System.out.println("Number of Players has to be between (2-7)\nEnter the number of players: ");
            numOfPlayers = s.nextInt();
        }
        s.nextLine();
        for(int i = 0 ; i < numOfPlayers ; i++){
            System.out.println("Player " + (i+1) + ", Enter your Name: ");
            String playerName = s.nextLine();
            players.add(new Player(playerName));
        }
        return players;
    }
}
