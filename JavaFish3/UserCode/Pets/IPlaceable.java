package UserCode.Pets;
import Framework.Interfaces.IWorld;
import Exceptions.*;


/**
 * Interfaces tokens that can be placed in the scene
 * 
 * @author Dean Sisman
 * @version 1
 */
public interface IPlaceable
{
    /**
     * Place the token in the scene
     * 
     * @param world reference to the world
     */
    void place(IWorld world) throws WorldDoesNotExistException;
}
