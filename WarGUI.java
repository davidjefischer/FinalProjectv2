import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{
   private War game;
   private JPanel topPanel, midPanel, bottomPanel, player1Battle, player2Battle, nextPanel,
               extrasPanel, actionsPanel;
   private JLabel status, title, result, player1Deck, player2Deck;
   private JLabel[] player1Mid, player2Mid;
   private JButton next, play, shuffle, reset;
   
   public WarGUI()
   {
      setLayout(new GridLayout(3, 1));
      
      game = new War();
      
      topPanel = new JPanel();
      System.out.println(Card.BACK_LINK);
      ImageIcon image = new ImageIcon(Card.BACK_LINK);
      player2Deck = new JLabel(image);
      topPanel.add(player2Deck);
      add(topPanel);
      
      // midPanel = new JPanel();
//       midPanel.setLayout(new GridLayout(2,2));
//       
//       player1Battle = new JPanel();
//       player2Battle = new JPanel();
//       player1Mid = new JLabel[0];
//       player2Mid = new JLabel[0];
//       midPanel.add(player2Battle);
//       midPanel.add(player1Battle);
//       
//       extrasPanel = new JPanel();
//       extrasPanel.setLayout(new GridLayout(2,1));
//       result = new JLabel();
//       extrasPanel.add(result);
//       nextPanel = new JPanel();
//       next = new JButton("Continue");
//       next.addActionListener(new nextListener());
//       next.setEnabled(false);
//       nextPanel.add(next);
//       extrasPanel.add(nextPanel);
//       midPanel.add(extrasPanel);
//       add(midPanel);
//       
//       bottomPanel = new JPanel();
//       bottomPanel.setLayout(new GridLayout(1,2));
//       player1Deck = new JLabel(new ImageIcon(Card.BACK_LINK));
//       bottomPanel.add(player1Deck);
//       actionsPanel = new JPanel();
//       play = new JButton("Play a turn");
//       play.addActionListener(new playTurn());
//       actionsPanel.add(play);
//       shuffle = new JButton("Shuffle");
//       shuffle.addActionListener(new shuffleListener());
//       actionsPanel.add(shuffle);
//       reset = new JButton("Start a new game");
//       reset.addActionListener(new newGame());
//       actionsPanel.add(reset);
//       bottomPanel.add(actionsPanel);
//       add(bottomPanel);
   }
   
   private class playTurn implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //check if either player is out of cards
         int winner = game.checkWinner();
         if (winner == 1)
         {
            status.setText("Player 1 wins!");
            result.setText("Player 1 wins!");
            disableAll();
         }
         else if (winner == 2)
         {
            status.setText("Player 2 wins!");
            result.setText("Player 2 wins!");
            disableAll();
         }
         else
         {
            //play a turn
            game.playTurn();
            
            //update the middle of the graphical interface
            updateMiddle();
         }
         next.setEnabled(true);
      }
   }
   
   public void updateMiddle()
   {
       player1Battle.removeAll();
       player2Battle.removeAll();

      //clear the label arrays that will hold the images
      player1Mid = new JLabel[game.getPlayer1Middle().getSize() - 1];
      player2Mid = new JLabel[game.getPlayer2Middle().getSize() - 1];
      
      //for each item in the middle, add the card to the middle label
      for (int count = 0; count < game.getPlayer1Middle().getSize(); count++)
      {
         player1Mid[count] = new JLabel(new ImageIcon(game.getPlayer1Middle().get(count).getImageLink()));
      }
      
      for (int count = 0; count < game.getPlayer2Middle().getSize(); count++)
      {
         player2Mid[count] = new JLabel(new ImageIcon(game.getPlayer2Middle().get(count).getImageLink()));
      }
      
      for (JLabel label : player1Mid)
      {
         player1Battle.add(label);
      }
      
      for (JLabel label : player2Mid)
      {
         player2Battle.add(label);
      }
   }
   
   public void disableAll()
   {
      next.setEnabled(false);
      play.setEnabled(false);
      shuffle.setEnabled(false);
      reset.setEnabled(false);
   }
   
   private class nextListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //check if either players ran out of cards
         int checkWin = game.checkWinner();
         if (checkWin == 1)
         {
            status.setText("Player 1 won the game!");
            result.setText("Player 1 won the game!");
            disableAll();
         }
         else if (checkWin == 2)
         {
            status.setText("Player 2 won the game!");
            result.setText("Player 2 won the game!");
            disableAll();
         }
         else
         {
            //test the middle to see which player won
            int winner = game.testMiddle();
            if (winner == 1)
            {
               game.clearMiddle(1);
               result.setText("Player 1 won the round!");
            }
            else if (winner == 2)
            {
               game.clearMiddle(2);
               result.setText("Player 2 won the round!");
            }
            else
            {
               //if neither player won, there's a war!
               //create a while loop that will run as long as winner != 1 or 2
               while (winner != 1 && winner != 2)
               {
                  //draw three cards from each hand with the war method of the war class
                  int war = game.war();
                  //if the war method returns 1 or 2, a player won during the draw three
                  if (war == 1)
                  {
                     status.setText("Player 1 won the game!");
                     result.setText("Player 1 won the game!");
                     disableAll();
                  }
                  else if (war == 2)
                  {
                     status.setText("Player 1 won the game!");
                     result.setText("Player 1 won the game!");
                     disableAll();
                  }
                  else
                  {
                     //check if either player ran out of cards
                     checkWin = game.checkWinner();
                     if (checkWin == 1)
                     {
                        status.setText("Player 1 won the game!");
                        result.setText("Player 1 won the game!");
                        disableAll();
                     }
                     else if (checkWin == 2)
                     {
                        status.setText("Player 2 won the game!");
                        result.setText("Player 2 won the game!");
                        disableAll();
                     }
                     else
                     {
                        //play a turn
                        game.playTurn();
                        
                        //test the middle
                        winner = game.testMiddle();
                     }
                  }
               }
            }
            
            updateMiddle();
         }
         
         next.setEnabled(false);
      }
      
      
   }
   
   public class shuffleListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         game.shuffle();
      }
   }
   
   public class newGame implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         game = new War();
         updateMiddle();
      }
   }
}