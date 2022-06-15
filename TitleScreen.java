import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display screen for players first starting up the game
 * 
 * @author Aiden Salas 
 * @version June 2022
 */
public class TitleScreen extends World
{
    /**
     * Constructor for Title Screen
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);  
    }
    
    /**
     * Main act loop for key detection of Title Screen
     */
    public void act()
    {
        //If the user presses space, continue to game
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
        //If the user presses h, continue to tutorial page
        else if(Greenfoot.isKeyDown("h"))
        {
            Tutorial tutorial = new Tutorial();
            Greenfoot.setWorld(tutorial);
        }
    }
}
