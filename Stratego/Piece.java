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
                        pieceImage = new GreenfootImage("red7.png");
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
       // System.out.println("me:"+ this);
        Piece other = (Piece)getOneObjectAtOffset(0,10,Piece.class);
       // System.out.println("other1:"+ other);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(0+getX(),10+getY()));
        }
        other = (Piece)getOneObjectAtOffset(0,-10,Piece.class);
              //  System.out.println("other2:"+ other);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(0+getX(),-10+getY()));
        }
        other = (Piece)getOneObjectAtOffset(10,0,Piece.class);
                //System.out.println("other3:"+ other);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(10+getX(),0+getY()));
        }
        other = (Piece)getOneObjectAtOffset(-10,0,Piece.class);
              //  System.out.println("other89:"+ other);
        if(other==null || other.getColor()!=color)
        {
            moves.add(new Cell(-10+getX(),0+getY()));
        }
       // System.out.println(moves);
        return moves;
    }
    public void move(Cell location)
    {
        //get possible moves
        ArrayList<Cell> moves = checkMoves();
        boolean valid = false;
        //System.out.println("location: "+location);
        for(Cell c : moves)
        {
            //System.out.println("cell checking: "+c);
           // System.out.println(""+c.x/10 +"=="+location.x%10+"&&"+c.y%10+"=="+location.y%10);
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
            //((MyWorld) getWorld()).changeTurns();
            MyWorld  w = getWorldOfType(MyWorld.class);
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
    
    public void switchRedImage(boolean isTurn)
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
 public void switchBlueImage(boolean isTurn)
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
