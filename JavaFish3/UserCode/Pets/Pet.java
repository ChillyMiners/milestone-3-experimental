package UserCode.Pets;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;
import UserCode.Pets.SwimBehaviors.*;
import java.util.Random;
import java.util.ArrayList;


/**
 * Abstract class Pet - provides a framework for the fish in the aquarium
 * 
 * @author Dean Sisman
 * @version 1
 */
public abstract class Pet implements IPlaceable, IUpdatable
{
    // DECLARE a reference to IDisplayObject, call it _displayer
    protected IDisplayObject _displayer;
    
    // DECLARE a reference to Random, call it _random
    protected Random _random;
    
    // DECLARE a double for the pet's x position
    protected double _xPos;
    
    // DECLARE a double for the pet's y position
    protected double _yPos;
    
    // DECLARE a double for the pet's z position
    protected double _zPos;
    
    // DECLARE a double for the pet's x orientation
    protected double _xRot;
    
    // DECLARE a double for the pet's y orientation
    protected double _yRot;
    
    // DECLARE a double for the pet's z orientation
    protected double _zRot;
    
    // DECLARE a reference to ISwimBehavior, call it _swimBehavior
    protected ISwimBehavior _swimBehavior;
    
    public void place(IWorld world, Random random, String texture, double scale) throws WorldDoesNotExistException
    {
        // CREATE a new instance of DisplayObject for _displayer
        _displayer = new DisplayObject("models/billboard/billboard.obj", texture, scale);
        
        // PASS the reference to Random
        _random = random;
        
        _xPos = 1;
        _yPos = 1;
        _zPos = 0.1;
        _xRot = 0;
        _yRot = -90;
        _zRot = 0;
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
    }
}
