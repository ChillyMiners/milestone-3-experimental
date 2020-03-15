package UserCode.Bubbles;


/**
 * Interface for pets to implement to emit bubbles
 * 
 * @author Dean Sisman
 * @version 1
 */
public interface IEmitsBubbles
{
    /**
     * Makes the pet emit a bubble
     * 
     */
    void emitBubble();
    
    /**
     * Adds a refence to the bubble manager
     * 
     */
    void addBubbleManager(IBubbleManager bubbleManager);
}
