package UserCode;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import env3d.Env;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author (your name here!) and Marc Price
 * @version 0.6
 */
public class Simulation
{
    // instance variables:
    // DECLARE a reference to the IWorld, call it '_world':
    private IWorld _world;
    
    // DECLARE a reference to the IInput, call it '_input':
    private IInput _input;
        
    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;

    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        // INITIALISE instance variables:
        // _world:
        _world = new Core();
        
        // _input:
        _input = (IInput) _world;
    }


    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run()
    {
        // Create the 3D world:
        _world.create();
        
        // User try - catch to ensure 3D world was successfully created:
        try
        {
            // ADD Objects to 3D world?:
            
            
        
            // Start simulation loop:
            while (!endSim)
            {
                // UPDATE STAGE:
                // IF: user has requested simulation loop exit (ie escape pressed):
                if (_input.getKey() == 1)
                {
                    // SET: render loop exit condition
                    endSim = true;
                }
                        
                // UPDATE Objects in 3D world:
                
                
            
                // UPDATE 3D World:
                // Apply all updates to the environment.
                // This must be called at the end of each pass through the simulation loop.
                // Cast to IUpdatable interface
                ((IUpdatable)_world).update();
            }
        
            // EXIT: cleanly by closing-down the environment:
            _world.destroy();
        }
        catch (WorldDoesNotExistException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
