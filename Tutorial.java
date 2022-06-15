import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tutorial page to teach new players
 * 
 * @author Aiden Salas
 * @version June 2022
 */
public class Tutorial extends World
{
    /**
     * Constructor for objects of class Tutorial.
     * 
     */
    public Tutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
    }
    
    /**
     * Main act loop for Tutorial for key detection
     */
    public void act()
    {
        //If press space, continue to game
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
    }
}
