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
    GreenfootImage[] idleRight = new GreenfootImage[11];
    GreenfootImage[] idleLeft = new GreenfootImage[11];
    
    GreenfootImage[] jumpRight = new GreenfootImage[8];
    GreenfootImage[] jumpLeft = new GreenfootImage[8];
    
    String facing = "right";
    
    private int frame = 0;
    private double gravity = 0;
    private int terminalVelocity = 10;
    private int speed = Greenfoot.getRandomNumber(3) + 1;
    private Terry terry;
    int imageIndex = 0;
    int jumpIndex = 0;
    boolean jumpTerry = false;
    
    public Ruby(Terry terry)
    {
        this.terry = terry;
        for(int i =0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/ruby_idle/idle"+ i +".png");
            idleRight[i].mirrorHorizontally();
            idleRight[i].mirrorVertically();
        }
        setImage(idleRight[0]);
        for(int i =0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/ruby_idle/idle"+ i +".png");
            idleLeft[i].mirrorHorizontally();
        }
        
        for(int i =0; i < jumpLeft.length; i++)
        {
            jumpLeft[i] = new GreenfootImage("images/ruby_jump/idle"+ i +".png");
            jumpLeft[i].mirrorHorizontally();
        }
        
        for(int i =0; i < jumpRight.length; i++)
        {
            jumpRight[i] = new GreenfootImage("images/ruby_jump/idle"+ i +".png");
            jumpRight[i].mirrorVertically();
            jumpRight[i].mirrorHorizontally();
        }
    }
    
    public void animateRubyIdle()
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
    
    public void animateRubyJump()
    {
        if(getY() < 360)
        {
            System.out.println("sa");
            if(facing.equals("right"))
            {
                setImage(jumpRight[jumpIndex]);
                jumpIndex = (jumpIndex + 1) % jumpRight.length;
            }
            else
            {
                setImage(jumpLeft[jumpIndex]);
                jumpIndex = (jumpIndex + 1) % jumpLeft.length;
            }    
        }
    }
   
    public void act()
    {
        gravity += 0.5;
        if(gravity == terminalVelocity)
        {
            gravity = terminalVelocity;
        }
        if(getY() >= 380 && !jumpTerry)
        {
            gravity = 0;
            setLocation(getX(), 380);
        }
        if(getRotation() == 180)
        {
            facing = "right";
        }
        
        else if(getRotation() == 0)
        {
            facing = "left";
        }
        setLocation(getX(), getY() + (int)gravity);
        followTerry();
        jumpAtTerry();
        animateRubyIdle();
        animateRubyJump();
    }
    
    public void followTerry()
    {
        turnTowards(terry.getX(), getY());
        move(speed);
    }
    
    public void jumpAtTerry()
    {
        frame++;
        jumpTerry = false;
        if(frame % 120 == 0)
        {
            int randNum = Greenfoot.getRandomNumber(4);
            if(randNum >= 3)
            {
                jumpTerry = true;
                for(int i = 0; i <= 60; i++)
                {
                    gravity = -20;
                }
            }
        }
        
    }
}
