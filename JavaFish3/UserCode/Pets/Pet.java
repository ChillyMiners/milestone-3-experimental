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
public abstract class Pet implements IPlaceable, IUpdatable
{
    // DECLARE a reference to IDisplayObject, call it _displayer
    protected IDisplayObject _displayer;
    
    // DECLARE a reference to Random, call it _random
    protected Random _random;
    
    // DECLARE a reference to IPositionStorage, call it _position
    protected IPositionStorage _position;
    
    // DECLARE a reference to IPositionStorage, call it _newPos
    //protected IPositionStorage _newPos;
    
    // DECLARE a reference to ISwimBehavior, call it _swimBehavior
    protected ISwimBehavior _swimBehavior;

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
        
        // CREATE a new instance of PositionStorage for _position
        _position = new PositionStorage();
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
    }
}
