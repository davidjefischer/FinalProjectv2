public class War
{
   private Deck deck;
   
   private Hand player1Hand, player2Hand;
   
   private Middle player1Middle, player2Middle;
   
   public War()
   {
      deck = new Deck();
      
      //shuffle the deck
      deck.shuffle();
      
      //split the deck into two hands
      player1Hand = new Hand(deck, 0, 25);
      player2Hand = new Hand(deck, 26, 51);
      
      player1Middle = new Middle(0);
      player2Middle = new Middle(0);
   }
   
   public void playTurn()
   {
      player1Middle.add(player1Hand.draw());
      player2Middle.add(player2Hand.draw());
   }
   
   public void shuffle()
   {
      player1Hand.shuffle();
      player2Hand.shuffle();
   }
   
   public CardPile getPlayer1Middle()
   {
      return new CardPile(player1Middle);
   }
   
   public CardPile getPlayer2Middle()
   {
      return new CardPile(player2Middle);
   }
   
   public int testMiddle()
   {
      if (player1Middle.getTop().getRank() > player2Middle.getTop().getRank())
      {
         return 1;
      }
      else if (player2Middle.getTop().getRank() > player1Middle.getTop().getRank())
      {
         return 2;
      }
      else
      {
         return 3;
      }
   }
   
   public Card getTopPlayer1Middle()
   {
      return player1Middle.get(player1Middle.getSize() - 1);
   }
   
   public Card getTopPlayer2Middle()
   {
      return player2Middle.get(player2Middle.getSize() - 1);
   }
   
   public void clearMiddle()
   {
      player1Middle.removeAll();
      player2Middle.removeAll();
   }
   
   public void clearMiddle(int winner)
   {
      if (winner == 1)
      {
         player1Hand.add(player1Middle.getAll());
         player2Hand.add(player2Middle.getAll());
         player1Middle.removeAll();
         player2Middle.removeAll();
      }
      else if (winner == 2)
      {
         player2Hand.add(player1Middle.getAll());
         player2Hand.add(player2Middle.getAll());
         player1Middle.removeAll();
         player2Middle.removeAll();
      }
   }
   
   public int war()
   {
      int winner = 0;
      //burn three cards
      for (int count = 0; count < 3; count ++)
      {
         winner = checkWinner();
         if (winner != 0)
         {
            return winner;
         }
         else
         {
            player1Middle.add(player1Hand.draw());
            player2Middle.add(player2Hand.draw());
         }
      }
      
      return winner;
   }
   
   public int checkWinner()
   {
      if (player1Hand.isEmpty())
      {
         return 2;
      }
      else if (player2Hand.isEmpty())
      {
         return 1;
      }
      else
      {
         return 0;
      }
   }
}