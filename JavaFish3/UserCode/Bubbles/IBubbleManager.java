package UserCode.Bubbles;
import java.util.ArrayList;
import Framework.Interfaces.*;

/**
 * Interfaces the bubble manager
 * 
 * @author Dean Sisman 
 * @version 1
 */
public interface IBubbleManager
{
    /**
     * Places a bubble at the parameter values
     * 
     * @param x the x position
     * @param y the y position
     */
    void placeBubble(double x, double y);
    
    /**
     * Adds the references to the bubbles
     * 
     * @param bubbles the arraylist of bubbles
     */
    void addBubbles(ArrayList<IUpdatable> bubbles);
}
