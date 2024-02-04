package card;

import player.Player;

import java.util.LinkedList;

public class PlayGolden implements Functionality{

    @Override
    public Player function(LinkedList<Card>cards, LinkedList<Player> players, Player player) {
        player.getPlayerCards().clear();
        player.setScore(500);

        return player;
    }
}
