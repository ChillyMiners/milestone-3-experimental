package UserCode.Pets.SwimBehaviors;
import UserCode.Pets.*;
import Framework.Interfaces.*;
import Framework.Implementations.*;

/**
 * The basic horizontal swim used by most fish
 * 
 * @author Dean Sisman
 * @version 1
 */
public class BasicHorizontalSwim implements ISwimBehavior
{
    //DECLARE doubles to represent the positions of the pet
    private double _xPos;
    private double _yPos;
    private double _zPos;
    private double _xRot;
    private double _yRot;
    private double _zRot;
    
    //DECLARE a double to control the movement speed, call it "_speed"
    private double _speed;
    
    //DECLARE a double to control the horizontal movement direction, call it "_xSwimDir"
    private double _xSwimDir = 1;
    
    private IDisplayObject _display;
    
    /**
     * Constructor for objects of class BasicHorizontalSwim
     */
    public BasicHorizontalSwim(double xPos, double yPos, double zPos, double xRot, double yRot,
                               double zRot, double speed, IDisplayObject display)
    {
        //SET the value of the position data members to the parameters
        _xPos = xPos;
        _yPos = yPos;
        _zPos = zPos;
        _xRot = xRot;
        _yRot = yRot;
        _zRot = zRot;
        
        //INITIATE _speed to the value of the parameter "speed"
        _speed = speed;
        
        //PASS the reference of IDisplayObject to _display
        _display = display;
    }

    /**
     * Runs the swimming behavior for the pet
     * 
     * @param position the pets position
     * @return _newPos, the new x position for the fish
     */
    public void swim()
    {
        // CALCULATE the new x position
        _xPos += _speed * _xSwimDir;
        
        //IF the fishes horizontal position is less than 0.2 or greater than 9.8 reverse _xDirection and Y orientation:
        if (_xPos < 0.2 || _xPos > 9.8)
        {
            // REVERSE _xDirection:
            _xSwimDir = - _xSwimDir;
            
            // REVERSE Y orientation:
            _yRot = - _yRot;
        }
        
        // CALL the _displayer's position method
        _display.position(_xPos, _yPos, _zPos);
        
        // CALL the _displayer's orientation method
        _display.orientation(_xRot, _yRot, _zRot);
    }
}
