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
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    String facing = "right";
    
    
    private int frame = 0;
    private double gravity = 0;
    private int terminalVelocity = 10;
    private int speed = Greenfoot.getRandomNumber(3) + 1;
    private Terry terry;
    int imageIndex = 0;
    
    public Ruby(Terry terry)
    {
        this.terry = terry;
        for(int i =0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/ruby_idle/idle"+ i +".png");
            idleRight[i].mirrorHorizontally();
            idleRight[i].scale(60,50);
        }
        setImage(idleRight[0]);
        
        for(int i =0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/ruby_idle/idle"+ i +".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].mirrorVertically();
            idleRight[i].scale(100,50);
        }
        
    }
    
    public void animateRuby()
    {
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act()
    {
        gravity += 0.5;
        if(gravity == terminalVelocity)
        {
            gravity = terminalVelocity;
        }
        if(getY() >= 360)
        {
            gravity = 0; 
        }
        if(getRotation() == 180)
        {
            facing = "left";
        }
        
        else if(getRotation() == 0)
        {
            facing = "right";
        }
        setLocation(getX(), getY() + (int)gravity);
        followTerry();
        jumpAtTerry();
        animateRuby();
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
