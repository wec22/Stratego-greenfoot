import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flag extends Piece
{
    /**
     * Act - do whatever the Flag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage red;
    private GreenfootImage blue;
     public Flag()
    {
    }
    public Flag(int rank, boolean color)
    {
        super(rank, color);
        red = new GreenfootImage("RedFlag.png");
        blue = new GreenfootImage("BlueFlag.png");
        if(color)
            setImage(red);
       
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
