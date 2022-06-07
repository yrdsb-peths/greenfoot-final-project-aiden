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
    public void act()
    {
        speedV++;
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
            setLocation(getX(), getY() - 5);
            speedV = 0;
        }
        //Holds rock after touching it
        grabRock(); 
    }
    // Tests if Rock is touching Terry
    public void grabRock()
    {
        if(isTouching(Rock.class))
        {
            heldRock = (Rock)getOneIntersectingObject(Rock.class);
            if(heldRock != null)
            {
                if(!Greenfoot.isKeyDown("space"))
                {
                    heldRock.followTerry(getX(), getY()); 
                    speedV += 1;
                }  
            }
        }
    }
    public int getSpeedH()
    {
        return speedH;
    }
}
