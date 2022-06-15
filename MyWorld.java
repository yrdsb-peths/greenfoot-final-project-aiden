import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Makes the main world where Terry, Ruby and all actors will be playing in, 
 * Constructs all the actors in their appropriate spawning places
 * 
 * @Aiden Salas 
 * @version (13)
 */
public class MyWorld extends World
{
    // Background music looped
    GreenfootSound backgroundMusic = new GreenfootSound("backgroundMusic.mp3");
    
    //Bring over Terry
    private Terry terry;
    
    //variables
    public int lifePoints = 2;
    public int impactFrame = 600;
    public int impactTimer = impactFrame/60;
    public int waveCounter = 1;
    private int frame = 0;
    
    //Make labels
    Label lifeLabel;
    Label meteorTimer;
    Label wave;
    Label gameOver;
    Label waveScore;
    
    //World Constructor
    public MyWorld()
    {    
        // Create a new world with 1200x400 cells with a cell size of 1x1 pixels.
        super(1200, 400, 1); 
        
        //Play background music looped and set volume
        backgroundMusic.playLoop() ;
        backgroundMusic.setVolume(30);
        
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
    
    //When called decrease the life point counter of terry
    public void decreaseLife()
    {
        //decrease life point counter and set the label value
        lifePoints--;
        lifeLabel.setValue(lifePoints);
        
        //Terry runs out of life points end game and display wave counter
        if(lifePoints <= 0)
        {
            //stop the game
            Greenfoot.stop(); 
            
            //Create game over label
            gameOver = new Label("Game Over", 100);
            addObject(gameOver, 600, 150);
            
            //Create wave label for wave reached
            waveScore = new Label("Wave: "+ waveCounter, 80);
            addObject(waveScore, 600, 250);
        }
    }
    
    //act loop
    public void act()
    {
        //increase frame counter
        frame++;
        
        //Create ruby x-coordinate variable
        int rubyX = 0;
        
        //Update meteor impact timer every 60 frames
        if(frame % 60 == 0)
        {
            //Minus the impact timer every 60 frames
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
        
        
        if(frame % impactFrame == 0)
        {
            Meteor meteor = new Meteor();
            addObject(meteor, 600, 0);
            impactFrame += impactFrame;
            waveCounter++;
            wave.setValue(waveCounter);
        }
    }
}
