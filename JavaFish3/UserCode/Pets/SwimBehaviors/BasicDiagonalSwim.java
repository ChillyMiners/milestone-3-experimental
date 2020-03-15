package UserCode.Pets.SwimBehaviors;
import UserCode.Pets.*;
import Framework.Interfaces.*;
import Framework.Implementations.*;

/**
 * A basic diagonal swimming behavior for pets
 * 
 * @author Dean Sisman
 * @version 1
 */
public class BasicDiagonalSwim implements ISwimBehavior
{
    //DECLARE doubles to represent the positions of the pet
    private double _xPos;
    private double _yPos;
    private double _zPos;
    private double _xRot;
    private double _yRot;
    private double _zRot;
    
    //DECLARE a double to control the horizontal movement speed, call it "xSpeed"
    private double _xSpeed;
    
    //DECLARE a double to control the vertical movement speed, call it "_ySpeed"
    private double _ySpeed;
    
    //DECLARE a double to control the horizontal movement direction, call it "_xSwimDir"
    private double _xSwimDir = 1;
    
    private IDisplayObject _display;
    
    /**
     * Constructor for objects of class BasicDiagonalSwim
     */
    public BasicDiagonalSwim()
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
        _xPos += _xSpeed * _xSwimDir;
        
        // INCREMENT the fishes y position by _ySpeed:
        _yPos += _ySpeed;
        
        //IF the fishes horizontal position is less than 0.2 or greater than 9.8 reverse _xDirection and Y orientation:
        if (_xPos < 0.2 || _xPos > 9.8)
        {
            // REVERSE _xDirection:
            _xSwimDir = - _xSwimDir;
            
            // REVERSE Y orientation:
            _yRot = - _yRot;
        }
        //IF the fishes vertical position is less than than 1 or greater than 7.2, reverse _ySpeed:
        if (_yPos < 1.0 || _yPos > 7.2)
        {
            _ySpeed = - _ySpeed;
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
        
        // CALL the getSpeeds method:
        getSpeeds(speed);
        
        //PASS the reference of IDisplayObject to _display
        _display = display;
    }
    
    /**
     * METHOD: calculates the x and y speeds using the input speed and the angle
     *
     */
    private void getSpeeds(double speed)
    {
        // CALCULATE the value for _xSpeed using _diagSpeed and _angle:
        _xSpeed = Math.cos(Math.toRadians(55)) * speed;
        
        // CALCULATE the value for _ySpeed using _diagSpeed and _angle:
        _ySpeed = Math.sin(Math.toRadians(55)) * speed;
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
