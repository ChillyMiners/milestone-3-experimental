package UserCode.Pets.SwimBehaviors;
import UserCode.Pets.*;
import Framework.Interfaces.*;
import Framework.Implementations.*;

/**
 * A basic diagonal swimming behavior for pets
 * 
 * @author Dean Sisman
 * @version 1
 */
public class BasicDiagonalSwim
{
    /**
     * Constructor for objects of class BasicDiagonalSwim
     */
    public BasicDiagonalSwim()
    {
        //
    }

    /**
     * Runs the horizontal swimming behavior for the pets
     * 
     * @param xPos the pets x position
     * @param speed the pets movement speed
     * @return newPos, the new x position for the fish
     */
    double swimX(double xPos, double speed)
    {
        xPos += 0.001;
        return xPos;
    }
    
    /**
     * Runs the vertical swimming behavior for the pets
     * 
     * @param yPos the pets y position
     * @param speed the pets movement speed
     * @return newPos, the new y position for the fish
     */
    double swimY(double yPos, double speed)
    {
        yPos += 0.001;
        return yPos;
    }
}
