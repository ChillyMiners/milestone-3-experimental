package UserCode.Pets;
import java.util.Random;
import Framework.Interfaces.*;
import Exceptions.*;
import UserCode.Pets.SwimBehaviors.*;

/**
 * Represents the Piranha
 * 
 * @author Dean Sisman
 * @version 1
 */
public class Piranha extends Pet
{
    /**
     * Constructor for objects of class Piranha
     */
    public Piranha()
    {
        super("textures/javaFish/PiranhaRed.png", 0.3);
                
        //INITIALIZE _swimBehavior to a new instance of BasicHorizontalSwim
        _swimBehavior = new BasicHorizontalSwim(_position, 0.005);
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
        
        // CALL the _position methods to set the x and y positions to a random value between 1 and 7
        _position.setXPos(_random.nextDouble() * 6 + 1);
        _position.setYPos(_random.nextDouble() * 6 + 1);
        
        // CALL the _displayer's position method
        _displayer.position(_position.getXPos(), _position.getYPos(), _position.getZPos());
        
        // CALL the _displayer's orientation method
        _displayer.orientation(_position.getXRot(), _position.getYRot(), _position.getZRot());
    }
    
    
    
    // IMPLEMENTATION OF IUPDATABLE

    /**
     * update method
     */
    public void update()
    {
        // CALL the swimming behavior's SwimX method to get a new X position
        //_newPos = _swimBehavior.swim(_position);
        
        // CALL the _displayer's position method
        //_displayer.position(_newPos.getXPos(), _newPos.getYPos(), _newPos.getZPos());
        
        // CALL the _displayer's orientation method
        //_displayer.orientation(_newPos.getXRot(), _newPos.getYRot(), _newPos.getZRot());
    }
}
