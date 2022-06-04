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
    private int frame = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        
        // Create Terry the Pterodactyl 
        terry = new Terry();
        addObject(terry, 300, 200);
        
        //Create the rock
        Rock rock = new Rock();
        addObject(rock, 30, 200);
        
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
