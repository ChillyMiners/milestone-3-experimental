package UserCode.Bubbles;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import UserCode.Pets.IPlaceable;
import java.util.Random;
import Exceptions.*;


/**
 * Represents the bubble
 * 
 * @author Dean Sisman
 * @version 1
 */
public class Bubble implements IBubble, IUpdatable, IPlaceable
{
    // DECLARE a reference to IDisplayObject, call it _displayer
    protected IDisplayObject _displayer;
    
    // DECLARE a double for the pet's x position
    protected double _xPos;
    
    // DECLARE a double for the pet's y position
    protected double _yPos;
    
    // DECLARE a double for the pet's z position
    protected double _zPos;
    
    // DECLARE a double for the pet's x orientation
    protected double _xRot;
    
    // DECLARE a double for the pet's y orientation
    protected double _yRot;
    
    // DECLARE a double for the pet's z orientation
    protected double _zRot;
    
    /**
     * Constructor for objects of class Bubble
     */
    public Bubble()
    {
        
    }
    
    
    
    //IMPLEMENTATION OF IBUBBLE

    /**
     * Sets the position of the bubble to the parameter values
     * 
     * @param x the x position
     * @param y the y position
     */
    public void setPos(double x, double y)
    {
        //SET the values for x and y position to the parameter values
        _xPos = x;
        _yPos =  y;
    }
    
    
    
    //IMPLEMENTATION OF IUPDATABLE
    
    /**
     * Update method
     */
    public void update()
    {
        //INCREMENT _yPos by 0.05
        _yPos += 0.05;
        
        // CALL the _displayer's position method
        _displayer.position(_xPos, _yPos, _zPos);
    }
    
    
    
    //IMPLEMENTATION OF IPLACEABLE
    
    /**
     * Place the token in the scene
     * 
     * @param world reference to the world
     */
    public void place(IWorld world, Random random) throws WorldDoesNotExistException
    {
        // CREATE a new instance of DisplayObject for _displayer
        _displayer = new DisplayObject("sphere" , "textures/javaFish/Bubble.png" , 0.04);
        
        // SET the values for the positions
        _xPos = 20;
        _yPos = 0;
        _zPos = 0.1;
        _xRot = 0;
        _yRot = 0;
        _zRot = 0;
        
        // ADD to 3D world:
        world.addDisplayObject(_displayer);
        
        // CALL the _displayer's position method
        _displayer.position(_xPos, _yPos, _zPos);
        
        // CALL the _displayer's orientation method
        _displayer.orientation(_xRot, _yRot, _zRot);
    }
}
