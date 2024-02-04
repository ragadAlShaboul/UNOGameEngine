import card.Card;
import player.Player;
import rules.DistributeCards;
import rules.InitializeGame;
import rules.PlayRound;
import rules.WinGame;

import java.util.LinkedList;

public abstract class Game {
    protected InitializeGame initializeGame;
    protected DistributeCards distributeCards;
    protected PlayRound playRound;
    protected WinGame winGame;
    protected LinkedList<Card> cardDeck = new LinkedList<>();
    protected LinkedList<Player> players =new LinkedList<>();
    protected Player winner ;
    protected int roundNumber = 0;
    protected Card globalCard;

    public void play(){
        initializeGame();
        while (!win()){
            distributeCards();
            playRound();
        }
        endGame();
    }
    public abstract void initializeGame();
    public abstract void distributeCards();
    public abstract void playRound();
    public abstract boolean win();
    public abstract void endGame();

    public void setInitializeGame(InitializeGame initializeGame) {
        this.initializeGame = initializeGame;
    }

    public void setDistributeCards(DistributeCards distributeCards) {
        this.distributeCards = distributeCards;
    }

    public void setPlayRound(PlayRound playRound) {
        this.playRound = playRound;
    }

    public void setWinGame(WinGame winGame) {
        this.winGame = winGame;
    }
}
