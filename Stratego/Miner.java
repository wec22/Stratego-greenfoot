import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Miner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Miner extends Piece
{
    /**
     * Act - do whatever the Miner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage red;
    GreenfootImage blue;
    public Miner(int rank, boolean color)
    {
        super(rank, color);
        red = new GreenfootImage("red8.png");
        blue = new GreenfootImage("blue8.png");
        if(color)
            setImage(red);
        else
            setImage(blue);            
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
