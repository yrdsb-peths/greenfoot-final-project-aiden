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
    
    private Ruby chaseTerry;
    
    int gravity = 0;
    int terminalVelocity = 10;
    public void act()
    {
        
        gravity++;
        if(gravity == terminalVelocity)
        {
            gravity = terminalVelocity;
        }
        setLocation(getX(), getY() + gravity);

        // Allows crocodile to move, dependent on the key
        if (Greenfoot.isKeyDown("right"))
        {
            move(4);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 5);
            gravity = 0;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
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
                    gravity += 1;
                }      
            }
        }
    }
    

}
