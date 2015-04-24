public class Hand extends CardPile
{
   public Hand()
   {
   }
   
   public Hand(Deck deck, int start, int end)
   {
      add(deck.getRange(start, end));
   }
   
   public Card draw()
   {
      Card toReturn = get(0);
      remove(0);
      return toReturn;
   }
}