import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private MyWorld myWorld;
    
    Label gameOver;
    Label waveScore;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(MyWorld myWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.myWorld = myWorld;
    }

    public void act()
    {
        gameOver = new Label("Game Over", 100);
        addObject(gameOver, 300, 150);

        waveScore = new Label("Wave: "+ myWorld.getWaveCounter(), 80);
        addObject(waveScore, 300, 250);
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
