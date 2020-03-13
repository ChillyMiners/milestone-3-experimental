package UserCode;
import Framework.Interfaces.IUpdatable;


/**
 * Interface for factory classes which create instances of IUpdatable
 * 
 * @author Dean Sisman
 * @version 1
 */
public interface IUpdatableFactory
{
    /**
     * Creates and returns a new instance of IUpdateable
     * 
     * @param whichUpdatable specifies which class to create a new instance of
     * @return the created instance 
     */
    <T extends IUpdatable> IUpdatable create(Class<T> whichUpdatable) throws Exception;
}
