import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Terry the Pterosaur, the main character which the player controls
 * 
 * @author Aiden 
 * @version June 2022
 */
public class Terry extends Actor
{
    GreenfootSound terryHurt = new GreenfootSound("terryScreach.wav");
    
    GreenfootImage[] idleRight = new GreenfootImage[9];
    GreenfootImage[] idleLeft = new GreenfootImage[9];
    String facing = "right";
    
    private Rock heldRock;
    int speedY = 0;
    int speedX = 0;
    int terminalVelocity = 10;
    int imageIndex = 0;
    boolean touch = false;
    /**
     * Main constructor for Terry, run animations
     */
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
    
    /**
     * Animate Terry flying and play flapping sound
     */
    public void animateTerry()
    {
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
    
    /**
     * Main act loop for Terry, key controls, speed of X and Y axis 
     */
    public void act()
    {
        //Increase speedV until terminal velocity
        speedY += 1;
        if(speedY == terminalVelocity)
        {
            speedY = terminalVelocity;
        }
        setLocation(getX() + speedX, getY() + speedY);
        
        // Allows Terry to move, dependent on key
        if (Greenfoot.isKeyDown("d"))
        {
            speedX++;
            facing = "left";
            if(speedX >= 6)
            {
                speedX = 6;
            }
        }
        
        else if(Greenfoot.isKeyDown("a"))
        {
            speedX--;
            facing = "right";
            if(speedX <= -6)
            {
                speedX = -6;
            }
        }
        
        if (Greenfoot.isKeyDown("w"))
        {
            speedY -= 4;
            if(speedY <= -10)
            {
                speedY = -10;
            }
            
        }
        
        //If Terry is touching the ground, set the speedV to 0
        if(getY() >= 350)
        {
            speedY -= 5;
            if(speedX > 0)
            {
                speedX -= 0.1;
            }
            else if(speedX < 0)
            {
                speedX += 0.1;
            }
            else
            {
                speedX = 0;
            }
        }
        
        //If Terry is touching the sides of the world, make him bounce off
        if(getX() <= 60)
        {
            speedX += 5;
        }
        else if(getX() >= 1140)
        {
            speedX -= 5;
        }
        else if(getY() <= 20)
        {
            speedY += 5;
        }
        
        //If Terry is holding the rock, have it follow him
        grabRock(); 
        if(heldRock != null)
        {
            heldRock.followTerry(getX(), getY()); 
            speedY += 1;
        }
        
        animateTerry();
        loseLife();
    }
    
    /**
     * If Terry is touching the Rock and holding down space, have it follow him
     */
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
                heldRock.setSpeedX(speedX);
                heldRock.setSpeedY(speedY);
            }
            heldRock = null;
        }
    }
    
    /**
     * If a Ruby touches Terry, have him lose a life point
     */
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
    
    /**
     * Return his X-axis speed
     */
    public int getSpeedX()
    {
        return speedX;
    }

}
