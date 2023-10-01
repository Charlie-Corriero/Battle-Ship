/* Charlie Corriero CS110

Creates a game class that initializes a player and computer board. Has methods to make a computer move, make a player move,
check if the user is defeated, check if the computer is defeated, and a toString that returns a string of the boards

*/
import java.io.*;
public class Game
{   
   private ComputerBoard computer;
   private UserBoard player;
   
   public Game() throws FileNotFoundException
   {
      computer = new ComputerBoard("compFleet.txt");
      player = new UserBoard("userFleet.txt");
   }
   
   public String[] makeComputerMove()
   {
      return player.makeComputerMove();
   }
   
   public String makePlayerMove(String s)
   {
      Move m = new Move(s);
      return computer.makePlayerMove(m);
   }
   
   public boolean computerDefeated()
   {
      if (computer.gameOver())
      {
         return true;
      }
      else{
         return false;
      }
   }
   
   public boolean userDefeated()
   {
      if (player.gameOver())
      {
         return true;
      }
      else{
         return false;
      }
   }
   
   @Override
   public String toString()
   {
      String s = " ";
      s += "COMPUTER\n";
      s += computer.toString();
      s += "\n\nUSER\n";
      s += player.toString();
      return s;
   }
}