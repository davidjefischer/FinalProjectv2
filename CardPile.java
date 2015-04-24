import java.util.ArrayList;
import java.util.Random;

public class CardPile
{
   private ArrayList<Card> pile;
   
   public CardPile()
   {
      pile = new ArrayList<Card>();
   }
   
   public CardPile(int numItems)
   {
      pile = new ArrayList<Card>(numItems);
   }
   
   public CardPile(ArrayList<Card> toCopy)
   {
      pile = new ArrayList<Card>(toCopy);
   }
   
   public CardPile(CardPile toCopy)
   {
      for (int count = 0; count < toCopy.getSize() - 1; count++)
      {
         pile.add(toCopy.get(count));
      }
   }
   
   public int getSize()
   {
      return pile.size();
   }
   
   public void add(Card toAdd)
   {
      pile.add(toAdd);
   }
   
   public void add(CardPile toAdd)
   {
      for (int count = 0; count < toAdd.getSize(); count++)
      {
         pile.add(toAdd.get(count));
      }
   }
   
   public void remove(int index)
   {
      pile.remove(index);
   }
   
   public Card get(int index)
   {
      return pile.get(index);
   }
   
   /**
   shuffle method that shuffles the deck
   */
   public void shuffle()
   {
      //shuffle will create a new array list card with a size of 52 (num_suit * num_rank)
      //it will then pop random cards off of the current deck and put them into the new
      //deck
      Random rand = new Random();
      
      //create a copy of the pile
      ArrayList<Card> pileCopy = new ArrayList<Card>();
      
      ArrayList<Card> tempDeck = new ArrayList<Card>();
      
      int random;
      
      for (int count = 0; count < pile.size(); count++)
      {
         random = rand.nextInt(getSize());
         tempDeck.add(get(random));
         remove(random);
      }
      
      //put all of the cards in tempDeck back into the pile
      for (Card card: tempDeck)
      {
         add(card);
      }
   }
   
   /**
   isEmpty determines if the deck is empty
   @return True if deck is empty, false if not.
   */
   public boolean isEmpty()
   {
      if (pile.isEmpty())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}