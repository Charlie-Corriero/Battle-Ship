/* Charlie Corriero CS110

This class initializes and makes the board. It adds the ships to the baord from the given file name.
It has methods to check if the move that was made is valid, apply moves to the layout, check if all 
the ships have sunk, return the layout, and return the fleet

*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Board
{

   private ArrayList<ArrayList<CellStatus>> layout;
   private Fleet fleet;
   public final int SIZE = 10;
   
   /**
     * The Board class, takes in a string for the file name and initializes fleet. initializes the board to an ArrayList of an ArrayList of CellStatus.
     * @param fn The file name of the board to be created
     */
   public Board(String fn) throws FileNotFoundException
   {
      
      layout = new ArrayList<>(10); 
           
      //Creates the rows and cols for the layout
      for (int i = 1; i <= 10; i++)
      {
          
          ArrayList<CellStatus> row = new ArrayList<CellStatus>(SIZE);
          for (int j = 1; j <= SIZE; j++)
            row.add(CellStatus.NOTHING); 
          layout.add(row);

      }
      
      
      //Initializes the fleet
      fleet = new Fleet();

      Scanner infile = new Scanner(new File(fn));
      
      //read data from the file
      while (infile.hasNext())
      {
         
         //Split the line from the file into an array of each part of the line
         String line = infile.nextLine();
         String[] arrLine = line.split("\\s+");

         //Cruiser add to board
         if (arrLine[0].equals("C"))
         {
         
            //Turn the line data from the file into moves
            Move shipStartC = new Move(arrLine[1]);
            Move shipEndC = new Move(arrLine[2]);

            
            //If row is the same
            int j = 0;
            if (shipStartC.row() == shipEndC.row())
            {
               for (int i = (shipStartC.col()); i <= shipEndC.col(); i++)
               {
                  layout.get(shipStartC.row()).set(shipStartC.col()+j, CellStatus.CRUISER);
                  j++;
               }
            } 
            
            //If col is the same
            if(shipStartC.col() == shipEndC.col())
            {
               for (int i = (shipStartC.row()); i <= shipEndC.row()+1; i++)
               {
                  layout.get(shipStartC.row()+j).set(((shipStartC.col())),CellStatus.CRUISER);
                  j++;
               }
            }  
         }
         
         //Aicraft carrier add to board
         else if (arrLine[0].equals("A"))
         {
         
            //Turn the line data from the file into moves
            Move shipStartA = new Move(arrLine[1]);
            Move shipEndA = new Move(arrLine[2]);
 
            
            //if row is the same
            int j = 0;
            if (shipStartA.row() == shipEndA.row())
            {
               for (int i = (shipStartA.col()); i <= shipEndA.col(); i++)
               {
                  layout.get(shipStartA.row()).set(shipStartA.col()+j, CellStatus.AIRCRAFT_CARRIER);
                  j++;
               }
            } 
            
            //If col is the same
            if(shipStartA.col() == shipEndA.col())
            {
               for (int i = (shipStartA.row()); i <= shipEndA.row()
               ; i++)
               {
                  layout.get(shipStartA.row()+j).set(((shipStartA.col())),CellStatus.AIRCRAFT_CARRIER);
                  j++;
               }
            }  
          }
          
          
          //Battleship add to board
           else if (arrLine[0].equals("B"))
         {
         
            //Turn the line data from the file into moves
            Move shipStartB = new Move(arrLine[1]);
            Move shipEndB = new Move(arrLine[2]);

            //if row is the same
            int j = 0;
            if (shipStartB.row() == shipEndB.row())
            {
               for (int i = (shipStartB.col()); i <= shipEndB.col(); i++)
               {
                  layout.get(shipStartB.row()).set(shipStartB.col()+j, CellStatus.BATTLESHIP);
                  j++;
               }
            } 
            
            //If col is the same
            if(shipStartB.col() == shipEndB.col())
            {
               for (int i = (shipStartB.row()); i <= shipEndB.row()+1; i++)
               {
                  layout.get(shipStartB.row()+j).set(((shipStartB.col())),CellStatus.BATTLESHIP);
                  j++;
               }
            }  
          }
           
           
               
               //Sub add to board
               else if (arrLine[0].equals("S"))
         {
         
            //Turn the line data from the file into moves
            Move shipStartS = new Move(arrLine[1]);
            Move shipEndS = new Move(arrLine[2]);
       
            
            //If row is the same
            int j = 0;
            if (shipStartS.row() == shipEndS.row())
            {
               for (int i = (shipStartS.col()); i <= shipEndS.col(); i++)
               {
                  layout.get(shipStartS.row()).set(shipStartS.col()+j, CellStatus.SUB);
                  j++;
               }
            } 
            
            //If col is the same
            if(shipStartS.col() == shipEndS.col())
            {
               for (int i = (shipStartS.row()); i <= shipEndS.row()+1; i++)
               {
                  layout.get(shipStartS.row()+j).set(((shipStartS.col())),CellStatus.SUB);
                  j++;
               }
            }  
          }
               
               
               
               //Destroyer add to board
               else if (arrLine[0].equals("D"))
         {
         
            //Turn the line data from the file into moves
            Move shipStartD = new Move(arrLine[1]);
            Move shipEndD = new Move(arrLine[2]);
 
            
            //If row is the same
            int j = 0;
            if (shipStartD.row() == shipEndD.row())
            {
               for (int i = (shipStartD.col()); i <= shipEndD.col(); i++)
               {
                  layout.get(shipStartD.row()).set(shipStartD.col()+j, CellStatus.DESTROYER);
                  j++;
               }
            } 
            
            //If col is the same
            if(shipStartD.col() == shipEndD.col())
            {
               for (int i = (shipStartD.row()); i <= shipEndD.row()+1; i++)
               {
                  layout.get(shipStartD.row()+j).set(((shipStartD.col())),CellStatus.DESTROYER);
                  j++;
               }
            }  
         }     
      }    
      infile.close();      
   }
      
      
   /**
     * Checks to see if the move that was input is a valid move
     * @return True if the move is valid, false if it is not
     */
   public boolean moveAvailable(Move m)
   {
     
     //Check to see if the targeted cell has a ship that hasn't been hit or a space with nothing in it that hasn't been hit
     if (layout.get(m.row()).get(m.col()) == CellStatus.CRUISER || layout.get(m.row()).get(m.col()) == CellStatus.BATTLESHIP || layout.get(m.row()).get(m.col()) == CellStatus.SUB || layout.get(m.row()).get(m.col()) == CellStatus.DESTROYER || layout.get(m.row()).get(m.col()) == CellStatus.AIRCRAFT_CARRIER)
      {
         return true;
      }
      else{
         return false;
      }
      
   }
   
   /**
     * Checks if the move is valid and applies it to the board
     * @return the original CellStatus at the location of the move
     */
   public CellStatus applyMoveToLayout(Move m)
   {
   //Makes the targeted cell's CellStatus into a variable
   CellStatus target = layout.get(m.row()).get(m.col());
   
   //If there is a move available and the CellStatus is a cruiser, sets the targeted cell to CRUISER_HIT
   if (moveAvailable(m) == true && target == CellStatus.CRUISER )
      {
         
         CellStatus cellStatusOriginal = layout.get(m.row()).get(m.col());
         layout.get(m.row()).set((m.col()), CellStatus.CRUISER_HIT);
         
         return target;
      }
      
      //If there is a move available and the CellStatus is a battleship, sets the targeted cell to BATTLESHIP_HIT
      else if (moveAvailable(m) == true && target == CellStatus.BATTLESHIP )
      {
       
         CellStatus cellStatusOriginal = layout.get(m.row()).get(m.col());
         layout.get(m.row()).set((m.col()), CellStatus.BATTLESHIP_HIT);
         
         return target;
      }
      
      //If there is a move available and the CellStatus is a destroyer, sets the targeted cell to DESTROYER_HIT
      else if (moveAvailable(m) == true && target == CellStatus.DESTROYER )
      {
         CellStatus cellStatusOriginal = layout.get(m.row()).get(m.col());
         layout.get(m.row()).set((m.col()), CellStatus.DESTROYER_HIT);
         
         return target;
      }
      
      //If there is a move available and the CellStatus is a sub, sets the targeted cell to SUB_HIT
      else if (moveAvailable(m) == true && target == CellStatus.SUB )
      {
         CellStatus cellStatusOriginal = layout.get(m.row()).get(m.col());
         layout.get(m.row()).set((m.col()), CellStatus.SUB_HIT);
         
         return target;
      }
      
      //If there is a move available and the CellStatus is a aircraft carrier, sets the targeted cell to AIRCRAFT_CARRIER_HIT
      else if (moveAvailable(m) == true && target == CellStatus.AIRCRAFT_CARRIER )
      {
         
         CellStatus cellStatusOriginal = layout.get(m.row()).get(m.col());
         layout.get(m.row()).set((m.col()), CellStatus.AIRCRAFT_CARRIER_HIT);
         
         return target;
      }
      
      //If there is a move available and the CellStatus is nothing, sets the targeted cell to NOTHING_HIT
      else {
      CellStatus cellStatusOriginal = CellStatus.NOTHING;
      layout.get(m.row()).set((m.col()),CellStatus.NOTHING_HIT);
      return cellStatusOriginal;
      }
   }
   
   /**
     * Checks to see if all the ships have been sunk.
     * @return True if they have all been sunk, false if they have not been
     */
   public boolean gameOver()
   {
      //Check id all the ships are sunk
      if (fleet.battleShip.getSunk()==true && fleet.aircraftCarrier.getSunk()==true & fleet.cruiser.getSunk()==true && fleet.sub.getSunk()==true && fleet.destroyer.getSunk()==true)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
     * Gets the board layout
     * @return layout
     */
   public ArrayList<ArrayList<CellStatus>> getLayout()
   {

      return layout;
   }
   
   /**
     * Gets the fleet
     * @return fleet
     */
   public Fleet getFleet()
   {
      return fleet;
   }
   
}