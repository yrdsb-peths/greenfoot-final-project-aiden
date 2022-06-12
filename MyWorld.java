import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Terry terry;
    public int lifePoints = 2;
    
    public int impactFrame = 600;
    public int impactTimer = impactFrame/60;
    
    public int waveCounter = 1;
    
    Label lifeLabel;
    Label meteorTimer;
    Label wave;
    private int frame = 0;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
        
        // Create Terry the Pterodactyl 
        terry = new Terry();
        addObject(terry, 600, 200);
        
        //Create the rock
        Rock rock = new Rock(terry);
        addObject(rock, 600, 385);
        
        lifeLabel = new Label(lifePoints, 40);
        addObject(lifeLabel, 1150, 30);
        
        meteorTimer = new Label(impactTimer, 40);
        addObject(meteorTimer, 1100, 30);
        
        wave = new Label(waveCounter, 40);
        addObject(wave, 1050, 30);
    }
    
    public void decreaseLife()
    {
        lifePoints--;
        lifeLabel.setValue(lifePoints);
    }
    
    public void act()
    {
        frame++;
        //Create Rubys
        if(frame % 60 == 0)
        {
            impactTimer--;
            if(impactTimer <= 0)
            {
                impactTimer = impactFrame/60;
            }
            meteorTimer.setValue(impactTimer);
        }
        
        if(frame % 120 == 0)
        {
            Ruby ruby = new Ruby(terry);
            addObject(ruby, Greenfoot.getRandomNumber(1200), 350);
        }
        
        if(frame % impactFrame == 0)
        {
            Meteor meteor = new Meteor();
            addObject(meteor, Greenfoot.getRandomNumber(1200), 0);
            impactFrame += impactFrame;
            waveCounter++;
            wave.setValue(waveCounter);
        }
    }
}
