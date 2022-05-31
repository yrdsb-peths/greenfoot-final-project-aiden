import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        carryRock();
    }
    
    public void carryRock()
    {
        if(isTouching(Terry.class))
        {
            int gravity = 0;
            gravity += 2;
            setLocation(getX(), getY() + gravity);
    
            // Allows crocodile to move, dependent on the key
            if (Greenfoot.isKeyDown("right"))
            {
                move(4);
            }
            if (Greenfoot.isKeyDown("up"))
            {
                setLocation(getX(), getY() - 4);
                gravity = 0;
            }
            if(Greenfoot.isKeyDown("left"))
            {
                move(-4);
            }
        }
    }
    

}

