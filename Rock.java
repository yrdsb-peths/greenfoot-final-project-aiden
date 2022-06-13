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
    double velocityX = 0;
    double gravity = 0;
    int terminalVelocity = 10;
    GreenfootSound rockBonk = new GreenfootSound("rockBonk1.mp3");
    
    public Rock(Terry terry)
    {
        this.terry = terry;
        GreenfootImage rockImage = new GreenfootImage("Rock.png");
        rockImage.scale(100, 100);
    }
    
    public void act()
    {
        if(velocityX > 0)
        {
            velocityX -= 0.1;
        }
        else if(velocityX < 0)
        {
            velocityX += 0.1;
        }
        if(velocityX < 0.1 && velocityX > -0.1)
        {
            velocityX = 0;
        }
        
        gravity += 0.5;
        if(gravity == terminalVelocity)
        {
            gravity = terminalVelocity;
        }
        if(getY() >= 385)
        {
            gravity = 0;
        }
        
        setLocation(getX() + (int)velocityX, getY() + (int)gravity);
        
        die();
    }
    public void followTerry(int x, int y)
    {
        setLocation(x, y + 50);
        gravity = 0;
        velocityX = 0;
    }
    
    public void setVelocityX(int rockSpeed)
    {
         velocityX = rockSpeed;
    }
    
    public void setGravity(int rockGravity)
    {
        gravity = rockGravity;
    }
    
    public void die()
    {
        if(isTouching(Ruby.class) && (velocityX != 0 || gravity != 0) && !Greenfoot.isKeyDown("space"))
        {
            removeTouching(Ruby.class);
            rockBonk.play();
        }
    }
    
}
