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
    private int frame = 0;
    private double gravity = 0;
    private int terminalVelocity = 10;
    private int speed = Greenfoot.getRandomNumber(3) + 1;
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
        if(getY() >= 800)
        {
            gravity = 0; 
        }
        setLocation(getX(), getY() + (int)gravity);
        followTerry();
        jumpAtTerry();
    }
    
    public void followTerry()
    {
        turnTowards(terry.getX(), getY());
        move(speed);
    }
    
    public void jumpAtTerry()
    {
        frame++;
        if(frame % 120 == 0)
        {
            int randNum = Greenfoot.getRandomNumber(4);
            if(randNum >= 3)
            {
                for(int i = 0; i <= 60; i++)
                {
                    gravity = -20;
                }
            }
        }
    }
}
