import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private boolean turn;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //temporary array that fills up with randomly placed soldiers
    private int orderedPair;
    private boolean SpawnLocationBoard[][] = new boolean[10][4];
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(100, 100, 10); 
        
         /*--------------
         * createing pieces for each side
         * new pieceType(pieceNumber, Color)
         * true is red
         * false is blue
         --------------*/
        orderedPair = getRandomLocationPair(SpawnLocationBoard);
        addObject(new Flag(11, true), (orderedPair/100), (orderedPair%100));//adds flag
        //addObject(new River(), 50, 50);
        setPaintOrder(Piece.class, River.class, MyWorld.class);
        for(int i= 0; i < 6; i++)//add bombs
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Bomb(0, true), (orderedPair/100), (orderedPair%100));            
        }
        
        orderedPair = getRandomLocationPair(SpawnLocationBoard);
        addObject(new Spy(10, true), (orderedPair/100), (orderedPair%100)); //add spy
        
        for(int i = 0; i < 8; i++) //add scouts
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Scout(9, true),(orderedPair/100), (orderedPair%100));
        }
        
        for(int i = 0; i < 5; i++) // add miners
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Miner(8, true), (orderedPair/100), (orderedPair%100));
        }
        
        for(int i = 0; i < 4; i++)// add sergents
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(7, true), (orderedPair/100), (orderedPair%100));
        }
        
        for(int i = 0; i < 4; i++) // add lieutenant
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(6, true), (orderedPair/100), (orderedPair%100));
        }
        
        for(int i = 0; i < 4; i++) // add captain
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(5, true), (orderedPair/100), (orderedPair%100));
        }
        
        for(int i = 0; i < 3; i++) // add major
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(4, true), (orderedPair/100), (orderedPair%100));
        }
        
        for(int i = 0; i < 2; i++) //add colonel
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(3, true), (orderedPair/100), (orderedPair%100));
        }
        
        orderedPair = getRandomLocationPair(SpawnLocationBoard);
        addObject(new Piece(2, true), (orderedPair/100), (orderedPair%100)); //add General
        
        orderedPair = getRandomLocationPair(SpawnLocationBoard);
        addObject(new Piece(1, true), (orderedPair/100), (orderedPair%100)); //add Field Marshel
        
        
        //creating blue---------------------------------------------
        //----------------------------------------------------------
        
         SpawnLocationBoard = new boolean[10][4]; //reset the board to false
        
        orderedPair = getRandomLocationPair(SpawnLocationBoard);
        addObject(new Flag(11, false), (orderedPair/100), (orderedPair%100)+60);//adds flag
        

        for(int i= 0; i < 6; i++)//add bombs
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Bomb(0, false), (orderedPair/100), (orderedPair%100)+60);            
        }
        
        orderedPair = getRandomLocationPair(SpawnLocationBoard);
        addObject(new Spy(10, false), (orderedPair/100), (orderedPair%100)+60); //add spy
        
        for(int i = 0; i < 8; i++) //add scouts
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Scout(9, false),(orderedPair/100), (orderedPair%100)+60);
        }
        
        for(int i = 0; i < 5; i++) // add miners
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Miner(8, false), (orderedPair/100), (orderedPair%100)+60);
        }
        
        for(int i = 0; i < 4; i++)// add sergents
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(7, false), (orderedPair/100), (orderedPair%100)+60);
        }
        
        for(int i = 0; i < 4; i++) // add lieutenant
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(6, false), (orderedPair/100), (orderedPair%100)+60);
        }
        
        for(int i = 0; i < 4; i++) // add captain
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(5, false), (orderedPair/100), (orderedPair%100)+60);
        }
        
        for(int i = 0; i < 3; i++) // add major
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(4, false), (orderedPair/100),(orderedPair%100)+60);
        }
        
        for(int i = 0; i < 2; i++) //add colonel
        {
            orderedPair = getRandomLocationPair(SpawnLocationBoard);
            addObject(new Piece(3, false), (orderedPair/100), (orderedPair%100)+60);
        }
        
        orderedPair = getRandomLocationPair(SpawnLocationBoard);
        addObject(new Piece(2, false), (orderedPair/100), (orderedPair%100)+60); //add General
        
        orderedPair = getRandomLocationPair(SpawnLocationBoard);
        addObject(new Piece(1, false), (orderedPair/100), (orderedPair%100)+60); //add Field Marshel
        
    }
    public int getRandomLocationPair(boolean[][] board)
    {
        int xLocation;
        int yLocation;
        int orderedPair;
        while(true)
        {
            xLocation=Greenfoot.getRandomNumber(10);
            yLocation = Greenfoot.getRandomNumber(4);
            
            if(board[xLocation][yLocation] != true)
            {
                board[xLocation][yLocation] = true;
                xLocation = (xLocation * 10) + 5; //changes from single digit location of array to 2 digit location in board grid
                yLocation = (yLocation * 10) + 5;
                orderedPair = (xLocation * 100)+yLocation; //combines the x and y location into 1 value to be passed back
                return orderedPair;
            }
        }
        
    }   

    public void changeTurns()
    {
        turn = !turn;
    }
    public boolean getTurn()
    {
        return turn;
    }

}
