/**
 * GameElement.
 * @author jacksonburns
 * @version 04/03/19
 */
public abstract class GameElement 
{
  protected Pose pose;
  /**
   * Create a GameElement object given a pose.
   * @param pose has direction and a heading
   */
  public GameElement(Pose pose)
  {
	  this.pose = pose;
  }
  /**
   * Create a GameElement object assigned a pose with a random and random heading.
   */
  public GameElement()
  {
    this(new Pose((Math.random() * GameConstants.SCREEN_WIDTH),
	              (Math.random() * GameConstants.SCREEN_HEIGHT),
	              (Math.random() * 360)));
  }
  /**
   * Draws object on screen.
   */
  public abstract void draw();
}
