import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class StartScreen extends JFrame implements KeyListener{
	private InstructionScreen IC;
	JLabel imageDisplayer = new JLabel();
	Label start = new Label("Press ENTER to view instructions");
	
	public StartScreen(InstructionScreen ic){
		IC = ic;
		setTitle("Welcome to Frogger by Anthony Mascia");
		setLayout(new BorderLayout());
		addKeyListener(this); //KeyListener to validate when user presses "Enter" to start game
		start.setBackground(Color.black);
		start.setForeground(Color.WHITE);
		start.setFont(new Font("Serif", Font.PLAIN, 35));
		//Add Frogger picture
		imageDisplayer.setIcon(new ImageIcon("frogger.jpg"));
		add(imageDisplayer, BorderLayout.NORTH);
		validate();
		add(start, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
	}
	
	

	//Get rid of start screen when user presses enter, then show instruction screen
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER){
			super.dispose();
			IC.setVisible(true);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { }


	@Override
	public void keyTyped(KeyEvent e) { }

}
