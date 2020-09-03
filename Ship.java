/**
 * Ship.
 * @author jacksonburns
 * @version 04/03/19
 */
public class Ship extends AnimatedObject
{ 
  private boolean thrusting = true;
		  
  /**
   * Create Ship object.
   * @param pose Position variable with heading
   * @param velocity Has a heading and a magnitude
   */
  public Ship(Pose pose, Vector2D velocity)
  {
	  super(pose, velocity, 10);
  }
  /**
   * Turns the ship to the left.
   */
  public void turnLeft()
  {
    pose.setHeading(pose.getHeading()+.1);
  }
  /**
   * Turns the ship to the right.
   */
  public void turnRight()
  {
    pose.setHeading(pose.getHeading()-.1);
  }
  /**
   * Propels the ship forward.
   * @param acceleration magnitude of ship
   */
  public void thrust(double acceleration)
  {
    velocity.setHeading(pose.getHeading());
    thrusting = true;
    GameUtils.applyThrust(velocity, velocity.getHeading(), acceleration);
    pose.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
    thrusting = false;
  }
  
  /**
  * Slows the ship down.
  */
  public void friction()
  {
    velocity.setMagnitude(velocity.getMagnitude() * .99);
    pose.moveAndWrap(velocity, GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT);
  }
  /**
   * Fetches ship's x value.
   * @return x value 
   */
  public double getX()
  {
    double temp = pose.getX();
    return temp;
  }
  /**
   * Fetches ship's y value.
   * @return y value
   */
  public double getY()
  {
    double temp = pose.getY();
    return temp;
  }
   /**
   * Fetches the direction the ship is facing (0-2PI).
   * @return direction ship is facing
   */
  public double getHeading()
  {
    double temp = pose.getHeading();
    return temp;
  }
  /**
   * Updates the status of the ship.
   */
  public void update()
  {
    if(StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT))
    {
      turnLeft();
    } else if(StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT))
    {
      turnRight();
    }
    if(StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_DOWN))
    {
      thrust(.1);
    }
    if(!thrusting)
    {
      friction();
    }
	  
  }
  /**
   * draws the ship object on screen.
   */
  public void draw()
  {
	  GameUtils.drawPoseAsTriangle(pose, 10, 20);
  }
}
