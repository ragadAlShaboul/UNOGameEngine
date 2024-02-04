package rules;

import card.Card;

import java.util.LinkedList;

public interface WinGame {
    public boolean checkWin();
    public LinkedList<Card> regenerateCards();
}
