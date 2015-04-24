public class Middle extends CardPile
{
   
   public Middle(int numItems)
   {
      super(numItems);
   }
   public CardPile getAll()
   {
      CardPile toReturn = new CardPile();
      for (int count = 0; count < getSize(); count++)
      {
         toReturn.add(get(count));
      }
      
      return toReturn;
   }
   
   public CardPile getIncrement(int increment)
   {
      CardPile toReturn = new CardPile();
      for (int count = 0; count < getSize(); count += increment)
      {
         toReturn.add(get(count));
      }
      
      return toReturn;
   }
   
   public void removeAll()
   {
      removeIncrement(1);
   }
   
   public void removeIncrement(int increment)
   {
      for (int count = 0; count < getSize(); count += increment)
      {
         remove(count);
      }
   }
   
   public Card getTop()
   {
      return get(getSize() - 1);
   }
}