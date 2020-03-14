package UserCode.Pets;
import java.util.Random;
import Framework.Interfaces.*;
import Exceptions.*;

/**
 * Represents the Urchin
 * 
 * @author Dean Sisman
 * @version 1
 */
public class Urchin extends Pet
{
    /**
     * Constructor for objects of class Urchin
     */
    public Urchin()
    {
        super("textures/javaFish/Urchin.png", 0.3);
    }
    
    
    
    // IMPLEMENTATION OF IPLACEABLE
    
    /**
     * Places the pet in the world
     *
     * @param  world a reference to the IWorld
     * @param random a reference to the Random class
     */
    public void place(IWorld world, Random random) throws WorldDoesNotExistException
    {
        super.place(world, random);
        
        // INITIALIZE _xPos to a random value between 1 and 7
        _xPos = _random.nextDouble() * 6 + 1;
        
        // INITIALIZE _yPos to 0.5
        _yPos = 0.5;
        
        // CALL the _displayer's position method
        _displayer.position(_xPos, _yPos, _zPos);
        
        // CALL the _displayer's orientation method
        _displayer.orientation(_xRot, _yRot, _zRot);
    }
    
    
    
    // IMPLEMENTATION OF IUPDATABLE

    /**
     * update method
     */
    public void update()
    {
        // do nowt
    }
}
