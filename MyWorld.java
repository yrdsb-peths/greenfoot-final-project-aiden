import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main world where the game takes place
 * 
 * @author Aiden Salas 
 * @version June 2022
 */
public class MyWorld extends World
{
    private Terry terry;
    // Background music looped
    GreenfootSound backgroundMusic = new GreenfootSound("backgroundMusic.mp3");
    
    public int lifePoints = 2;
    public int impactFrame = 600;
    public int impactTimer = impactFrame/60;
    public int waveCounter = 1;
    private int frame = 0;
    
    Label lifeLabel;
    Label meteorTimer;
    Label wave;
    Label gameOver;
    Label waveScore;
    
    public MyWorld()
    {    
        // Create a new world with 1200x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
        
        // Create Terry the Pterodactyl 
        terry = new Terry();
        addObject(terry, 600, 200);
        
        //Create the rock
        Rock rock = new Rock(terry);
        addObject(rock, 600, 385);
        
        //Create life points counter
        lifeLabel = new Label(lifePoints, 40);
        addObject(lifeLabel, 1148, 50);
        
        //Create meteor impact timer
        meteorTimer = new Label(impactTimer, 40);
        addObject(meteorTimer, 600, 45);
        
        //Create wave counter
        wave = new Label(waveCounter, 40);
        addObject(wave, 55, 50);
    }
    
    /**
     * Decrease the Life points Terry has and update the label
     */
    public void decreaseLife()
    {
        lifePoints--;
        lifeLabel.setValue(lifePoints);

        //If Terry runs out of life points, end the game and display wave counter
        if(lifePoints <= 0)
        {
            backgroundMusic.stop();
            GameOver gameOver = new GameOver(this);
            Greenfoot.setWorld(gameOver);
        }
    }
    
    public int getWaveCounter()
    {
        return waveCounter;
    }
    
    /**
     * Main act loop to spawn actors constantly 
     */
    public void act()
    {
        frame++;
        int rubyX = 0;
        backgroundMusic.playLoop();
        backgroundMusic.setVolume(30);
        
        //Update meteor impact timer to seconds every 60 frames
        if(frame % 60 == 0)
        {
            impactTimer--;    
            //If the timer is above 0, convert frames to seconds and set the label to the seconds
            if(impactTimer <= 0)
            {
                impactTimer = impactFrame/60;
            }
            meteorTimer.setValue(impactTimer);
        }
        
        //Have a chance to spawn Ruby every 180 frames
        if(frame % 180 == 0)
        {
            int rubySpawn = Greenfoot.getRandomNumber(2);
            if(rubySpawn == 1)
            {
                rubyX = 1200;
            }
            else
            {
                rubyX = 1;
            }
            Ruby ruby = new Ruby(terry);
            addObject(ruby, rubyX, 380);
        }
        
        //Once the frame counter reaches the impact time, drop the meteor and update the Wave counter
        if(frame % impactFrame == 0)
        {
            Meteor meteor = new Meteor();
            addObject(meteor, 600, 0);
            //Increase the impact time to itself * 2 
            impactFrame += impactFrame;
            waveCounter++;
            wave.setValue(waveCounter);
        }
    }
}
