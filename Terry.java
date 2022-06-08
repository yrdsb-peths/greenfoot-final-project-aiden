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
    int lifePoints = 2;
    
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
        //Holds rock after touching it
        grabRock(); 
        if(heldRock != null)
        {
            heldRock.followTerry(getX(), getY()); 
            speedV += 1;
        }
        if(loseLife())
        {
            lifePoints -= 1;
            if(lifePoints <= 0)
            {
                System.out.println("dead");
            }
        }
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
    public boolean loseLife()
    {
        if(isTouching(Ruby.class))
        {
            removeTouching(Ruby.class);
            return true;
        }
        return false;
    }
    public int getSpeedH()
    {
        return speedH;
    }

}
