package UserCode.Input;


/**
 * An observer interface for classes to respond to input
 * 
 * @author Dean Sisman
 * @version 1
 */
public interface IInputObserver
{
    /**
     * How the observer responds when gven input
     * 
     * @param input the input data
     */
    void inputResponse(int[] input);
}
