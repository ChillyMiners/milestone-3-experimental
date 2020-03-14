package UserCode.Pets;


/**
 * Provides an easy way of storing and passing position data for pets
 * 
 * @author Dean Sisman
 * @version 1
 */
public class PositionStorage implements IPositionStorage
{
    private double _xPos = 1;
    private double _yPos = 1;
    private double _zPos = 0.1;
    private double _xRot = 0;
    private double _yRot = -90;
    private double _zRot = 0;

    /**
     * Constructor for objects of class PositionStorage
     */
    public PositionStorage()
    {
        System.out.print("position storage made!");
    }

    /**
     * Sets the value of xPos
     * 
     * @param  xPos the x position
     */
    public void setXPos(double xPos)
    {
        _xPos = xPos;
        System.out.print("x pos set");
    }
    
    /**
     * Sets the value of yPos
     * 
     * @param  yPos the y position
     */
    public void setYPos(double yPos)
    {
        _yPos = yPos;
        System.out.print("y pos set");
    }
    
    /**
     * Sets the value of zPos
     * 
     * @param  zPos the z position
     */
    public void setZPos(double zPos)
    {
        _zPos = zPos;
        System.out.print("y pos set");
    }
    
    /**
     * Returns the value of xPos
     * 
     * @return xPos the x position
     */
    public double getXPos()
    {
        return _xPos;
    }
    
    /**
     * Returns the value of yPos
     * 
     * @return yPos the y position
     */
    public double getYPos()
    {
        return _yPos;
    }
    
    /**
     * Returns the value of zPos
     * 
     * @return zPos the z position
     */
    public double getZPos()
    {
        return _zPos;
    }
    
    /**
     * Sets the value of xRot
     * 
     * @param  xRot the x rotation
     */
    public void setXRot(double xRot)
    {
        _xRot = xRot;
    }
    
    /**
     * Sets the value of yRot
     * 
     * @param  yRot the y rotation
     */
    public void setYRot(double yRot)
    {
        _yRot = yRot;
    }
    
    /**
     * Sets the value of zRot
     * 
     * @param  zRot the z rotation
     */
    public void setZRot(double zRot)
    {
        _zRot = zRot;
    }
    
    /**
     * Returns the value of xRot
     * 
     * @return xRot the x rotation
     */
    public double getXRot()
    {
        return _xRot;
    }
    
    /**
     * Returns the value of yRot
     * 
     * @return yRot the y rotation
     */
    public double getYRot()
    {
        return _yRot;
    }
    
    /**
     * Returns the value of zRot
     * 
     * @return zRot the z rotation
     */
    public double getZRot()
    {
        return _zRot;
    }
}
