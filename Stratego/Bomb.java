import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Piece
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     GreenfootImage red;
    GreenfootImage blue;
     public Bomb()
    {
    }
    public Bomb(int rank, boolean color)
    {
        super(rank, color);
        red = new GreenfootImage("redBomb.png");
        blue = new GreenfootImage("blueBomb.png");
        if(color)
            setImage(red);
               
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
