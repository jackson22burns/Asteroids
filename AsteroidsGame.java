import java.util.ArrayList;
import java.util.Iterator;
/**
 * AsteroidsGame.
 * @author jacksonburns
 * @version 04/03/19
 */
public class AsteroidsGame 
{
  private int numAsteroids;
  
  private NumericDisplay score; 
  private NumericDisplay lives; 
  private ArrayList<Star> stars = new ArrayList<>();
  private ArrayList<Asteroid> asteroids = new ArrayList<>();
  private ArrayList<Saucer> saucers = new ArrayList<>();
  private ArrayList<Bullet> bullets = new ArrayList<>();
  private Ship ship;
  
  /**
   * Creates an Asteroids game given a number of asteroids.
   * @param inNumAsteroids number of asteroids on screen
   */
  public AsteroidsGame(int inNumAsteroids)
  {
    numAsteroids = inNumAsteroids;
    
    score = new NumericDisplay(GameConstants.SCORE_X, GameConstants.SCORE_Y, 0, "score:");
    lives = new NumericDisplay(GameConstants.LIVES_X, GameConstants.LIVES_Y, 3, "lives:");
    
    ship = new Ship(new Pose(GameConstants.SCREEN_WIDTH/2, GameConstants.SCREEN_HEIGHT/2, 90), new Vector2D(90, 1));
    
    for(int i = 0; i < numAsteroids; i++)
    {
  	  Asteroid a = new Asteroid(AsteroidSize.MEDIUM);
   	  asteroids.add(a);
    }
    
    for(int i = 0; i < 100; i++)
    {
      stars.add(new Star());
    }
  }
  /**
   * creates an Asteroids game with number of asteroids set to 10.
   */
  public AsteroidsGame()
  {
	  this(10);
  }
  /**
   * Updates all GameElements.
   */
  public void update()
  {   
    if(!(lives.getValue() == 0))
    {
      ship.update();
	  
	  
      for(Saucer saucer : saucers)
      {
        saucer.update();
      }
	  
      for(Asteroid ast : asteroids)
      {
        ast.update();
      }
	  
      for(Bullet bullet : bullets)
      {
        bullet.update();
      }
	  
	  // bullet lifetime
      Iterator<Bullet> b = bullets.iterator();	  
      while(b.hasNext())
      {
        if(b.next().getTimer() == 20)
        {
          b.remove();
        }
      }
	  
	  // asteroids and bullet collision
      for(int i = 0; i < asteroids.size(); i++)
      {
        Asteroid asteroid = asteroids.get(i);
        for(int j = 0; j < bullets.size(); j++)
        {
          Bullet bullet = bullets.get(j);
          if(bullet.pose.distance(asteroid.pose) <= (bullet.getRadius() + asteroid.getRadius()))
          {
            score.setValue(score.getValue() + (int)asteroids.get(i).getPoints());
            bullets.remove(j);
            asteroids.remove(i);
          }
        }
      }

	  // saucer and bullet collision
      for(int i = 0; i < saucers.size(); i++)
      {
        Saucer saucer = saucers.get(i);
        for(int j = 0; j < bullets.size(); j++)
        {
          Bullet bullet = bullets.get(j);
          if(bullet.pose.distance(saucer.pose) <= (bullet.getRadius() + saucer.getRadius()))
          {
            score.setValue(score.getValue() + GameConstants.SAUCER_POINTS);
            bullets.remove(j);
            saucers.remove(i);
          }
        }
      }

	  // ship and asteroid collision
      Iterator<Asteroid> a = asteroids.iterator();
      while(a.hasNext())
      {
        if(a.next().checkCollision(ship))
        {
          a.remove();
          lives.setValue(lives.getValue()-1);
          ship = new Ship(new Pose(GameConstants.SCREEN_WIDTH/2, GameConstants.SCREEN_HEIGHT/2, 90), new Vector2D(90, 1));
        }
      }

	  // ship and saucer collision
      Iterator<Saucer> s = saucers.iterator();
      while(s.hasNext())
      {
        if(s.next().checkCollision(ship)) 
        {
          s.remove();
          lives.setValue(lives.getValue()-1);
          ship = new Ship(new Pose(GameConstants.SCREEN_WIDTH/2, GameConstants.SCREEN_HEIGHT/2, 90), new Vector2D(90, 1));
        }
      }
    }
  }
  
  /**
   * Draws all GameElements.
   */
  public void draw()
  {
	 
    if(!(lives.getValue()== 0))
    {

      StdDraw.setPenColor(StdDraw.PINK);
      

      if(StdDraw.hasNextKeyTyped()  && (StdDraw.nextKeyTyped() == ' '))
      {
        Bullet b = new Bullet(new Pose(ship.getX(), ship.getY(), ship.getHeading()),
    	           new Vector2D(ship.getHeading(), GameConstants.BULLET_SPEED));
        bullets.add(b);
      }

      for(Star s : stars)
	    {
	      s.draw();
	    }
      
	    for(Bullet bullet : bullets)
	    {
        bullet.draw();
	    }
	  
	    for(Asteroid ast : asteroids)
	    {
		    ast.draw();
	    }
	  
      if(asteroids.size() == 0)
      {
		    for(int i = 0; i < numAsteroids; i++)
		    {
		  	  Asteroid a = new Asteroid(AsteroidSize.MEDIUM);
		   	  asteroids.add(a);
		    }
		    for(Asteroid ast : asteroids)
		    {
			    ast.draw();
		    }
      }
      ship.draw(); 
      
      
      if(Math.random() * 100 <= .3)
      {
        saucers.add(new Saucer());
      }
    
      for(Saucer s : saucers)
      {
        s.draw();
      }
    
      
      score.draw();
      lives.draw(); 
    } else
    {
      endGame();
    }
  }
  /**
   * Ends the game.
   */
  public void endGame()
  {
    //StdDraw.text(GameConstants.SCREEN_WIDTH/2, GameConstants.SCREEN_HEIGHT/2, "Game Over"); 
  }
  

}
