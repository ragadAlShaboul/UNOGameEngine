import rules.v1Rules.DistributeCardsV1;
import rules.v1Rules.InitializeGameV1;
import rules.v1Rules.PlayRoundV1;
import rules.v1Rules.WinGameV1;

public class MyGame extends Game{
    @Override
    public void initializeGame() {
        setInitializeGame(new InitializeGameV1());
        cardDeck = initializeGame.createCardDeck();
        players = initializeGame.initiatePlayers();
        winner = players.getFirst();
    }

    @Override
    public void distributeCards() {
        setDistributeCards(new DistributeCardsV1(cardDeck,players));
        distributeCards.shuffleCards();
        distributeCards.dealCards();
        globalCard=distributeCards.globalCard();
    }

    @Override
    public void playRound() {
        setPlayRound(new PlayRoundV1(cardDeck, players, globalCard));
        while (!playRound.roundWin()){
            playRound.dropCard();
            playRound.implementCard();
        }
        playRound.updateScore();
        winner = playRound.getRoundWinner();
        System.out.println("Round "+roundNumber++ +" is finished.");
        System.out.println("Winner for the round is player "+winner.getName());
        System.out.println(winner.getName()+ "'s score is: " +winner.getScore());
    }

    @Override
    public boolean win() {
        setWinGame(new WinGameV1(players,players.get(0)));
        if(winGame.checkWin())return true;
        cardDeck = initializeGame.createCardDeck();
        return false;
    }

    @Override
    public void endGame() {
        System.out.println(winner.getName()+"you won");
    }
}
