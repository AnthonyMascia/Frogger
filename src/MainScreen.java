import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

//Class that contains the main game screen, lives, and score
@SuppressWarnings("serial")
public class MainScreen extends Frame{
	//Make labels to display score and lives left
	Label lifeNotification = new Label();
	Label score = new Label();
	
	public MainScreen(Screen s){
		super("Welcome to Frogger by Anthony Mascia");
		setLayout(new BorderLayout());
		lifeNotification.setBackground(Color.black);
		lifeNotification.setForeground(Color.WHITE);
		lifeNotification.setFont(new Font("Serif", Font.PLAIN, 30));
		score.setBackground(Color.black);
		score.setForeground(Color.WHITE);
		score.setFont(new Font("Serif", Font.PLAIN, 30));
		
		//Add all three elements in a BorderLayout
		add(score, BorderLayout.NORTH);
		add(s, BorderLayout.CENTER);
		add(lifeNotification, BorderLayout.SOUTH);
		pack();
		//Center frame to center of screen
		setLocationRelativeTo(null);
	}

}
