import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Terry the Pterosaur, the main character
 * 
 * @author Aiden 
 * @version May 27th
 */
public class Terry extends Actor
{
    /**
     * Act - do whatever the Terry wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Rock heldRock;
    int speedV = 0;
    int speedH = 0;
    int terminalVelocity = 10;
    boolean touch = false;
    public void act()
    {
        speedV += 1;
        if(speedV == terminalVelocity)
        {
            speedV = terminalVelocity;
        }
        setLocation(getX() + speedH, getY() + speedV);
        
        // Allows crocodile to move, dependent on the key
        if (Greenfoot.isKeyDown("d"))
        {
            speedH++;
            if(speedH >= 6)
            {
                speedH = 6;
            }
        }
        else if(Greenfoot.isKeyDown("a"))
        {
            speedH--;
            if(speedH <= -6)
            {
                speedH = -6;
            }
        }
        if (Greenfoot.isKeyDown("w"))
        {
            speedV -= 4;
            if(speedV <= -10)
            {
                speedV = -10;
            }
        }
        if(getY() >= 399)
        {
            speedV -= 1;
            if(speedH > 0)
            {
                speedH -= 0.1;
            }
            else if(speedH < 0)
            {
                speedH += 0.1;
            }
            else
            {
                speedH = 0;
            }
        }
        //Holds rock after touching it
        grabRock(); 
        if(heldRock != null)
        {
            heldRock.followTerry(getX(), getY()); 
            speedV += 1;
        }
        
        loseLife();
    }
    // Tests if Rock is touching Terry
    public void grabRock()
    {
        if(isTouching(Rock.class) && Greenfoot.isKeyDown("space"))
        {
            heldRock = (Rock)getOneIntersectingObject(Rock.class);
        }
        else
        {
            if(heldRock != null)
            {
                heldRock.setVelocityX(speedH);
                heldRock.setGravity(speedV);
            }
            heldRock = null;
        }
    }
    
    public void loseLife()
    {
        if(isTouching(Ruby.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.decreaseLife();    
            removeTouching(Ruby.class);
                
        }
    }
    
    public int getSpeedH()
    {
        return speedH;
    }

}
