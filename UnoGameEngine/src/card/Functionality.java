package card;

import player.Player;

import java.util.LinkedList;

public interface Functionality {
    public Player function(LinkedList<Card>cards, LinkedList<Player> players, Player player);
}
