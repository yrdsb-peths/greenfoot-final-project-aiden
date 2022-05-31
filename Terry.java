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
    
    public void act()
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
        
        //returns true if touching rock
    }

}
