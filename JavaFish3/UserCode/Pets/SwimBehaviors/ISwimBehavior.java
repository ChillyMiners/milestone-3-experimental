package UserCode.Pets.SwimBehaviors;
import java.util.ArrayList;
import UserCode.Pets.*;

/**
 * Interfaces the various swimming behaviors a pet can use
 * 
 * @author Dean Sisman 
 * @version 1
 */
public interface ISwimBehavior
{
    /**
     * Runs the  swimming behavior for the pets
     * 
     * @param position the pets position
     * @return newPos, the new position for the fish
     */
    IPositionStorage swim(IPositionStorage position);
}
