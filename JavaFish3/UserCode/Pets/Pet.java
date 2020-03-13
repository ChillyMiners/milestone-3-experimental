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
    
    // DECLARE a string to hold the model for the displayobject
    private String _model = "models/billboard/billboard.obj";

    /**
     * Constructor
     */
    public Pet(String texture, double scale)
    {
        // CREATE a new instance of DisplayObject for _displayer
        _displayer = new DisplayObject(_model, texture, scale);
    }
    
    public void place(IWorld world) throws WorldDoesNotExistException
    {
        // SET position of Lion by translating _displayObject:
        _displayer.position(0.1, 0.1, 1.0);
        
        // SET orientation of Lion by rotating _displayObject:
        _displayer.orientation(0.0, 90.0, 0.0);
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
    }
}
