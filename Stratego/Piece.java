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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Piece()
    {
    }
    public Piece(int number, boolean side)
    {
        rank = number;
        color = side;
    }
    
    public int getRank()
    {
        return rank;
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
        Piece defendent = (Piece) getOneIntersectingObject(Piece.class);
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
}