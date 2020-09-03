/**
 * Enum with three possible sizes for Asteroids.
 * @author jacksonburns
 * @version 04/03/19
 */
public enum AsteroidSize 
{
  SMALL((int)GameConstants.SMALL_ASTEROID_RADIUS, GameConstants.SMALL_ASTEROID_POINTS),
  MEDIUM((int)GameConstants.MEDIUM_ASTEROID_RADIUS, GameConstants.MEDIUM_ASTEROID_POINTS),
  LARGE((int)GameConstants.LARGE_ASTEROID_RADIUS, GameConstants.LARGE_ASTEROID_POINTS);
  
  private int radius;
  private int points;
 
  /**
   * Create an AsteroidSize enum provided by two parameters.
   * @param radius Radius of Asteroid based on its size
   * @param points Points of the Asteroid based on its size
   */
  private AsteroidSize(int radius, int points)
  {
	  this.radius = radius;
	  this.points = points;
  }
  /**
   * Gets the radius of the Asteroid.
   * @return radius of the Asteroid
   */
  public int getRadius()
  {
	  return radius;
  }
  /**
   * Gets the amount of points given to the Asteroid.
   * @return points of the asteroid
   */
  public int getPoints()
  {
	  return points;
  }
  /**
   * Returns a random AsteroidSize.
   * @return random AsteroidSize enum
   */
  public static AsteroidSize randomSize()
  {
	  int randomNum = (int)Math.random() * 2;
	  if (randomNum == 0)
	  {
		  return AsteroidSize.SMALL;
	  } else if(randomNum == 1)
	  {
		  return AsteroidSize.MEDIUM;
	  } else
	  {
		  return AsteroidSize.LARGE;
	  }
  }
}
