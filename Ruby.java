import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ruby the Raptor, the main Raptor
 * 
 * @Aiden 
 * @version (a version number or a date)
 */
public class Ruby extends Actor
{
    /**
     * Act - do whatever the Ruby wants to do. This method is called whenever
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
        if(getY() >= 800)
        {
            gravity = 0; 
        }
        
    }
    
    public void followTerry(int x)
    {
        turnTowards(x, getY());
        move(10);
    }
    
    public void jumpTerry()
    {
        
    }
    
    public void die()
    {
        
    }
}
