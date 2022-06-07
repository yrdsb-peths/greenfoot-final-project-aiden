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
    private Terry terry;
    double gravity = 0;
    int terminalVelocity = 10;
    public Rock(Terry terry)
    {
        this.terry = terry;
    }
    
    public void act()
    {
        gravity += 0.5;
        if(gravity == terminalVelocity)
        {
            gravity = terminalVelocity;
        }
        if(getY() >= 800 || isTouching(Terry.class))
        {
            gravity = 0; 
        }
        setLocation(getX(), getY() + (int)gravity);
        die();
    }
    public void followTerry(int x, int y)
    {
        setLocation(x, y + 50);
    }
    
    public void die()
    {
        if(isTouching(Ruby.class))
        {
            removeTouching(Ruby.class);
        }
    }
}
