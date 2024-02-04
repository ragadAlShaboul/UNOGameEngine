package rules;

import card.Card;
import player.Player;

public interface PlayRound {
    public void dropCard();
    public boolean matchCard(Card card);
    public void implementCard();
    public Player getNextPlayer();
    public boolean roundWin();
    public void updateScore();
    public Player getRoundWinner();
    public boolean drawNoMatchingCard();
}
