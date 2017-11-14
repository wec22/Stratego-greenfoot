import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedWinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinScreen extends Actor
{
    /**
     * Act - do whatever the RedWinScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public WinScreen(boolean winner)
    {
        //Blue false Red true
        GreenfootImage winImage;
        if(winner)
        {
            winImage = new GreenfootImage("RedWinScreen.png");
        }
        else
        {
            winImage = new GreenfootImage("BlueWinScreen.png");
        }
        setImage(winImage);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
