/**
 * Bullet.
 * @author jacksonburns
 * @version 04/03/19
 */
public class Bullet extends AnimatedObject 
{
  private int timer = 0;
  /**
   * Creates a Bullet Object provided a pose and a velocity.
   * @param pose Position variable with a heading 
   * @param velocity Has a heading and magnitude(speed)
   */
  public Bullet(Pose pose, Vector2D velocity)
  {
    super(pose, velocity, GameConstants.BULLET_RADIUS);
  }
  /**
   * Updates the position of bullet and how long it can stay 'alive'.
   */
  public void update()
  {
    timer++;
    pose.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);	 
  }
  /**
   * Draws bullet on screen when shot.
   */
  public void draw()
  {
    StdDraw.circle(pose.getX(), pose.getY(), 1.5); 
  }
  /**
   * getter method for timer variable.
   * @return timer variable
   */
  public int getTimer()
  {
    return timer;
  }
  /**
   * Fetches the radius of the bullet.
   * @return Radius of the bullet
   */
  public double getRadius()
  {
	  return collisionRadius;
  }
}
