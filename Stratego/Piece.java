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
    private boolean moving;
    private boolean active;
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
        moving = false;
        if(side)
        {
            active = true;
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
            active = false;
            pieceImage = new GreenfootImage("blueBlank.png");
            setImage(pieceImage);
        }
    }
    public boolean getColor()
    {
        return color;
    }    

    public int getRank()
    {
        return rank;
    }
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse==null) return;
        if(((MyWorld)getWorld()).getTurn()==color)
        {
            if(Greenfoot.mouseClicked(this))
            {
                moving = true;
            }
            else if(moving == true && Greenfoot.mouseClicked(null))
            {
                move(new Cell(mouse.getX(), mouse.getY()));
            }
        }
    }
    public ArrayList<Cell> checkMoves()
    {
        ArrayList<Cell> moves = new ArrayList<Cell>();
        System.out.println("me:"+ this);
        Piece other = (Piece)getOneObjectAtOffset(0,10,Piece.class);
        System.out.println("other1:"+ other);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(0+getX(),10+getY()));
        }
        other = (Piece)getOneObjectAtOffset(0,-10,Piece.class);
                System.out.println("other2:"+ other);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(0+getX(),-10+getY()));
        }
        other = (Piece)getOneObjectAtOffset(10,0,Piece.class);
                System.out.println("other3:"+ other);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(10+getX(),0+getY()));
        }
        other = (Piece)getOneObjectAtOffset(-10,0,Piece.class);
                System.out.println("other89:"+ other);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(-10+getX(),0+getY()));
        }
        System.out.println(moves);
        return moves;
    }
    public void move(Cell location)
    {
        //get possible moves
        ArrayList<Cell> moves = checkMoves();
        boolean valid = false;
        System.out.println("location: "+location);
        for(Cell c : moves)
        {
            System.out.println("cell checking: "+c);
            System.out.println(""+c.x/10 +"=="+location.x%10+"&&"+c.y%10+"=="+location.y%10);
            if((c.x/10 == location.x/10) && (c.y/10 == location.y/10))
            {
                valid = true;
                break;
            }
        }
        if(valid)
        {
            setLocation(10*(location.x/10)+5, 10*(location.y/10)+5);
            Piece enemy = (Piece) getOneObjectAtOffset(0,0,Piece.class);
            if(enemy!=null)
            {
                fight(enemy);
            }
            ((MyWorld) getWorld()).changeTurns();
            moving = false;
        }
        else
            moving = false;
        
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
