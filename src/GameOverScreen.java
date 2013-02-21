import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;


@SuppressWarnings("serial")
public class GameOverScreen extends JFrame implements ActionListener{
	private ScoreList sl; //New variable for class ScoreList
	Label endScore = new Label();
	Button submit = new Button("Submit to the Hall of Fame");
	
	
	public GameOverScreen(ScoreList s){
		sl = s;
		setTitle("Your Score");
		setLayout(new BorderLayout());
		
		endScore.setBackground(Color.black);
		endScore.setForeground(Color.white);
		endScore.setFont(new Font("Serif", Font.PLAIN, 20));
		
		submit.setBackground(Color.black);
		submit.setForeground(Color.red);
		submit.setFont(new Font("Serif", Font.PLAIN, 20));
		
		submit.addActionListener(this); //When submit is pressed, hides GameOverScreen, shows highscore list
		//Adjust layout of label/button
		add(endScore, BorderLayout.NORTH);
		add(submit, BorderLayout.CENTER);
		
		
		setSize(270,190);
		//Set to center of the screen
		setLocationRelativeTo(null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		sl.setVisible(true);
	}
	
	

}