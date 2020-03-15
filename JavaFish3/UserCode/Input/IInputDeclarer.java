package UserCode.Input;
import Framework.Interfaces.*;

/**
 * Declares input to all observers
 * 
 * @author Dean Sisman
 * @version 1
 */
public interface IInputDeclarer
{
    /**
     * Initializes the input declarer, passing the required reference to the input
     * 
     * @param input the source of input data
     */
    void initialize(IInput input);
    
    /**
     * Adds a new observer to the list to declare intput to
     *
     * @param oberver the observer to be added
     */
    void addObserver(IInputObserver observer);

    /**
     * Removes the observer from the list to declare intput to
     *
     * @param oberver the observer to be removed
     */
    void removeObserver(IInputObserver observer);
}
