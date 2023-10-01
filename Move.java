/* Charlie Corriero CS110

This class has constructors for moves. It has methods that return the row and col of the move. 
As well as returning the move as a string.

*/public class Move
{
   private int row;
   private int col;
   
   
   /**
     * A move constructor that takes in two ints and sets the value of row and col to those ints.
     * @param r The integer for row
     * @param c The integer for col
     */
   public Move(int r, int c)
   {
      row = r;
      col = (c);
   }
   
   /**
     * An alternate move constructor that takes in a String and splits it, converts the letter to an integer then assigns row and col to those values.
     * @param r The integer for row
     * @param c The integer for col
     */
   public Move(String move)
   {
    
    row = move.charAt(0)-'A';
    
   // col = (Integer.parseInt(move.substring(1)));
    col = ((Integer.parseInt(move.substring(1)))-1);
    
    
   }
   
   /**
     * Gets the value for row
     * @return row
     */
   public int row()
   {
      return row;
   }
   
   /**
     * Gets the value for col
     * @return col
     */
   public int col()
   {
      return col;
   }
   
   /** @Override
   * Overrides the toString method, changes row into a letter and returns the move in string format
   * @return the move as a String in Letter,Number format
   */
   public String toString()
   {
         char start =  'A';
         start += (char)row;
         int colReal = col +1;
         
         return String.format("%c%d",start,colReal);
      
      
   }
}