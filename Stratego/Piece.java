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
    protected boolean color;    
    private boolean moving;
    
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
            setRedImage(true);
        else
            setBlueImage(true);
            
       
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
                if(!isLake(mouse.getX(),mouse.getY()))
                    move(new Cell(mouse.getX(), mouse.getY()));
            }
        }
    }
    public static boolean isLake(int x, int y)
    {
        //lakes are at (2,4)(2,5)(3,4)(3,5) (6,4)(6,5)(7,4)(7,5)
        x /= 10;
        y /=10;
        
        switch(x)
        {
            case 2:
            case 3:
            case 6:
            case 7:
                if(y==4 || y==5)
                    return true;
            default:
                return false;
        }
    }
    public ArrayList<Cell> checkMoves()
    {
        ArrayList<Cell> moves = new ArrayList<Cell>();
      
        Piece other = (Piece)getOneObjectAtOffset(0,10,Piece.class);
      
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(0+getX(),10+getY()));
        }
        other = (Piece)getOneObjectAtOffset(0,-10,Piece.class);
              
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(0+getX(),-10+getY()));
        }
        other = (Piece)getOneObjectAtOffset(10,0,Piece.class);
                
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(10+getX(),0+getY()));
        }
        other = (Piece)getOneObjectAtOffset(-10,0,Piece.class);
        
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(-10+getX(),0+getY()));
        }
        return moves;
    }
    public void move(Cell location)
    {
        //get possible moves
        ArrayList<Cell> moves = checkMoves();
        boolean valid = false;
        MyWorld  w = getWorldOfType(MyWorld.class);
        for(Cell c : moves)
        {
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
            w.changeTurns();
            
            moving = false;
        }
        else
            moving = false;
        
    }
    public void fight(Piece other)
    {
        Piece defendent = (Piece) getOneIntersectingObject(Piece.class);
        
        if(rank == defendent.getRank())
                {
                    getWorld().removeObject(defendent);
                    getWorld().removeObject(this);
                    return;
                }
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
    
    public void setRedImage(boolean isTurn)
    {
        GreenfootImage newImage;
        if(isTurn)
        {
            switch(rank)
            {
                case(1):
                        newImage = new GreenfootImage("red1.png");
                        setImage(newImage);
                        break;
                case(2):
                        newImage = new GreenfootImage("red2.png");
                        setImage(newImage);
                        break;
                case(3):
                        newImage = new GreenfootImage("red3.png");
                        setImage(newImage);
                        break;
                case(4):
                        newImage = new GreenfootImage("red4.png");
                        setImage(newImage);
                        break;

                case(5):
                        newImage = new GreenfootImage("red5.png");
                        setImage(newImage);
                        break;
                case(6):
                        newImage = new GreenfootImage("red6.png");
                        setImage(newImage);
                        break;
                case(7):
                        newImage =new GreenfootImage("red7.png");
                        setImage(newImage);
                        break;
                case(8):
                        newImage =new GreenfootImage("red8.png");
                        setImage(newImage);
                        break;
                case(9):
                        newImage =new GreenfootImage("red9.png");
                        setImage(newImage);
                        break;
                case(10):
                        newImage =new GreenfootImage("redSpy.png");
                        setImage(newImage);
                        break;
               case(11):
                        newImage =new GreenfootImage("RedFlag.png");
                        setImage(newImage);
                        break;
              case(0):
                        newImage =new GreenfootImage("redBomb.png");
                        setImage(newImage);
                        break;
            }
        }
        else
        {
            newImage = new GreenfootImage("redBlank.png");
            setImage(newImage);
        }
    }
    public void setBlueImage(boolean isTurn)
    {
        
        GreenfootImage newImage;
        if(!isTurn)
        {
            switch(rank)
            {
                case(1):
                        newImage = new GreenfootImage("blue1.png");
                        setImage(newImage);
                        break;
                case(2):
                        newImage = new GreenfootImage("blue2.png");
                        setImage(newImage);
                        break;
                case(3):
                        newImage = new GreenfootImage("blue3.png");
                        setImage(newImage);
                        break;
                case(4):
                        newImage = new GreenfootImage("blue4.png");
                        setImage(newImage);
                        break;

                case(5):
                        newImage = new GreenfootImage("blue5.png");
                        setImage(newImage);
                        break;
                case(6):
                        newImage = new GreenfootImage("blue6.png");
                        setImage(newImage);
                        break;
                case(7):
                        newImage =new GreenfootImage("blue7.png");
                        setImage(newImage);
                        break;
                case(8):
                        newImage =new GreenfootImage("blue8.png");
                        setImage(newImage);
                        break;
                case(9):
                        newImage =new GreenfootImage("blue9.png");
                        setImage(newImage);
                        break;
                case(10):
                        newImage =new GreenfootImage("blueSpy.png");
                        setImage(newImage);
                        break;
               case(11):
                        newImage =new GreenfootImage("BlueFlag.png");

                        setImage(pieceImage);

                        setImage(newImage);

                        break;
              case(0):
                        newImage =new GreenfootImage("blueBomb.png");
                        setImage(newImage);
                        break;
              
                        
            }
        }
        else
        {
            newImage = new GreenfootImage("blueBlank.png");
            setImage(newImage);
        }
    }
}
