import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rock the rock, the main rock
 * 
 * @Aiden 
 * 
 */
public class Rock extends Actor
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        
    }
    public void followTerry(int x, int y)
    {
        setLocation(x, y + 50);
    }
    
}
