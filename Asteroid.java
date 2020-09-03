/**
 * Asteroid object.
 * @author jacksonburns
 * @version 04/03/19
 */
public class Asteroid extends Enemy 
{
  private double points;
  private AsteroidSize size;
  /**
   * Create an Asteroid object given a size.
   * @param inSize size of Asteroid
   */
  public Asteroid(AsteroidSize inSize)
  {
	  super(1, inSize.getRadius(), inSize.getPoints());
	  points = inSize.getPoints();
	  this.size = inSize;
  }
  
  /**
   * draws Asteroid object on screen.
   */
  public void draw()
  {
	  StdDraw.circle(pose.xPosition, pose.yPosition, size.getRadius());
  }
  /**
   * updates objects location by moving it across screen and wrapping when it reaches screen boundaries.
   */
  public void update()
  {
	  pose.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
  }
  /**
   * Fetches the point value for Asteroid.
   * @return point value for asteroid
   */
  public double getPoints()
  {
	  return points;
  }
}
