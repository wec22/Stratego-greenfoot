import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(100, 100, 10); 
        
         /*--------------
         * createing pieces for each side
         * new pieceType(pieceNumber, Color)
         * true is red
         * false is blue
         */
        addObject(new Flag(11, true), 5, 1);

        for(int i= 15; i<85; i+=10)
        {
            addObject(new Bomb(0, true), i, 1);            
        }
        
        addObject(new Spy(1, true), 8, 1);
        
        for(int i = 9; i<17; i++)
        {
            addObject(new Scout(2, true), i, 1);
        }
        
        for(int i = 17; i<22; i++)
        {
            addObject(new Miner(3, true), i, 1);
        }
    }
}
