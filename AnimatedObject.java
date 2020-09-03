/**
 * 
 * @author jacksonburns
 * @version 04/03/19
 */
public abstract class AnimatedObject extends GameElement
{
  protected Vector2D velocity;
  protected double collisionRadius;
  protected boolean destroyed;
  /**
   * Create an AnimatedObject object given parameters.
   * @param pose Point with a heading
   * @param velocity Vector with a heading and magnitude
   * @param collisionRadius radius in which object can collide with other objects
   */
  public AnimatedObject(Pose pose, Vector2D velocity, double collisionRadius)
  {
	  super(pose);
	  this.velocity = velocity;
	  this.collisionRadius = collisionRadius;
  }
  /**
   * Create an AnimatedObject class given parameters.
   * @param speed magnitude of objects vector
   * @param collisionradius radius in which object can collide with other objects
   */
  public AnimatedObject(double speed, double collisionradius)
  {
	  super();
	  this.velocity = new Vector2D( pose.getHeading(),speed);
	  this.collisionRadius = collisionradius;
  }
  /**
   * updates objects location by moving it across screen.
   */
  public void update()
  {
    pose.move(velocity);
  }
  /**
   * Checks whether an object is close enough to 'collide'.
   * @param other Object being used to calculate distance.
   * @return boolean value of whether or not the object has collided
   */
  public boolean checkCollision(AnimatedObject other)
  {
    if(this.pose.distance(other.pose) <= (other.collisionRadius + this.collisionRadius))
    {
      return true;
    }
    return false;
  }
}
