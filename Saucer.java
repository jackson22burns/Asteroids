/**
 * Saucer.
 * @author jacksonburns
 * @version 04/03/19
 */
public class Saucer extends Enemy
{
  
  /**
   * Create a Saucer object.
   */
  public Saucer()
  {
    super((double)GameConstants.SAUCER_SPEED, 
          (double)GameConstants.SAUCER_WIDTH / 2, 
           GameConstants.SAUCER_POINTS );
  }
  /**
   * updates the status of Saucer object.
   */
  public void update()
  {
    if(GameConstants.GENERATOR.nextDouble() <= .05)
    {
      velocity.setHeading((GameConstants.GENERATOR.nextDouble() * (Math.PI * 2)));
    }
    pose.move(velocity);
  }
  /**
   * draws saucer object on screen.
   */
  public void draw()
  {
    StdDraw.rectangle(pose.xPosition, pose.yPosition, GameConstants.SAUCER_WIDTH, GameConstants.SAUCER_HEIGHT);
  }
  /**
   * Fetches the points for a saucer.
   * @return points for saucer
   */
  public double getPoints()
  {
    return GameConstants.SAUCER_POINTS;
  }
}
