import java.util.Scanner;
public class BlackJack
{
   private Hand hand1; // player's hand
   private Hand hand2; // dealer's hand
   private Deck dealCards;
   private Scanner scanner; // object for reading input from terminal
   public void playersTurn()
   {
      boolean hit = false;
      boolean invalid = false;
      do
      {
         hit = false;
         invalid = false;
         if (!invalid)
         {
            System.out.println("\n-----------------");
            System.out.println("Your hand");
            hand1.showAll();
         }
         System.out.println("Hit or Stand (H/S)?");
         String userInput = scanner.nextLine();
         if (userInput.startsWith("H") || userInput.startsWith("h"))
         {
            hit = true;
            Card nextCard = dealCards.removeTopCard();
            hand1.add(nextCard);
         }
         else if (!userInput.startsWith("S") && !userInput.startsWith("s"))
         {
            invalid = true;
         }
      }while (invalid || hit);

   }
   public void dealersTurn()
   {
   while (hand2.getValue() < 17)
   {
   Card c = dealCards.removeTopCard();
   hand2.add(c);
   }
   }
   public boolean winner()
   {
      boolean youAreAWinner = false;
      if (hand1.getValue() > 21)
      {
         youAreAWinner = false;
      }
      else if (hand2.getValue() > 21)
      {
         youAreAWinner = true;
      }
      else if (hand1.getValue() > hand2.getValue())
      {
         youAreAWinner = true;
      }
      return youAreAWinner;
   }

   public BlackJack()
   {
      hand1 = new Hand();
      hand2 = new Hand();
      dealCards = new Deck();
      dealCards.shuffle();
      scanner = new Scanner(System.in);
   }
   public void newGame()
   {
      Card c = dealCards.removeTopCard();
      hand1.add(c);
      c = dealCards.removeTopCard();
      hand1.add(c);
 c = dealCards.removeTopCard();
      hand2.add(c);
      c = dealCards.removeTopCard();
      hand2.add(c);
      System.out.println("Dealer shows");
      hand2.showOne();
   }
   public static void main(String []args)
   {
      BlackJack blackJack = new BlackJack();
      blackJack.newGame();
      blackJack.playersTurn();
      blackJack.dealersTurn();
      System.out.println("\n-----------------");
      System.out.println("Dealer's hand");
      blackJack.hand2.showAll();
      System.out.println("\n-----------------");
      System.out.println("Your hand");
      blackJack.hand1.showAll();
      if (blackJack.winner())
      {
         System.out.println("You win");
      }
      else
      {
         System.out.println("You lose");
      }
   }
}
