import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The metoer actor that deletes all Rubies on impact, and makes a new wave
 * 
 * @author Aiden Salas
 * @version June 2022
 */
public class Meteor extends Actor
{
    GreenfootSound meteorExplosion = new GreenfootSound("meteorExplosion.mp3");
    
    GreenfootImage[] meteorIdle = new GreenfootImage[3];
    int imageIndex = 0;
    double speedY = 0;
    int terminalVelocity = 10;
    /**
     * Main Constructor class for meteor, runs animation
     */
    public Meteor()
    {
        //Animation Loop
        for(int i =0; i < meteorIdle.length; i++)
        {
            meteorIdle[i] = new GreenfootImage("images/meteor_idle/idle"+ i +".png");
        }
        setImage(meteorIdle[0]);
    }
    
    /**
     * Animate the meteor
     */
    public void animateMeteor()
    {
        setImage(meteorIdle[imageIndex]);
        imageIndex = (imageIndex + 1) % meteorIdle.length;
    }
    
    /**
     * Main act loop for the Meteor, sets speedY rules
     */
    public void act()
    {
        //Increases Y of meteor until it reaches terminal velocity
        speedY += 0.5;
        if(speedY == terminalVelocity)
        {
            speedY = terminalVelocity;
        }
        setLocation(getX(), getY() + (int)speedY);
        
        //Once the Meteor hits the ground, delete all Rubies and play explosion sound
        if(getY() >= 399)
        {
             if(getWorld().getObjects(Ruby.class) != null)
             {
                 getWorld().removeObjects(getWorld().getObjects(Ruby.class));
             }
             getWorld().removeObject(this);
             meteorExplosion.play();
             meteorExplosion.setVolume(30);
        }
        
        animateMeteor();
    }
}
