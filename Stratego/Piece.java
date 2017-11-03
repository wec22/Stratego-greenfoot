import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piece extends Actor
{
    /**
     * Act - do whatever the Piece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int rank;
    private boolean color;
    private GreenfootImage pieceImage;
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
    public void act() 
    {
        // Add your action code here.
    }
    public void move()
    {
    }
    public void fight()
    {
    }
}
