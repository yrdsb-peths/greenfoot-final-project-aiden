import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meteor extends Actor
{
    /**
     * Act - do whatever the Meteor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    double gravity = 0;
    int terminalVelocity = 10;
    public void act()
    {
        gravity += 0.5;
        if(gravity == terminalVelocity)
        {
            gravity = terminalVelocity;
        }
        if(getY() >= 399)
        {
            gravity = 0; 
        }
        setLocation(getX(), getY() + (int)gravity);
        // Add your action code here.
        if(getY() >= 399)
        {
             if(getWorld().getObjects(Ruby.class) != null)
             {
                 getWorld().removeObjects(getWorld().getObjects(Ruby.class));
             }
             getWorld().removeObject(this);
        }
    }
}
