package UserCode.Pets;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import java.util.Random;
import Exceptions.*;

/**
 * Represents the fish rood
 * 
 * @author Dean Sisman
 * @version 1
 */
public class FishFood implements IPlaceable, IUpdatable
{
    // DECLARE a reference to IDisplayObject, call it _displayer
    private IDisplayObject _displayer;
    
    // DECLARE a reference to Random, call it _random
    private Random _random;
    
    // DECLARE a double for the pet's x position
    private double _xPos;
    
    // DECLARE a double for the pet's y position
    private double _yPos;
    
    // DECLARE a double for the pet's z position
    private double _zPos;
    
    // DECLARE a double for the pet's x orientation
    private double _xRot;
    
    // DECLARE a double for the pet's y orientation
    private double _yRot;
    
    // DECLARE a double for the pet's z orientation
    private double _zRot;

    /**
     * Constructor for objects of class FishFood
     */
    public FishFood()
    {
        
    }
    
    
    
    //IMPLEMENTATION OF IPLACEABLE
    
    public void place(IWorld world, Random random) throws WorldDoesNotExistException
    {
        // CREATE a new instance of DisplayObject for _displayer
        _displayer = new DisplayObject("sphere", "textures/javaFish/Seahorse.png", 0.05);
        
        // PASS the reference to Random
        _random = random;
        
        _xPos = (_random.nextDouble() * 6) + 1;
        _yPos = (_random.nextDouble() * 6) + 1;
        _zPos = 0.1;
        _xRot = 0;
        _yRot = 90;
        _zRot = 0;
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
        
        // CALL the _displayer's position method
        _displayer.position(_xPos, _yPos, _zPos);
        
        // CALL the _displayer's orientation method
        _displayer.orientation(_xRot, _yRot, _zRot);
    }
    
    public void place(IWorld world, Random random, double xPos, double yPos) throws WorldDoesNotExistException
    {
        // CREATE a new instance of DisplayObject for _displayer
        _displayer = new DisplayObject("sphere", "textures/javaFish/FishFood.png", 0.05);
        
        // PASS the reference to Random
        _random = random;
        
        _xPos = xPos + 0.1;
        _yPos = yPos + 0.2;
        _zPos = 0.1;
        _xRot = 0;
        _yRot = -90;
        _zRot = 0;
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
        
        // CALL the _displayer's position method
        _displayer.position(_xPos, _yPos, _zPos);
        
        // CALL the _displayer's orientation method
        _displayer.orientation(_xRot, _yRot, _zRot);
    }
    
    
    
    // IMPLEMENTATION OF IUPDATABLE

    /**
     * update method
     */
    public void update()
    {
        if (_yPos > 0.4)
        {
            // DECREMENT y position by 0.005
            _yPos -= 0.005;
            
            // CALL the _displayer's position method
            _displayer.position(_xPos, _yPos, _zPos);
        }
        
    }

}
