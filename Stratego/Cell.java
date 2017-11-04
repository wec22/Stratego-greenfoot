/**
 * Write a description of class Cell here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cell  
{
    // instance variables - replace the example below with your own
    public int x;
    public int y;

    /**
     * Constructor for objects of class Cell
     */
    public Cell(int nx, int ny)
    {
        x = nx;
        y = ny;
    }
    public String toString()
    {
        return "x:"+x+";y:"+y;
    }
}
