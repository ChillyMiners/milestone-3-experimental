package UserCode.Pets.SwimBehaviors;
import java.util.ArrayList;
import UserCode.Pets.*;
import Framework.Interfaces.*;
import Framework.Implementations.*;

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
     */
    void swim();
    
    /**
     * Gets the pets x position
     * @return the pets x position
     * 
     */
    double getXPos();
    
    /**
     * Gets the pets y position
     * @return the pets y position
     * 
     */
    double getYPos();
}
