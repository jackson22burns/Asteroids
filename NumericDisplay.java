/**
 * Stats that will appear on screen.
 * @author jacksonburns
 * @version 04/03/19
 */
public class NumericDisplay extends GameElement
{
  private int value;
  private String prefix;
  /**
   * Create a new Numeric display given certain parameters.
   * @param xPos x position
   * @param yPos y position
   * @param value numeric value 
   * @param prefix text to be shown
   */
  public NumericDisplay(int xPos, int yPos, int value, String prefix)
  {
	  super(new Pose((double)xPos, (double)yPos, 0.0));
	  this.value = value;
	  this.prefix = prefix;
  }
  /**
   * draws the NumericValue on screen using parameters in constructor.
   */
  public void draw()
  {
	  StdDraw.text(pose.xPosition, pose.yPosition, prefix+" "+value);
  }
  /**
   * Fetches NumericValue's value.
   * @return value int value
   */
  public int getValue() 
  {
    return value;
  }
  /**
   * Sets value to given parameter.
   * @param value int value
   */
  public void setValue(int value)
  {
    this.value = value;
  }
}
