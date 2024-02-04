package card;

import java.util.LinkedList;
import java.util.Scanner;

public class ActWild implements Wildity{
    @Override
    public void act(LinkedList<Card> cards, Card globlaCard) {
        System.out.println("Select color [Red, Green, Yellow, Blue]: ");
        Scanner s =new Scanner(System.in);
        String color = s.next();
        globlaCard.setCardColor(color);
    }
}
