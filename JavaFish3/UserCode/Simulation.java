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

//----------START OF CODE ADDED BY DEAN----------
import java.util.ArrayList;
import java.util.Random;
import UserCode.Pets.*;
//----------END OF CODE ADDED BY DEAN----------

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author Dean Sisman and Marc Price
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
    
    //----------START OF CODE ADDED BY DEAN----------
    // DECLARE an arraylist to hold references to IUpdatable, call it "_updatables"
    private ArrayList<IUpdatable> _updatables;
    
    // DECLARE a reference to IUpdatableFactory, call it "_updatableFactory"
    private IUpdatableFactory _updatableFactory;
    
    // DECLARE a reference to Random, call it "_random"
    private Random _random;
    
    // DECLARE an integer to control the amount of JavaFish created, call it "_javaFishAmount" and initialize to 10
    private int _javaFishAmount = 10;
    
    // DECLARE an integer to control the amount of SeaHorse created, call it "_seaHorseAmount" and initialize to 1
    private int _seaHorseAmount = 1;
    
    // DECLARE an integer to control the amount of Urchin created, call it "_urchinAmount" and initialize to 1
    private int _urchinAmount = 1;
    
    // DECLARE an integer to control the amount of Piranha created, call it "_piranhaAmount" and initialize to 1
    private int _piranhaAmount = 1;
    //----------END OF CODE ADDED BY DEAN----------
    
    static void main()
    {
        Simulation simulation = new Simulation();
        simulation.run();
    }

    
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
        
        //----------START OF CODE ADDED BY DEAN----------
        // INITIALIZE _updatables to a new arraylist of IUpdatable
        _updatables = new ArrayList<IUpdatable>();
        
        // INITLIALIZE _updatableFactory to a new reference to UpdatableFactory
        _updatableFactory = new UpdatableFactory();
        
        //INITIALIZE _random to a new reference to Random
        _random = new Random();
        //----------END OF CODE ADDED BY DEAN----------
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
            //CALL the createFish method
            createFish();
            
            
            
            
            
        
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
    
    
    /**
     * Uses loops to call the IUpdatableFactory's method to create new instances of each fish type
     */
    private void createFish()
    {
        try
        {
            //FOR the amount specified in _javaFishAmount
            for (int i = 0; i < _javaFishAmount; i++)
            {
                //CALL the factory create method to make  instances of JavaFish
                _updatables.add(_updatableFactory.create(JavaFish.class));
            }
            
            //FOR the amount specified in _seaHorseAmount
            for (int i = 0; i < _seaHorseAmount; i++)
            {
                //CALL the factory create method to make  instances of SeaHorse
                _updatables.add(_updatableFactory.create(SeaHorse.class));
            }
            
            //FOR the amount specified in _urchinAmount
            for (int i = 0; i < _urchinAmount; i++)
            {
                //CALL the factory create method to make  instances of Urchin
                _updatables.add(_updatableFactory.create(Urchin.class));
            }
            
            //FOR the amount specified in _piranhaAmount
            for (int i = 0; i < _piranhaAmount; i++)
            {
                //CALL the factory create method to make  instances of Piranha
                _updatables.add(_updatableFactory.create(Piranha.class));
            }
            
            //Place all elements in _updatables in the aquarium
            for (int i = 0; i < _updatables.size(); i++)
            {
                ((IPlaceable)_updatables.get(i)).place(_world, _random);
                
            }
        }
        catch (Exception e)
        {
            //Don't do anything
        }
    }
    

}
