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
    Label lifeLabel;
    private int frame = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
        
        // Create Terry the Pterodactyl 
        terry = new Terry();
        addObject(terry, 300, 200);
        
        //Create the rock
        Rock rock = new Rock(terry);
        addObject(rock, 30, 200);
        
        lifeLabel = new Label(lifePoints, 40);
        addObject(lifeLabel, 1150, 30);
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
        if(frame % 120 == 0)
        {
            Ruby ruby = new Ruby(terry);
            addObject(ruby, Greenfoot.getRandomNumber(1200), 750);
        }
        
    }
}
