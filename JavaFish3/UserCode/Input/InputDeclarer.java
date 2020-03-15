package UserCode.Input;
import Framework.Implementations.*;
import Framework.Interfaces.*;
import java.util.ArrayList;

/**
 * Declares input to the observers
 * 
 * @author Dean Sisman
 * @version 1
 */
public class InputDeclarer implements IInputDeclarer, IUpdatable
{
    // DECLARE an arraylist to hold references to the obervers, call it "_observers"
    private ArrayList<IInputObserver> _observers;
    
    // DECLARE a reference to IInput, call it "_input"
    private IInput _input;
    
    // DECLARE an array of integers to store mouse input, call it "_mouseInput"
    int[] _mouseInput;

    /**
     * Constructor for objects of class InputDeclarer
     */
    public InputDeclarer()
    {
        
    }

    
    
    //IMPLEMENTATION OF IINPUTDECLARER
    
    /**
     * Initializes the input declarer, passing the required reference to the input
     * 
     * @param input the source of input data
     */
    public void initialize(IInput input)
    {
        // INITIALIZE the arraylist of observers
        _observers = new ArrayList<IInputObserver>();
        
        // PASS the reference to the input
        _input = input;
    }
    
    /**
     * Adds a new observer to the list to declare intput to
     *
     * @param oberver the observer to be added
     */
    public void addObserver(IInputObserver observer)
    {
        // ADD the reference to the observer to the arraylist
        _observers.add(observer);
    }

    /**
     * Removes the observer from the list to declare intput to
     *
     * @param oberver the observer to be removed
     */
    public void removeObserver(IInputObserver observer)
    {
        // REMOVE the reference to the observer from the arraylist
        _observers.remove(observer);
    }
    
    
    
    //IMPLEMENTATION OF IUPDATABLE
    
    /**
     * The update method
     *
     */
    public void update()
    {
        try
        {
            //IF the left mouse has been clicked
            if (_input.getMouseClicked() == 0)
            {
                // SET _mouseInput to the mouse coordinates
                _mouseInput = _input.getMousePointer();
                
                //FOR every member in _observers
                for (int i = 0; i < _observers.size(); i++)
                {
                    //CALL the observers inputResponse method, passing the mouse input data
                    (_observers.get(i)).inputResponse(_mouseInput);
                }
            }
        }
        catch (Exception e)
        {
            
        }
    }
}
