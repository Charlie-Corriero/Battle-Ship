/* Charlie Corriero CS110

This class extends board and constructs the user board. It has methods to change hit status to sunk,
make a computer move, and return the board as a srting.

*/
import java.util.Random;
import java.util.ArrayList;
import java.io.*;
public class UserBoard extends Board
{
   //Initialize the random variable
   Random rand = new Random();
   ArrayList<Move> moves = new ArrayList();
   
   /**
   * The UserBoard method takes a file name and runs it throught the parent class constructor to make a board.
   * @param file that takes a file name to read
   */
   public UserBoard(String file) throws FileNotFoundException
   {
      super(file);
      
      for (int c =0; c < SIZE; c++)
      {
         for (int r = 0; r < SIZE; r++)
         {
         
            moves.add(new Move(c,r));
            
         }
      }
      
   }
   
   /**
   * Checks for the ShipType and changes the hit status to sunk
   * @param t a ShipType given to the method
   */
   private void hitToSunk(ShipType t)
   {
      for (int r = 0; r < 10; r++)
            {
               for (int c = 0; c < 10; c++)
               {
                  if (super.getLayout().get(r).get(c) == CellStatus.CRUISER_HIT && t == ShipType.ST_CRUISER)
                  {
                     super.getLayout().get(r).set((c),CellStatus.CRUISER_SUNK);
                  }
                  if (super.getLayout().get(r).get(c) == CellStatus.SUB_HIT && t == ShipType.ST_SUB)
                  {
                     super.getLayout().get(r).set((c),CellStatus.SUB_SUNK);
                  }
                  if (super.getLayout().get(r).get(c) == CellStatus.DESTROYER_HIT && t == ShipType.ST_DESTROYER)
                  {
                     super.getLayout().get(r).set((c),CellStatus.DESTROYER_SUNK);
                  }
                  if (super.getLayout().get(r).get(c) == CellStatus.BATTLESHIP_HIT && t == ShipType.ST_BATTLESHIP)
                  {
                     super.getLayout().get(r).set((c),CellStatus.BATTLESHIP_SUNK);
                  }
                  if (super.getLayout().get(r).get(c) == CellStatus.AIRCRAFT_CARRIER_HIT && t == ShipType.ST_AIRCRAFT_CARRIER)
                  {
                     super.getLayout().get(r).set((c),CellStatus.AIRCRAFT_CARRIER_SUNK);
                  }
               }
            }
   }
   
   /*
   * This method picks a random move from the arrayList of moves
   */
   public Move pickRandomMove()
   {
      int index = rand.nextInt(moves.size());
      Move move = moves.get(index);
      moves.remove(index);
      return move;
   }
   
   /**
   * This method picks a random move and applies the move
   * @return a list of the string of the move and a string saying the ship was sunk if it was, null if it wasn't sunk
   */
   public String[] makeComputerMove()
   {
      Move move = pickRandomMove();
 
      
      CellStatus target = applyMoveToLayout(move);
      

      
      ArrayList<ArrayList<CellStatus>> layoutC = super.getLayout();
      Fleet fleetC = super.getFleet();
      
      
      
      //checking if the ship is hit
      if (target == CellStatus.CRUISER && super.getFleet().updateFleet(ShipType.ST_CRUISER))
      {
      hitToSunk(ShipType.ST_CRUISER);
      String[] moveReturn = {move.toString(),"You sunk my Cruiser!"};
      return moveReturn;  
      }
      else if (target == CellStatus.SUB && super.getFleet().updateFleet(ShipType.ST_SUB))
      {
      hitToSunk(ShipType.ST_SUB);
      String[] moveReturn = {move.toString(),"You sunk my Submarine!"};
      return moveReturn;  
      }
      else if (target == CellStatus.DESTROYER && super.getFleet().updateFleet(ShipType.ST_DESTROYER))
      {
      hitToSunk(ShipType.ST_DESTROYER);
      String[] moveReturn = {move.toString(),"You sunk my Destroyer!"};
      return moveReturn;  
      }    
      else if (target == CellStatus.AIRCRAFT_CARRIER && super.getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
      {
      hitToSunk(ShipType.ST_AIRCRAFT_CARRIER);
      String[] moveReturn = {move.toString(),"You sunk my Aircraft Carrier!"};
      return moveReturn;  
      }  
      else if (target == CellStatus.BATTLESHIP && super.getFleet().updateFleet(ShipType.ST_BATTLESHIP))
      {
      hitToSunk(ShipType.ST_BATTLESHIP);
      String[] moveReturn = {move.toString(),"You sunk my Battleship!"};
      return moveReturn;  
      }
      else{
      String[] moveReturn = {move.toString(),null};
      return moveReturn;  
      }
   }
         /**
         * @Override
         * Overrides the toString method and returns the board
         * @return the board as a string
         */
         public String toString()
         {
         char let = 'A';
         String s = " ";
         s += "  1 2 3 4 5 6 7 8 9 10";
         for (int r = 0; r < 10; r++)
         {
          s+= String.format("\n %c ",let);
          let++;
         for (int c = 0; c < 10; c++)
            {
            
            s +=( super.getLayout().get(r).get(c).toString().charAt(1) + " ");
            }
         }
         return s;
         }
   
   /*
   * This mehod returns an index
   * @return the index as an int
   */
   public int getMove()
   {
      int index = rand.nextInt(moves.size());
      return index;
   }
}
