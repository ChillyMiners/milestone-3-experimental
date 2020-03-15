package UserCode.Pets;
import Framework.Interfaces.IWorld;
import Exceptions.*;
import java.util.Random;


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
     * @param random reference to the Random class
     */
    void place(IWorld world, Random random) throws WorldDoesNotExistException;
    
    /**
     * Place the token in the scene at a custom position
     * 
     * @param world reference to the world
     * @param random reference to the Random class
     * @param xPos the x position
     * @param yPos the y position
     */
    void place(IWorld world, Random random, double xPos, double yPos) throws WorldDoesNotExistException;
}
