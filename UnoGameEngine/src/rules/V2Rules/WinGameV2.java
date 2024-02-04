package rules.V2Rules;

import card.Card;
import player.Player;
import rules.InitializeGame;
import rules.WinGame;

import java.util.LinkedList;

public class WinGameV2 implements WinGame {
    LinkedList<Player>players;
    Player player;
    public WinGameV2(LinkedList<Player> players,Player player) {
        this.player=player;
        this.players=players;
    }

    @Override
    public boolean checkWin() {
        return player.getScore() >= 500;
    }

    @Override
    public LinkedList<Card> regenerateCards() {
        InitializeGame i = new InitializeGameV2();
        return i.createCardDeck();
    }
}
