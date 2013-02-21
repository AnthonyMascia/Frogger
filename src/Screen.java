import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


@SuppressWarnings("serial")
public class Screen extends Canvas{
	
	//Declare the size of each tile
	final private int T = 30;
	Color froggerGreen = new Color(37, 118, 33);
	
	private World world;
	private int width,height;
	

	 
	public Screen(World w){
		world = w;
		height = world.height();
		width = world.width();
		setSize(T*width, T*height);
	}
	
	//Create a buffered image to draw the game board so when frogger or cars/logs move, repaint
	//does not repaint the entire board along with the moving objects
	public void update(Graphics g){
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g2 = image.getGraphics();
		paint(g2);
		g.drawImage(image, 0, 0, null);
	}
	
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				Character tile = world.get(x,y);
				switch(tile){
					//Make all '#' act as walls
					case '#':
						g.setColor(Color.black);
						g.fillRect(x*T, y*T, T, T);
						break;
					//Make all '.' act as the road
					case '.':
						g.setColor(Color.GRAY);
						g.fillRect(x*T, y*T, T, T);
						break;
					//Make all "_" act as grass
					case '_':
						g.setColor(Color.GREEN);
						g.fillRect(x*T, y*T, T, T);
						break;
					//Make all 'o' act as lily pads
					case 'o':
						g.setColor(Color.green);
						g.fillOval(x*T, y*T, T, T);
						break;
					//If a character is declared in world that is not any of the characters above
					//print out message that gives me the character entered that does not do anything
					default:
						System.out.println("Ivalid tile: " + tile);
				}
			}
		}

		//Draw cars with For-Each loop
		for(Cars car : world.cars){
			g.setColor(car.randColor);
			g.fillRect((int)(car.x*T), (int)(car.y*T), car.randSize, T);
		}
		

		
		
		//Draw Frogger
		g.setColor(froggerGreen);
		g.fillRect((int)(world.frogger.x*T), (int)(world.frogger.y*T), T, T);
		
		
}}
