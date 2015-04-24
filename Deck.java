import java.util.ArrayList;

public class Deck extends CardPile
{
   public final static int NUM_SUIT = 4, NUM_RANK = 13;
   
   /**
   constructor creates an ordered deck
   */
   public Deck()
   {
      super(NUM_SUIT * NUM_RANK);
      
      for (int countSuit = 0; countSuit < NUM_SUIT; countSuit++)
      {
         for (int countRank = 1; countRank <= NUM_RANK; countRank++)
         {
            add(new Card(countSuit, countRank));
         }
      }
   }
   
   
   
   /**
   get range method returns a card pile that holds all cards in the range of indeces
   provided
   @param startIndex The index to start with.
   @param endIndex The index to end with.
   @return cardsInRange A card pile that contains the cards in the range provided.
   */
   public CardPile getRange(int startIndex, int endIndex)
   {
      CardPile cardsInRange = new CardPile();
      for (int count = startIndex; count <= endIndex; count++)
      {
         cardsInRange.add(get(count));
      }
      
      return cardsInRange;
   }
   
   public Card draw()
   {
      Card toReturn = get(0);
      remove(0);
      return toReturn;
   }
}