/* Charlie Corriero CS110

This class makes a fleet and initializes all the ships. Has methods
to update the fleet and check if all the ships are sunk.

*/
public class Fleet 
{
   //Instance variables
   Ship battleShip;
   Ship aircraftCarrier;
   Ship cruiser;
   Ship sub;
   Ship destroyer;
   
   
   /**
   * The Fleet constructor initializes the Ship instane variables (battleship, aircraftCarrier, cruiser, sub, and destroyer) to new ships objetcs.
   */
   public Fleet()
   {
      battleShip = new Battleship();
      aircraftCarrier = new AircraftCarrier();
      cruiser = new Cruiser();
      sub = new Submarine();
      destroyer = new Destroyer();
   }
   
   /**
   * The updateFleet method  takes in a ShipType, adds one to the hit count of the ship, and tells you that your ship was hit.
   * @param t a ShipType given to the method
   * @return true of false if the specified ShipType was sunk or not sunk respectively
   */
    public boolean updateFleet(ShipType t)
    {
      
      String ship = " ";
      
      //if the ship is an aircraft carrier add to the hits and return if its sunk
      if (t == ShipType.ST_AIRCRAFT_CARRIER){
      ship = "aircraft carrier";
      System.out.println("Your " + ship + " has been hit!");
      aircraftCarrier.hit();
      return aircraftCarrier.getSunk();
      }
      
      //if the ship is a battleship add to the hits and return if its sunk
      else if (t == ShipType.ST_BATTLESHIP){
      ship = "battleship";
      System.out.println("Your " + ship + " has been hit!");
      battleShip.hit();
      return battleShip.getSunk();
      }
      
      //if the ship is a cruiser add to the hits and return if its sunk
      else if (t == ShipType.ST_CRUISER){
      ship = "cruiser";
      System.out.println("Your " + ship + " has been hit!");
      cruiser.hit();
      //System.out.println("HERE: " + cruiser.getSunk());
      return cruiser.getSunk();
      }
      
      //if the ship is a destroyer add to the hits and return if its sunk
      else if (t == ShipType.ST_DESTROYER){
      ship = "destroyer";
      System.out.println("Your " + ship + " has been hit!");
      destroyer.hit();
      return destroyer.getSunk();
      }
      
      //if the ship is a sub add to the hits and return if its sunk
      else if (t == ShipType.ST_SUB){
      ship = "submarine";
      System.out.println("Your " + ship + " has been hit!");
      sub.hit();
      return sub.getSunk();
      }
      else
      {
         return false;
      }
    }
    
    /**
    * The gameOver method checks to see if all of the ships have been sunk
    * @return true if all the ships are sunk, false otherwise
    */
    public boolean gameOver()
    {
      if (battleShip.getSunk()==true && aircraftCarrier.getSunk()==true & cruiser.getSunk()==true && sub.getSunk()==true && destroyer.getSunk()==true)
      {
         return true;
      }
      else
      {
         return false;
      }
    }
}