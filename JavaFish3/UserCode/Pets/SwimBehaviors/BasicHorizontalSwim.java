package UserCode.Pets.SwimBehaviors;


/**
 * Write a description of class BasicHorizontalSwim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicHorizontalSwim implements ISwimBehavior
{
    /**
     * Constructor for objects of class BasicHorizontalSwim
     */
    public BasicHorizontalSwim()
    {
    }

    /**
     * Runs the horizontal swimming behavior for the pets
     * 
     * @param xPos the pets x position
     * @param speed the pets movement speed
     * @return newPos, the new x position for the fish
     */
    public double swimX(double xPos, double speed)
    {
        double newPos = xPos + speed;
        return newPos;
    }
    
    /**
     * Runs the vertical swimming behavior for the pets
     * 
     * @param yPos the pets y position
     * @param speed the pets movement speed
     * @return newPos, the new y position for the fish
     */
    public double swimY(double yPos, double speed)
    {
        return yPos;
    }
}
