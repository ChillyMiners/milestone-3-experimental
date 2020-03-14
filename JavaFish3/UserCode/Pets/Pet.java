package UserCode.Pets;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;
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
        // SET position of Lion by translating _displayObject:
        _displayer.position(((random.nextDouble() * 6) + 1), ((random.nextDouble() * 6) + 1), 0.1);
        
        // SET orientation of Lion by rotating _displayObject:
        _displayer.orientation(0, 90, 0);
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
        
        // PASS the reference to Random
        _random = random;
    }
}
