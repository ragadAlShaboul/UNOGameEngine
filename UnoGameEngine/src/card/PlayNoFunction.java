package card;

import player.Player;

import java.util.LinkedList;

public class PlayNoFunction implements Functionality{
    @Override
    public Player function(LinkedList<Card> cards, LinkedList<Player> players, Player player) {

//        int index = players.indexOf(player);
//        Player nextPlayer;
//        if(index == players.size()-1)
//            nextPlayer = players.get(0);
//        else nextPlayer = players.get(index+1);
        return player;
    }
}
