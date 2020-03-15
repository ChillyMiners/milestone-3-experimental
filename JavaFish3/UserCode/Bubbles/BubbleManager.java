package UserCode.Bubbles;
import java.util.ArrayList;
import Framework.Interfaces.*;

/**
 * Write a description of class BubbleManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BubbleManager implements IBubbleManager
{
    // instance variables - replace the example below with your own
    private ArrayList<IUpdatable> _bubbles;
    
    // DECLARE an integer to control which bubble gets selected, call it "_bubbleSelector" and INITIALIZE to 0
    private int _bubbleSelector = 0;

    /**
     * Constructor for objects of class BubbleManager
     */
    public BubbleManager()
    {
        
    }
    
    
    
    //IMPLEMENTATION OF IBUBBLEMANAGER

    /**
     * Places a bubble at the parameter values
     * 
     * @param x the x position
     * @param y the y position
     */
    public void placeBubble(double xParam, double yParam)
    {
        if (_bubbleSelector < _bubbles.size())
        {
            //CALL the selected bubble in the ArrayList's setPos method, passing the parameters for x and y position
            ((IBubble)_bubbles.get(_bubbleSelector)).setPos(xParam ,yParam);
            
            // INCREMENT _bubbleSelector by 1
            _bubbleSelector++;
        }
        
        else
        {
            //CALL the first bubble in the ArrayList's setPos method, passing the parameters for x and y position
            ((IBubble)_bubbles.get(0)).setPos(xParam ,yParam);
            
            // SET _bubbleSelector to 1
            _bubbleSelector = 1;
        }
    }
    
    /**
     * Adds the references to the bubbles
     * 
     * @param bubbles the arraylist of bubbles
     */
    public void addBubbles(ArrayList<IUpdatable> bubbles)
    {
        _bubbles = bubbles;
    }
}
