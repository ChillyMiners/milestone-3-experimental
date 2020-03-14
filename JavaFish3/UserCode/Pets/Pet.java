package UserCode.Pets;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;


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

    /**
     * Constructor
     */
    public Pet(String texture, double scale)
    {
        // CREATE a new instance of DisplayObject for _displayer
        _displayer = new DisplayObject("models/billboard/billboard.obj", texture, scale);
    }
    
    public void place(IWorld world) throws WorldDoesNotExistException
    {
        // SET position of Lion by translating _displayObject:
        _displayer.position(1, 1, 0.1);
        
        // SET orientation of Lion by rotating _displayObject:
        _displayer.orientation(0, 90, 0);
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
    }
}
