package UserCode.Bubbles;


/**
 * Interfaces the bubble
 * 
 * @author Dean Sisman 
 * @version 1
 */
public interface IBubble
{
    /**
     * Sets the position of the bubble to the parameter values
     * 
     * @param x the x position
     * @param y the y position
     */
    void setPos(double x, double y);
    
    /**
     * Moves the bubble up the aquarium
     * 
     */
    void ascend();
}
