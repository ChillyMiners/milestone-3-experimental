package UserCode.Pets.SwimBehaviors;
import UserCode.Pets.*;
import Framework.Interfaces.*;
import Framework.Implementations.*;


/**
 * A horizontal swimmimng behavior where the fish always faces the direction of movement
 * 
 * @author Dean Sisman
 * @version 1
 */
public class HorizontalAlwaysFacingDirection implements ISwimBehavior
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
    
    //DECLARE a reference to IDpisplayObject, call it "_display"
    private IDisplayObject _display;
    
    /**
     * Constructor for objects of class HorizontalAlwaysFacingDirection
     */
    public HorizontalAlwaysFacingDirection()
    {
        
    }
    
    
    
    //IMPLEMENTATION OF ISWIMBEHAVIOR

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
    
    /**
     * Initlializes the swimming behavior, passing the required data and references
     *
     * @param xPos the pets x position
     * @param yPos the pets y position
     * @param xPos the pets z position
     * @param xRot the pets x orientation
     * @param yRot the pets y orientation
     * @param zRot the pets z orientation
     * @param speed the speed of movement
     * @param display the reference to the pets displayobject
     */
    public void initialize(double xPos, double yPos, double zPos, double xRot, double yRot,
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
     * Gets the pets x position
     * @return the pets x position
     * 
     */
    public double getXPos()
    {
        return _xPos;
    }
    
    /**
     * Gets the pets y position
     * @return the pets y position
     * 
     */
    public double getYPos()
    {
        return _yPos;
    }
}
