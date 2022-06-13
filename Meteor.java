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
    GreenfootSound meteorExplosion = new GreenfootSound("meteorExplosion.mp3");
    
    GreenfootImage[] meteorIdle = new GreenfootImage[3];
    int imageIndex = 0;
    double gravity = 0;
    int terminalVelocity = 10;
    
    public Meteor()
    {
        for(int i =0; i < meteorIdle.length; i++)
        {
            meteorIdle[i] = new GreenfootImage("images/meteor_idle/idle"+ i +".png");
        }
        setImage(meteorIdle[0]);
    }
    
    public void animateMeteor()
    {
        setImage(meteorIdle[imageIndex]);
        imageIndex = (imageIndex + 1) % meteorIdle.length;
    }
    
    public void act()
    {
        gravity += 0.5;
        if(gravity == terminalVelocity)
        {
            gravity = terminalVelocity;
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
             meteorExplosion.play();
        }
        animateMeteor();
    }
}
