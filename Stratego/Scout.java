import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    public void act() 
    {
        // Add your action code here.
    }    
}
