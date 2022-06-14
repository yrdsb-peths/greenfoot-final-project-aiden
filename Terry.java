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
    GreenfootSound terryHurt = new GreenfootSound("terryScreach.wav");
    GreenfootSound terryFly = new GreenfootSound("wingFlap.mp3");
    
    GreenfootImage[] idleRight = new GreenfootImage[9];
    GreenfootImage[] idleLeft = new GreenfootImage[9];
    String facing = "right";
    
    private Rock heldRock;
    int speedV = 0;
    int speedH = 0;
    int terminalVelocity = 10;
    boolean touch = false;
    
    int imageIndex = 0;
    public Terry()
    {
        
        for(int i =0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/terry_idle/idle"+ i +".png");
            idleRight[i].scale(150,110);
        }
        setImage(idleRight[0]);
        
        for(int i =0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/terry_idle/idle"+ i +".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(150,110);
        }
        
    }
    
    public void animateTerry()
    {
        terryFly.playLoop();
        terryFly.setVolume(30);
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
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
            facing = "left";
            if(speedH >= 6)
            {
                speedH = 6;
            }
        }
        else if(Greenfoot.isKeyDown("a"))
        {
            speedH--;
            facing = "right";
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
        if(getY() >= 350)
        {
            speedV -= 5;
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
        if(getX() <= 60)
        {
            speedH += 5;
        }
        else if(getX() >= 1140)
        {
            speedH -= 5;
        }
        else if(getY() <= 20)
        {
            speedV += 5;
        }
        //Holds rock after touching it
        grabRock(); 
        if(heldRock != null)
        {
            heldRock.followTerry(getX(), getY()); 
            speedV += 1;
        }
        
        animateTerry();
        
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
            terryHurt.play(); 
            terryHurt.setVolume(50);
        }
    }
    
    public int getSpeedH()
    {
        return speedH;
    }

}
