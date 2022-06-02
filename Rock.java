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
    
    double gravity = 0;
    int terminalVelocity = 10;
    public void act()
    {
        gravity += 0.5;
        if(gravity == terminalVelocity)
        {
            gravity = terminalVelocity;
        }
        setLocation(getX(), getY() + (int)gravity);
        
        if(getY() >= 800 || isTouching(Terry.class))
        {
            gravity = 0; 
        }

    }
    public void followTerry(int x, int y)
    {
        setLocation(x, y + 50);
    }
}
