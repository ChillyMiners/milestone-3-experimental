package UserCode.Pets;
import java.util.Random;
import Framework.Interfaces.*;
import Exceptions.*;
import UserCode.Pets.SwimBehaviors.*;
import UserCode.Bubbles.*;

/**
 * Represents the SeaHorse
 * 
 * @author Dean Sisman
 * @version 1
 */
public class SeaHorse extends Pet implements IEmitsBubbles
{
    // DECLARE a reference to the IBubbleManager interface, call it _bubbleManager:
    IBubbleManager _bubbleManager;
    
    // DECLARE an integer to control the rate at which bubbles are emitted, call it _bubbleSpawn:
    private int _bubbleSpawn;
    /**
     * Constructor for objects of class SeaHorse
     */
    public SeaHorse()
    {
        
    }
    
    
    
    // IMPLEMENTATION OF IPLACEABLE
    
    /**
     * Places the pet in the world
     *
     * @param  world a reference to the IWorld
     * @param random a reference to the Random class
     */
    public void place(IWorld world, Random random) throws WorldDoesNotExistException
    {
        super.place(world, random, "textures/javaFish/Seahorse.png", 0.3);
        
        _xPos = (_random.nextDouble() * 6) + 1;
        _yPos = (_random.nextDouble() * 6) + 1;
        _xRot = 180;
        _yRot = 90;
        
        // CALL the _displayer's position method
        _displayer.position(_xPos, _yPos, _zPos);
        
        // CALL the _displayer's orientation method
        _displayer.orientation(_xRot, _yRot, _zRot);
        
        //DECLARE a double to store a randomly generated speed and INITIALIZE to a random value between 0.05 and 0.005
        double _randomSpeed = (random.nextDouble() * 0.045) + 0.005;
        
        //INITIALIZE _swimBehavior to a new instance of BasicHorizontalSwim
        _swimBehavior = new BasicDiagonalSwim();
        
        //CALL the _swimBehavior initialize method
        _swimBehavior.initialize(_xPos, _yPos, _zPos, _xRot, _yRot, _zRot, _randomSpeed, _displayer);
    }
    
    
    
    // IMPLEMENTATION OF IUPDATABLE

    /**
     * update method
     */
    public void update()
    {
        // CALL the swimming behavior's Swim method
        _swimBehavior.swim();
        
        // CALL the emit bubble method
        emitBubble();
        
    }
        
    
    
    //IMPLEMENTATION OF IEMITSBUBBLES
    
    /**
     * Makes the pet emit a bubble
     * 
     */
    public void emitBubble()
    {
        //INCREMENT _bubbleSpawn by 1
        _bubbleSpawn ++;
        
        //IF _bubbleSpawn is greater than 30
        if (_bubbleSpawn > 30)
        {
             //CALL the bubble managers place bubble method
             _bubbleManager.placeBubble(_swimBehavior.getXPos(), _swimBehavior.getYPos());
             
             //SET the value of _bubbleSpawn to 0
             _bubbleSpawn = _random.nextInt(10);
        }
    }
    
    /**
     * Adds a refence to the bubble manager
     * 
     */
    public void addBubbleManager(IBubbleManager bubbleManager)
    {
        //PASS the reference to the bubble manager
        _bubbleManager = bubbleManager;
    }
}
