package UserCode.Pets;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;
import UserCode.Pets.SwimBehaviors.*;
import java.util.Random;


/**
 * Abstract class Pet - provides a framework for the fish in the aquarium
 * 
 * @author Dean Sisman
 * @version 1
 */
public abstract class Pet implements IUpdatable, IPlaceable
{
    // DECLARE a reference to IDisplayObject, call it _displayer
    protected IDisplayObject _displayer;
    
    // DECLARE a reference to Random, call it _random
    protected Random _random;
    
    // DECLARE a reference to ISwimBehavior, call it _swimBehavior
    protected ISwimBehavior _swimBehavior;
    
    //DECLARE a double for the pet's x position, call it "_xPos"
    protected double _xPos;
    
    //DECLARE a double for the pet's y position, call it "_yPos"
    protected double _yPos;
    
    //DECLARE a double for the pet's z position, call it "_zPos" and INITIALIZE to 0.1
    protected double _zPos = 0.1;
    
    //DECLARE a double for the pet's x orientation, call it "_xRot" and INITLIALIZE TO 0
    protected double _xRot = 0;
    
    //DECLARE a double for the pet's y orientation, call it "_yRot" and INITIALIZE to 90
    protected double _yRot = -90;
    
    //DECLARE a double for the pet's z orientation, call it "_zRot" and INITLIALIZE to 0
    protected double _zRot = 0;
    
    //DECLARE a double for the pet's movement speed, call it "_speed"
    protected double _speed;

    /**
     * Constructor
     */
    public Pet(String texture, double scale)
    {
        // CREATE a new instance of DisplayObject for _displayer
        _displayer = new DisplayObject("models/billboard/billboard.obj", texture, scale);
    }
    
    public void place(IWorld world, Random random) throws WorldDoesNotExistException
    {
        // PASS the reference to Random
        _random = random;
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
    }
}
