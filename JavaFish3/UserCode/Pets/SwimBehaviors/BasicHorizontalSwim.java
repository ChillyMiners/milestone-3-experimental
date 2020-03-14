package UserCode.Pets.SwimBehaviors;
import UserCode.Pets.*;

/**
 * The basic horizontal swim used by most fish
 * 
 * @author Dean Sisman
 * @version 1
 */
public class BasicHorizontalSwim implements ISwimBehavior
{
    //DECLARE a reference to IPositionStorage, call it "_newPos"
    private IPositionStorage _newPos;
    
    //DECLARE a double to control the movement speed, call it "_speed"
    private double _speed;
    
    //DECLARE a double to control the horizontal movement direction, call it "_xSwimDir"
    private double _xSwimDir = 1;
    
    /**
     * Constructor for objects of class BasicHorizontalSwim
     */
    public BasicHorizontalSwim(IPositionStorage position, double speed)
    {
        //CALL the _newPos methods to copy over the values from the passed PositionStorage
        _newPos.setXPos( position.getXPos() );
        _newPos.setYPos( position.getYPos() );
        _newPos.setXPos( position.getXPos() );
        _newPos.setXRot( position.getXRot() );
        _newPos.setYRot( position.getYRot() );
        _newPos.setZRot( position.getZRot() );
        
        //INITIATE _speed to the value of the parameter "speed"
        _speed = speed;
    }

    /**
     * Runs the swimming behavior for the pet
     * 
     * @param position the pets position
     * @return _newPos, the new x position for the fish
     */
    public IPositionStorage swim(IPositionStorage position)
    {
        // CALCULATE the new x position
        _newPos.setXPos( position.getXPos() + _speed * _xSwimDir );
        
        // RETURN the new position
        return _newPos;
    }
}
