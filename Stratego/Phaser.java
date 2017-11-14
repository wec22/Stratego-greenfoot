import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phaser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phaser extends Actor
{
    private boolean on;
    /**
     * Act - do whatever the Phaser wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void Phaser()
    {
        on = false;
        getImage().setTransparency(0);
    }
    public void act() 
    {
        // Add your action code here.\
        if(Greenfoot.isKeyDown("enter"))
        {
            getWorld().setPaintOrder(Piece.class, River.class, MyWorld.class, Phaser.class);
            on = false;
        }
       if(on)
        {
            getImage().setTransparency(255);
        }
        else
        {
            getImage().setTransparency(0);
        }

    }  
    
    public void swap()
    {
        if(on)
        {
            on = false;
        }
        else
        {
            on = true;
        }

    }
}
