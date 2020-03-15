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
import UserCode.Bubbles.*;
import UserCode.Input.*;
//----------END OF CODE ADDED BY DEAN----------

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author Dean Sisman and Marc Price
 * @version 0.6
 */
public class Simulation implements IInputObserver
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
    
    // DECLARE a reference to IBubbleManager, call it "_bubbleManager"
    private IBubbleManager _bubbleManager;
    
    // DECLARE a reference to Random, call it "_random"
    private Random _random;
    
    // DECLARE an integer to control the amount of JavaFish created, call it "_javaFishAmount" and initialize to 10
    private int _javaFishAmount = 10;
    
    // DECLARE an integer to control the amount of SeaHorse created, call it "_seaHorseAmount" and initialize to 1
    private int _seaHorseAmount = 2;
    
    // DECLARE an integer to control the amount of Urchin created, call it "_urchinAmount" and initialize to 1
    private int _urchinAmount = 2;
    
    // DECLARE an integer to control the amount of Piranha created, call it "_piranhaAmount" and initialize to 1
    private int _piranhaAmount = 2;
    
    // DECLARE an integer to control the amount of Bubble created, call it "_bubbleAmount" and initialize to 30
    private int _bubbleAmount = 30;
    
    // DEVLARE an array of integers to hold the mouse input, call it "_mouseInput" and initialize to 0,0
    private int[] _mouseInput = {0,0};
    
    // DECLARE a reference to IInputDeclarer, call it "_inputDeclarer"
    private IInputDeclarer _inputDeclarer;
    
    static void main()
    {
        Simulation simulation = new Simulation();
        simulation.run();
    }
    //----------END OF CODE ADDED BY DEAN----------
    
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
        
        //INITLIALIZE _inputDeclarer to a new instance of InputDeclarer
        _inputDeclarer = new InputDeclarer();
        
        //CALL the _inputDeclarer's initlialize method
        _inputDeclarer.initialize(_input);
        
        //ADD the input declarer to the list of _updatables
        _updatables.add((IUpdatable)_inputDeclarer);
        
        //CALL the _inputDeclarer's addObserver method
        _inputDeclarer.addObserver(this);
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
            //----------START OF CODE ADDED BY DEAN----------
            //CALL the createFish method
            createFish();
            
            _bubbleManager = new BubbleManager();
            ArrayList<IUpdatable> _bubbles = new ArrayList<IUpdatable>();
            
            //For all the elements in _updatables
            for (int i = 0; i < _updatables.size(); i++)
            {
                //IF the element is an instance of IEmitsBubble
                if ((_updatables.get(i)) instanceof IEmitsBubbles)
                {
                    //CALL its addBubbleManager method to pass it a reference to the bubble manager
                    ((IEmitsBubbles)_updatables.get(i)).addBubbleManager(_bubbleManager);
                }
                
                //IF the element is an instance of IBubble
                if ((_updatables.get(i)) instanceof IBubble)
                {
                    //ADD it to the arraylist of bubbles
                    _bubbles.add(_updatables.get(i));
                }
                
                //CALL the bubble managers add bubbles method and send the arraylist of bubbles
                _bubbleManager.addBubbles(_bubbles);
            }
            //----------END OF CODE ADDED BY DEAN----------
            
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
                
                //----------START OF CODE ADDED BY DEAN----------
                // UPDATE Objects in 3D world:
                for (int i = 0; i < _updatables.size(); i++)
                {
                    _updatables.get(i).update();
                }
                //----------END OF CODE ADDED BY DEAN----------
               
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
    
    //----------START OF CODE ADDED BY DEAN----------
    /**
     * Uses loops to call the IUpdatableFactory's method to create new instances of each fish type
     */
    private void createFish()
    {
        try
        {
            //FOR the amount specified in _bubbleAmount
            for (int i = 0; i < _bubbleAmount; i++)
            {
                //CALL the factory create method to make  instances of Piranha
                _updatables.add(_updatableFactory.create(Bubble.class));
            }
            
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
            
            //For all the elements in _updatables
            for (int i = 0; i < _updatables.size(); i++)
            {
                if ((_updatables.get(i)) instanceof IPlaceable)
                {
                    //CALL the place method in all _updatables
                    ((IPlaceable)_updatables.get(i)).place(_world, _random);
                }
            }
        }
        catch (Exception e)
        {
            //Don't do anything
        }
    }
    
    
    
    //IMPLEMENTATION OF IINPUTOBSERVER
    
    /**
     * How the observer responds when gven input
     * 
     * @param input the input data
     */
    public void inputResponse(int[] input)
    {
        //SET the values for mouse data to the parameter
        _mouseInput = input;
        
        // DECLARE a double for the x position of the fish food, call it "_xPos" and INITLIALIZE to the mouse input multiplied by 0.0077
        double _xPos = _mouseInput[0]*0.0077;
        
        // DECLARE a double for the y position of the fish food, call it "_yPos" and INITLIALIZE to the mouse input multiplied by 0.0077
        double _yPos = _mouseInput[1]*0.0077;
        try
        {
            //DECLARE a reference to IPlaceable to temporarily store the fish food, call it _fishFood and INITLIALIZE to a new instance of fishFood
            IUpdatable _fishFood = new FishFood();
            
            //CALL the factory create method to make  instances of SeaFood
            _updatables.add(_fishFood);
            
            // CALL the seafood's place method
            ((IPlaceable)_fishFood).place(_world, _random, _xPos, _yPos);
        }
        catch (Exception e)
        {
            // do nothing
        }        
    }
    //----------END OF CODE ADDED BY DEAN----------

}
