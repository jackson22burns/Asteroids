/**
 * Objects that can collide with ships and bullets.
 * @author jacksonburns
 * @version 04/03/19
 */
public abstract class Enemy extends AnimatedObject 
{
  private int pointValue;
  private double radius;
  /**
   * Create an Enemy object.
   * @param speed Magnitude for travel
   * @param collisionRadius Radius for which it can collide with other objects
   * @param pointValue Number of points you get for 'killing' these objects
   */
  public Enemy(double speed, double collisionRadius, int pointValue)
  {
	  super(speed, collisionRadius);
	  this.pointValue = pointValue;
	  radius = collisionRadius;
  }
  /**
   * Getter method for pointValue.
   * @return Number of points you get for 'killing' these objects
   */
  public int getPointValue()
  {
	  return pointValue;
  }
  /**
   * Fetches the object's x value.
   * @return object's x value
   */
  public double getX()
  {
    double d = pose.getX();
    return d;
  }
  /**
   * Fetches the object's y value.
   * @return object's y value
   */
  public double getY()
  {
	  double d = pose.getY();
	  return d;
  }
  /**
   * Fetches the objects collision radius.
   * @return collision radius
   */
  public double getRadius()
  {
	  return radius;
  }
}
