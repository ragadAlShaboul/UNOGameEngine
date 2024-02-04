package card;

import player.Player;

import java.util.LinkedList;

public class PlayReverse implements Functionality{
    @Override
    public Player function(LinkedList<Card>cards, LinkedList<Player> players, Player player) {
        LinkedList<Player> reversedPlayers = new LinkedList<>();
        Player nextPlayer = player;
        if(players.size()>2) {
            for (int i = players.size() - 1; i >= 0; i--)
                reversedPlayers.add(players.remove(i));
            for (Player player1 : reversedPlayers)
                players.add(player1);
        }else {
            int index = players.indexOf(player);
            if (index == players.size() - 1)
                nextPlayer = players.get(0);
            else nextPlayer = players.get(index + 1);
        }
        return nextPlayer;
    }
}
