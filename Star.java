/**
 * Star.
 * @author jacksonburns
 * @version 04/03/19
 */
public class Star extends GameElement
{
  /**
   * Create Star object.
   */
  public Star()
  {
    super();
  }
  /**
   * Draws the Star object on screen.
   */
  public void draw()
  {
	  StdDraw.filledCircle(pose.xPosition, pose.yPosition, 1);
  }
}
