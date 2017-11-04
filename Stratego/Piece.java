import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piece extends Actor
{
    private int rank;
    private boolean color;//0 for red, 1 for blue
    /**
     * Act - do whatever the Piece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Piece()
    {
    }
    public Piece(int number, boolean side)
    {
        rank = number;
        color = side;
    }
    public boolean getColor()
    {
        return color;
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            //move();
        }
    }
    public ArrayList<Cell> checkMoves()
    {
        ArrayList<Cell> moves = new ArrayList<Cell>();

        Piece other = getObjectsAtOffset(0,1,Piece.class).get(0);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(0,1));
        }
        other = getObjectsAtOffset(0,-1,Piece.class).get(0);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(0,-1));
        }
        other = getObjectsAtOffset(1,0,Piece.class).get(0);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(1,0));
        }
        other = getObjectsAtOffset(-1,0,Piece.class).get(0);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(-1,0));
        }
        return moves;
    }
    public void move(Cell location)
    {
        //get possible moves
        ArrayList<Cell> moves = checkMoves();
        boolean valid = false;
        for(Cell c : moves)
        {
            if(c.x == location.x && c.y == location.y)
            {
                valid = true;
                break;
            }
        }
        if(valid)
        {
            setLocation(location.x, location.y);
            Piece enemy = (Piece) getOneObjectAtOffset(0,0,Piece.class);
            if(enemy!=null)
            {
                fight(enemy);
            }
            ((MyWorld) getWorld()).changeTurns();
            
        }
        
        
    }
    public void fight(Piece other)
    {
    }
   
}
