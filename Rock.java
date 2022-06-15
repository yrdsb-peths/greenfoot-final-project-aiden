import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rock, the main weapon of Terry used against Ruby
 * 
 * @author Aiden Salas
 * @version June 2022
 */
public class Rock extends Actor
{
    private Terry terry;
    double speedX = 0;
    double speedY = 0;
    int terminalVelocity = 10;
    GreenfootSound rockBonk = new GreenfootSound("rockBonk1.mp3");
    
    /**
     * Main constructor for Rock, set image and scale
     */
    public Rock(Terry terry)
    {
        this.terry = terry;
        GreenfootImage rockImage = new GreenfootImage("Rock.png");
        rockImage.scale(100, 100);
    }
    
    /**
     * Main act loop for rock, increase velocity of X and Y axis
     */
    public void act()
    {
        // Form of air resistance on the rock
        if(speedX > 0)
        {
            speedX -= 0.1;
        }
        else if(speedX < 0)
        {
            speedX += 0.1;
        }
        if(speedX < 0.1 && speedX > -0.1)
        {
            speedX = 0;
        }
        
        //increase rock y speed until terminal velocity or stop when it hits the ground
        speedY += 0.5;
        if(speedY == terminalVelocity)
        {
            speedY = terminalVelocity;
        }
        if(getY() >= 385)
        {
            speedY = 0;
        }
        setLocation(getX() + (int)speedX, getY() + (int)speedY);
        
        die();
    }
    
    /**
     * Follow Terry as if being picked up by him
     */
    public void followTerry(int x, int y)
    {
        setLocation(x, y + 50);
        speedY = 0;
        speedX = 0;
    }
    
    /**
     * Set the rocks X-axis speed to Terry's X-axis speed
     */
    public void setSpeedX(int terrySpeedX)
    {
         speedX = terrySpeedX;
    }
    
    /**
     * Set the Y-axis speed of rock to Terry's Y-axis speed
     */
    public void setSpeedY(int terrySpeedY)
    {
        speedY = terrySpeedY;
    }
    
    /**
     * delete the Ruby that touches the rock and play bonk sound
     */
    public void die()
    {
        //If the Rock is touching a Ruby with speed in either X or Y, delete the Ruby
        if(isTouching(Ruby.class) && (speedX != 0 || speedY != 0) && !Greenfoot.isKeyDown("space"))
        {
            removeTouching(Ruby.class);
            rockBonk.play();
        }
    }
    
}
