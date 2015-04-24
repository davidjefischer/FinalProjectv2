/*
Card class
*/
public class Card
{
   enum Rank {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
                  EIGHT, NINE, TEN, JACK, QUEEN, KING}
                  
   enum Suit {HEARTS, SPADES, CLUBS, DIAMONDS}
   public static final String BACK_LINK = "/cardpics/back.jpg";
   private Rank rank;
   private Suit suit;
   private String image;
   
   /**
   constructor assigns values to the fields rank and suit.
   @param suit An integer that should be between 0 and 3 (anything higher than three or 
   lower than 0 will be treated as a three) that will define the suit of the card.
   @param rank An integer between one and 13 (anything higher than 13 or lower than 0 will
   be treated as 13) that will define the rank of the card.
   */
   public Card(int suit, int rank)
   {
      image = "/cardpics/";
      //note: ranks start at 1, not 0, so that the value of the card is accurate
      //also note that aces are low
      if (rank == 1)
      {
         this.rank = Rank.ACE;
         image += "ace";
      }
      else if (rank == 2)
      {
         this.rank = Rank.TWO;
         image += "2";
      }
      else if (rank == 3)
      {
         this.rank = Rank.THREE;
         image += "3";
      }
      else if (rank == 4)
      {
         this.rank = Rank.FOUR;
         image += "4";
      }
      else if (rank == 5)
      {
         this.rank = Rank.FIVE;
         image += "5";
      }
      else if (rank == 6)
      {
         this.rank = Rank.SIX;
         image += "6";
      }
      else if (rank == 7)
      {
         this.rank = Rank.SEVEN;
         image += "7";
      }
      else if (rank == 8)
      {
         this.rank = Rank.EIGHT;
         image += "8";
      }
      else if (rank == 9)
      {
         this.rank = Rank.NINE;
         image += "9";
      }
      else if (rank == 10)
      {
         this.rank = Rank.TEN;
         image += "10";
      }
      else if (rank == 11)
      {
         this.rank = Rank.JACK;
         image += "jack";
      }
      else if (rank == 12)
      {
         this.rank = Rank.QUEEN;
         image += "queen";
      }
      else
      {
         this.rank = Rank.KING;
         image += "king";
      }
         
      if (suit == 0)
      {
         this.suit = Suit.HEARTS;
         image += "h";
      }
      else if (suit == 1)
      {
         this.suit = Suit.SPADES;
         image += "s";
      }
      else if (suit == 2)
      {
         this.suit = Suit.CLUBS;
         image += "c";
      }
      else
      {
         this.suit = Suit.DIAMONDS;
         image += "d";
      }
      
      image += ".jpg";       
   }
   
   /**
   get image link returns a string containing the image filename
   */
   public String getImageLink()
   {
      return image;
   }
   
   /**
   get suit class that will return an integer representing the suit of the card
   @return Integer that represents the suit of the card.
   */
   public int getSuit()
   {
      return suit.ordinal() + 1;
   }
   
   /**
   get rank class that returns an integer representing the rank of the card
   @return Integer that represents the rank of the card.
   */
   public int getRank()
   {
      return rank.ordinal() + 1;
   }
   
   /**
   to string class that returns the fields formatted into a string
   @return toReturn A string that contains the values of the fields, formatted.
   */
   public String toString()
   {
      String toReturn = "Suit: " + suit +"\nRank: " + rank;
      return toReturn;   
   }
   
   /**
   equals class defines what it means for one card to "equal" another
   @param other A second card to which to compare this card.
   @return Returns true if the ranks of the two cards are the same (which is what we 
   need for the purposes of the war game).
   */
   public boolean equals(Card other)
   {
      if (this.rank.equals(other.rank))
         return true;
      else
         return false;
   }
}