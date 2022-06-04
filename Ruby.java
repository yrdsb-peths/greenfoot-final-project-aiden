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
    private double gravity = 0;
    private int terminalVelocity = 10;
    private int speed = Greenfoot.getRandomNumber(4) + 1;
    private Terry terry;
    
    public Ruby(Terry terry)
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
        setLocation(getX(), getY() + (int)gravity);
        if(getY() >= 800)
        {
            gravity = 0; 
        }
        followTerry();
    }
    
    public void followTerry()
    {
        turnTowards(terry.getX(), getY());
        move(speed);
    }
    
    public void jumpTerry()
    {
        
    }
    
    
}
