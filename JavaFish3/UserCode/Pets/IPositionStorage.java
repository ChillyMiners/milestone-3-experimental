package UserCode.Pets;


/**
 * Provides an easy way of storing and passing position data for pets
 * 
 * @author Dean Sisman
 * @version 1
 */
public interface IPositionStorage
{
    /**
     * Sets the value of xPos
     * 
     * @param  xPos the x position
     */
    public void setXPos(double xPos);
    
    /**
     * Sets the value of yPos
     * 
     * @param  yPos the y position
     */
    public void setYPos(double yPos);
    
    /**
     * Sets the value of zPos
     * 
     * @param  zPos the z position
     */
    public void setZPos(double zPos);
    
    /**
     * Returns the value of xPos
     * 
     * @return xPos the x position
     */
    public double getXPos();
    
    /**
     * Returns the value of yPos
     * 
     * @return yPos the y position
     */
    public double getYPos();
    
    /**
     * Returns the value of zPos
     * 
     * @return zPos the z position
     */
    public double getZPos();
    
    /**
     * Sets the value of xRot
     * 
     * @param  xRot the x rotation
     */
    public void setXRot(double xRot);
    
    /**
     * Sets the value of yRot
     * 
     * @param  yRot the y rotation
     */
    public void setYRot(double yRot);
    
    /**
     * Sets the value of zRot
     * 
     * @param  zRot the z rotation
     */
    public void setZRot(double zRot);
    
    /**
     * Returns the value of xRot
     * 
     * @return xRot the x rotation
     */
    public double getXRot();
    
    /**
     * Returns the value of yRot
     * 
     * @return yRot the y rotation
     */
    public double getYRot();
    
    /**
     * Returns the value of zRot
     * 
     * @return zRot the z rotation
     */
    public double getZRot();
}
