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
    private GreenfootImage pieceImage;
    private boolean color;    
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
        if(side)
        {
            switch(rank)
            {
                 case(1):
                        pieceImage = new GreenfootImage("red1.png");
                        setImage(pieceImage);
                        break;
                case(2):
                        pieceImage = new GreenfootImage("red2.png");
                        setImage(pieceImage);
                        break;
               case(3):
                        pieceImage = new GreenfootImage("red3.png");
                        setImage(pieceImage);
                        break;
                case(4):
                        pieceImage = new GreenfootImage("red4.png");
                        setImage(pieceImage);

                case(5):
                        pieceImage = new GreenfootImage("red5.png");
                        setImage(pieceImage);
                        break;
                case(6):
                        pieceImage = new GreenfootImage("red6.png");
                        setImage(pieceImage);
                        break;
                case(7):
                        pieceImage =new GreenfootImage("red7.png");
                        setImage(pieceImage);
                        break;
                
            }
        }
        else
        {
            pieceImage = new GreenfootImage("blueBlank.png");
            setImage(pieceImage);
        }
    }
    public int getColor()
    {
        return color;
    }    

    public int getRank()
    {
        return rank;
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
        Piece defendent = (Piece) getOneIntersectingObject(Piece.class);
        switch (defendent.getRank())
        {
            case 0://Bomb
            {
                if(rank == 8)
                {
                    getWorld().removeObject(defendent);
                    return;
                }              
            }
            case 10://Spy
            {
                if(rank == 1)
                {
                    getWorld().removeObject(defendent);
                    return;
                }
            }
            case 11://Flag
            {
                Greenfoot.stop();
            }
            default://Every Other Case
            {
                if(checkWinner(defendent.getRank()))
                    {
                        getWorld().removeObject(defendent);
                    }
                    else
                    {
                        getWorld().removeObject(this);
                    }
            }
        }       
    }

    public boolean checkWinner(int defender)
    {return rank < defender ? true : false; }
}
