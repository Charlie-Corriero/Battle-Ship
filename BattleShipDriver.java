/* Charlie Corriero CS110

This class makes the game come to life and makes it playable. Calls a coin flip to decide who goes 
first, checks if someone has won and displays who has won


*/
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class BattleShipDriver
{
   public static void main(String[] args) throws FileNotFoundException
   {
      Game game = new Game();
      System.out.println("Welcome to Battleship!\n");
      Random rand = new Random();
      int coin = rand.nextInt(2);
      
      Scanner keyboard = new Scanner(System.in);
      
      
      if (coin == 0)
      {
         System.out.println("The player won the coin toss and gets to go first.\n");
         
         
         while (game.userDefeated() == false && game.computerDefeated() == false)
         {   
            String strMovePlayer;
            String[] strMoveComputer;
            
            
               
            System.out.print("Your turn: ");
            strMovePlayer = keyboard.nextLine().toUpperCase();
            
            try{
            game.makePlayerMove(strMovePlayer);
            }
            catch (NumberFormatException e){
            System.out.print("Please enter the move in LetterNumber Format");
            strMovePlayer = keyboard.nextLine().toUpperCase();
            game.makePlayerMove(strMovePlayer);
            } 
            catch (IndexOutOfBoundsException e){
            System.out.print("Please enter a number between 1 and 10");
            strMovePlayer = keyboard.nextLine().toUpperCase();
            game.makePlayerMove(strMovePlayer);
            }
            
            System.out.println(game);
            
            
            String wait;
            System.out.print("Computers turn. Press 'Enter' to continue ");
            wait = keyboard.nextLine();
            
            strMoveComputer = game.makeComputerMove();
            System.out.println("Computer chose: " + strMoveComputer[0] + "\n");
            System.out.println(game);
            
            
         }
         System.out.println("Game over!");
         if (game.userDefeated() == true)
         {
            System.out.println("The computer has won!");
         }
         else if (game.userDefeated() == true)
         {
            System.out.println("The player has won!");
         }

      }
      else
      {
         System.out.println("The computer won the coin toss and gets to go first.\n");
         
         while (game.userDefeated() == false && game.computerDefeated() == false)
         {   
            String strMovePlayer;
            String[] strMoveComputer;
            
            
            String wait;
            System.out.print("Computers turn. Press 'Enter' to continue ");
            wait = keyboard.nextLine();
            
            strMoveComputer = game.makeComputerMove();
            System.out.println("Computer chose: " + strMoveComputer[0] + "\n");
            System.out.println(game);   
               
               
            System.out.print("Your turn: ");
            strMovePlayer = keyboard.nextLine().toUpperCase();
            try{
            game.makePlayerMove(strMovePlayer);
            }
            catch (NumberFormatException e){
            System.out.print("Please enter the move in LetterNumber Format");
            strMovePlayer = keyboard.nextLine().toUpperCase();
            game.makePlayerMove(strMovePlayer);
            }
            catch (IndexOutOfBoundsException e){
            System.out.print("Please enter a number between 1 and 10");
            strMovePlayer = keyboard.nextLine().toUpperCase();
            game.makePlayerMove(strMovePlayer);
            }
            System.out.println(game);
         }
         System.out.println("Game over!");
         if (game.userDefeated() == true)
         {
            System.out.println("The computer has won!");
         }
         else if (game.userDefeated() == true)
         {
            System.out.println("The player has won!");
         }
      }
   }
}