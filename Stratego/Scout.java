import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Scout here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scout extends Piece
{
    /**
     * Act - do whatever the Scout wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage red;
    GreenfootImage blue;
    public Scout()
    {
    }
    public Scout(int rank, boolean color)
    {
        super(rank, color);
        red = new GreenfootImage("red9.png");
        blue = new GreenfootImage("blue9.png");
        if(color)
            setImage(red);
         
    }
    public ArrayList<Cell> checkMoves()
    {
        ArrayList<Cell> moves = new ArrayList<Cell>();
        Piece other;
        //check south
        for(int i=1;10*i+getY()<1000;i++)
        {
            other = (Piece)getOneObjectAtOffset(0,10*i,Piece.class);
            if(other==null)
                moves.add(new Cell(getX(),10*i+getY()));
            else if(other!=null && other.getColor()!=color)
            {
                moves.add(new Cell(getX(),10*i+getY()));
                break;
            }
            else if(other!=null && other.getColor()==color)
                break;
        }
        
        //check north
        for(int i=1;-10*i+getY()>0;i++)
        {
            other = (Piece)getOneObjectAtOffset(0,-10*i,Piece.class);
            if(other==null)
                moves.add(new Cell(getX(),-10*i+getY()));
            else if(other!=null && other.getColor()!=color)
            {
                moves.add(new Cell(getX(),-10*i+getY()));
                break;
            }
            else if(other!=null && other.getColor()==color)
                break;
        }
        //check west
        for(int i=1;10*i+getX()<1000;i++)
        {
            other = (Piece)getOneObjectAtOffset(10*i,0,Piece.class);
            if(other==null)
                moves.add(new Cell(10*i+getX(),getY()));
            else if(other!=null && other.getColor()!=color)
            {
                moves.add(new Cell(10*i+getX(),getY()));
                break;
            }
            else if(other!=null && other.getColor()==color)
                break;
        }
        //check east
        for(int i=1;-10*i+getX()>0;i++)
        {
            other = (Piece)getOneObjectAtOffset(-10*i,0,Piece.class);
            if(other==null)
                moves.add(new Cell(-10*i+getX(),getY()));
            else if(other!=null && other.getColor()!=color)
            {
                moves.add(new Cell(-10*i+getX(),getY()));
                break;
            }
            else if(other!=null && other.getColor()==color)
                break;
        }
        System.out.print(moves+"\n");
        return moves;
    }
}
