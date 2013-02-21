import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Constructor
public class Controller implements KeyListener {
	//Declare variable for model
	private World FWORLD;
	
	//Implement the model
	public Controller(World w) {
		FWORLD = w;
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		int code = ke.getKeyCode();
		//Make Frogger move in a direction according to which arrow key is pressed/held
		if(code == KeyEvent.VK_LEFT){
			FWORLD.nextDirection = World.LEFT;
		}
		else if(code == KeyEvent.VK_RIGHT){
			FWORLD.nextDirection = World.RIGHT;
		}
		else if(code == KeyEvent.VK_DOWN){
			FWORLD.nextDirection = World.DOWN;
		}
		else if(code == KeyEvent.VK_UP){
			FWORLD.nextDirection = World.UP;
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
			//Make Frogger move as long as key is pressed or held down, when released
			//make him stop so he doesnt keep moving
			FWORLD.nextDirection = World.STILL;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
