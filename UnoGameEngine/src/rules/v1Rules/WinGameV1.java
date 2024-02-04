package rules.v1Rules;

import card.Card;
import player.Player;
import rules.InitializeGame;
import rules.WinGame;

import java.util.LinkedList;

public class WinGameV1 implements WinGame {
    LinkedList<Player>players;
    Player player;
    public WinGameV1(LinkedList<Player> players,Player player) {
        this.player=player;
        this.players=players;
    }
    @Override
    public boolean checkWin() {
        return player.getScore() >= 500;
    }

    @Override
    public LinkedList<Card> regenerateCards() {
        InitializeGame i = new InitializeGameV1();
        return i.createCardDeck();
    }
}
