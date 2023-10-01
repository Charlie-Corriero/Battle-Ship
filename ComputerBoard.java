/* Charlie Corriero CS110

This class extends board and constructs the computer board. It has methods to change hit status to sunk,
make a player move, and return the board as a srting.

*/
import java.util.ArrayList;
import java.io.*;
public class ComputerBoard extends Board
{
   /**
   * The ComputerBoard method takes a file name and runs it throught the parent class constructor to make a board.
   * @param file that takes a file name to read
   */
   public ComputerBoard(String file) throws FileNotFoundException
   {
      super(file);
      
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
   
   /**
   * The makePlayerMove applies the move to the layout and returns a string saying your ship was sunk if it was sunk
   * @param m is a Move
   * @return a String saying which ship was sunk if it was sunk
   */
   public String makePlayerMove(Move m)
   {
      CellStatus target = applyMoveToLayout(m);
      
    
      if (target == CellStatus.BATTLESHIP && super.getFleet().updateFleet(ShipType.ST_BATTLESHIP))
      {
         hitToSunk(ShipType.ST_BATTLESHIP);
         return "You sank my Battleship!";
      }
      
      else if (target == CellStatus.SUB && super.getFleet().updateFleet(ShipType.ST_SUB))
      {
         hitToSunk(ShipType.ST_SUB);
         return "You sank my Sub!";
      }
      
      else if (target == CellStatus.CRUISER && super.getFleet().updateFleet(ShipType.ST_CRUISER))
      {
         hitToSunk(ShipType.ST_CRUISER);
         return "You sank my Cruiser!";
      }
      
      else if (target == CellStatus.AIRCRAFT_CARRIER && super.getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
      {
         hitToSunk(ShipType.ST_AIRCRAFT_CARRIER);
         return "You sank my Aircraft Carrier!";
      }
      
      else if (target == CellStatus.DESTROYER && super.getFleet().updateFleet(ShipType.ST_DESTROYER))
      {
        hitToSunk(ShipType.ST_DESTROYER);
         return "You sank my Destroyer";
      }
      else{
      return null;
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
            
             s +=( super.getLayout().get(r).get(c).toString().charAt(0) + " ");
            
            }
         }
         return s;
      }
   }
