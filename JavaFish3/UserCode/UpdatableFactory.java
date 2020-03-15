package UserCode;
import Framework.Interfaces.IUpdatable;
import UserCode.Bubbles.*;


/**
 * Creates instances of IUpdatable on request
 * 
 * @author Dean Sisman
 * @version 1
 */
public class UpdatableFactory implements IUpdatableFactory
{
    /**
     * Constructor for objects of class UpdatableFactory
     */
    public UpdatableFactory()
    {
        
    }
    
    
    
    //IMPLEMENTATION OF IUPDATABLEFACTORY

    /**
     * Creates and returns a new instance of IUpdateable
     * 
     * @param whichUpdatable specifies which class to create a new instance of
     * @return the created instance 
     */
    public <T extends IUpdatable> IUpdatable create(Class<T> whichUpdatable) throws Exception
    {
        // CREATE new instance of IUpdatable, call it "whichUpdatable"
        IUpdatable returnUpdatable = whichUpdatable.newInstance();
        
        // RETURN new instance of IUpdatable
        return returnUpdatable;
    }
}
