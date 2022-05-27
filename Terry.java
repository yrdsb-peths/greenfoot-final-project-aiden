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
    
    public void gravity()
    {
        //
    }
    
    public void act()
    {
        setLocation(getX(), getY() + 1);
        // Allows crocodile to move, dependent on the key
        if (Greenfoot.isKeyDown("right"))
        {
            move(4);
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
        }
        
    }
    
    
}
