import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spy extends Piece
{
    /**
     * Act - do whatever the Spy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage red;
    GreenfootImage blue;
     public Spy()
    {
    }
    public Spy(int rank, boolean color)
    {
        super(rank, color);
        red = new GreenfootImage("redSpy.png");
        blue = new GreenfootImage("blueSpy.png");
        if(color)
            setImage(red);
              
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
