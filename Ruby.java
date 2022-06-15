import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ruby the Raptor, the enemy of Terry that follows and jumps at him 
 * 
 * @author Aiden 
 * @version June 2022
 */

public class Ruby extends Actor
{
    GreenfootImage[] idleRight = new GreenfootImage[11];
    GreenfootImage[] idleLeft = new GreenfootImage[11];

    GreenfootImage[] jumpRight = new GreenfootImage[8];
    GreenfootImage[] jumpLeft = new GreenfootImage[8];

    String facing = "right";

    private int frame = 0;
    private int terminalVelocity = 10;
    private int speed = Greenfoot.getRandomNumber(3) + 1;
    private double speedY = 0;
    private Terry terry;

    int imageIndex = 0;
    int jumpIndex = 0;

    boolean jumpTerry = false;
    /**
     * Main constructor for Ruby, run animations
     */
    public Ruby(Terry terry)
    {
        this.terry = terry;
        for(int i =0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/ruby_idle/idle"+ i +".png");
            idleRight[i].mirrorHorizontally();
            idleRight[i].mirrorVertically();
        }
        setImage(idleRight[0]);
        for(int i =0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/ruby_idle/idle"+ i +".png");
            idleLeft[i].mirrorHorizontally();
        }

        for(int i =0; i < jumpLeft.length; i++)
        {
            jumpLeft[i] = new GreenfootImage("images/ruby_jump/idle"+ i +".png");
            jumpLeft[i].mirrorHorizontally();
        }

        for(int i =0; i < jumpRight.length; i++)
        {
            jumpRight[i] = new GreenfootImage("images/ruby_jump/idle"+ i +".png");
            jumpRight[i].mirrorVertically();
            jumpRight[i].mirrorHorizontally();
        }
    }

    /**
     * Animate Ruby's walk
     */
    public void animateRubyWalk()
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
     * Animate Ruby's jump
     */
    public void animateRubyJump()
    {
        //If Ruby's midair, run the animation
        if(getY() < 360)
        {
            if(facing.equals("right"))
            {
                setImage(jumpRight[jumpIndex]);
                jumpIndex = (jumpIndex + 1) % jumpRight.length;
            }
            else
            {
                setImage(jumpLeft[jumpIndex]);
                jumpIndex = (jumpIndex + 1) % jumpLeft.length;
            }    
        }
    }

    /**
     * Main act loop for Ruby
     */
    public void act()
    {
        //Increase Ruby's speed Y until terminal velocity or set to 0 if touching the ground
        speedY += 0.5;
        if(speedY == terminalVelocity)
        {
            speedY = terminalVelocity;
        }
        if(getY() >= 380 && !jumpTerry)
        {
            speedY = 0;
            setLocation(getX(), 380);
        }

        //Check which direction Ruby is facing to run animations
        if(getRotation() == 180)
        {
            facing = "right";
        }

        else if(getRotation() == 0)
        {
            facing = "left";
        }

        setLocation(getX(), getY() + (int)speedY);
        followTerry();
        jumpAtTerry();
        animateRubyWalk();
        animateRubyJump();
    }

    /**
     * Take Terry's coordinates and move towards it
     */
    public void followTerry()
    {
        turnTowards(terry.getX(), getY());
        move(speed);
    }

    /**
     * Have a chance to jump at Terry
     */
    public void jumpAtTerry()
    {
        frame++;
        jumpTerry = false;

        if(frame % 120 == 0)
        {
            int randNum = Greenfoot.getRandomNumber(4);
            if(randNum >= 3)
            {
                jumpTerry = true;
                for(int i = 0; i <= 60; i++)
                {
                    speedY = -20;
                }
            }
        }
    }
}
