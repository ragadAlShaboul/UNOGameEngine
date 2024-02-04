package rules;

import card.Card;
import card.PlayReverse;
import player.Player;

import java.util.ArrayList;
import java.util.LinkedList;

public interface InitializeGame {
    public LinkedList<Card> createCardDeck();
    public LinkedList<Player> initiatePlayers();
}
