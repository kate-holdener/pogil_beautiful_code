import java.util.ArrayList;
import java.util.Random;
public class Deck
{  private ArrayList<Card> x;
   private Random y;
public void rand()
{
    for (int i = 0; i < x.size(); i++)
    {   int swap_with = y.nextInt(x.size());
        Card a = x.get(i);
        x.set(i, x.get(swap_with));
        x.set(swap_with, a);
    }
}











   public Deck()
   {
     x = new ArrayList<Card>();

     for (Card.Face face: Card.Face.values())
     {
         x.add(new Card(face, Card.Suite.SPADES));
         x.add(new Card(face, Card.Suite.HEARTS));
         x.add(new Card(face, Card.Suite.CLUBS));
         x.add(new Card(face, Card.Suite.DIAMONDS));
     }
 y = new Random();
   }
   public Card card()
   {
       Card c = x.remove(x.size()-1);
   return c;}

}
