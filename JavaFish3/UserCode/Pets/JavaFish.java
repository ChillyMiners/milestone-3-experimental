package UserCode.Pets;
import UserCode.Pets.SwimBehaviors.*;
import java.util.Random;
import Framework.Interfaces.*;
import Exceptions.*;

/**
 * Represents the JavaFish
 * 
 * @author Dean Sisman
 * @version 1
 */
public class JavaFish extends Pet
{
    /**
     * Constructor for objects of class JavaFish
     */
    public JavaFish()
    {
        
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
        super.place(world, random, "textures/javaFish/JavaFish.png", 0.15);
        
        _xPos = (_random.nextDouble() * 6) + 1;
        _yPos = (_random.nextDouble() * 6) + 1;
        
        // CALL the _displayer's position method
        _displayer.position(_xPos, _yPos, _zPos);
        
        // CALL the _displayer's orientation method
        _displayer.orientation(_xRot, _yRot, _zRot);
        
        //DECLARE a double to store a randomly generated speed and INITIALIZE to a random value between 0.05 and 0.005
        double _randomSpeed = (random.nextDouble() * 0.045) + 0.005;
        
        //INITIALIZE _swimBehavior to a new instance of BasicHorizontalSwim
        _swimBehavior = new BasicHorizontalSwim(_xPos, _yPos, _zPos, _xRot, _yRot, _zRot, _randomSpeed, _displayer);
    }
    
    
    
    // IMPLEMENTATION OF IUPDATABLE

    /**
     * update method
     */
    public void update()
    {
        // CALL the swimming behavior's Swim method
        _swimBehavior.swim();
    }
}
