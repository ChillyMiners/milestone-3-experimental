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
     * Initlializes the swimming behavior, passing the required data and references
     *
     * @param xPos the pets x position
     * @param yPos the pets y position
     * @param xPos the pets z position
     * @param xRot the pets x orientation
     * @param yRot the pets y orientation
     * @param zRot the pets z orientation
     * @param speed the speed of movement
     * @param display the reference to the pets displayobject
     */
    void initialize(double xPos, double yPos, double zPos, double xRot, double yRot,
                               double zRot, double speed, IDisplayObject display);
    
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
