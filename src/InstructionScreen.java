import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class InstructionScreen extends JFrame implements KeyListener{
	private MainScreen MS;

	Label info = new Label("Instructions");
	
	JLabel arrows = new JLabel();
	Label arrowsInfo = new Label("Use your arrow keys to move Frogger");
	
	JLabel grass = new JLabel();
	Label grassInfo = new Label("And remember, the grass are safe zones!");
	
	JLabel car = new JLabel();
	Label carInfo = new Label("Avoid getting squished by the cars");
	
	JLabel LPad = new JLabel();
	Label LPadInfo = new Label("Try to reach all 5 lily pads before dying");
	
	JLabel enter = new JLabel();
	Label enterInfo = new Label("Press Enter to begin. Have fun and good luck!");
	
	Label toKnow = new Label("Things to Know");
	
	Label toKnowinfo1 = new Label("You have 5 lives");
	Label toKnowinfo2 = new Label("Every car hit loses you 1500 points");
	Label toKnowinfo3 = new Label("Every lily pad reached grants you 10000 points");
	Label toKnowinfo4 = new Label("Every time you reach a lily pad, car speed increases");
	Label toKnowinfo5 = new Label("Can YOU make your name in to the Hall of Fame?");
	
	Label soundInfo = new Label("And remember to TURN YOUR SPEAKERS UP!");
	
	//Spacers to hold structure of GridLayout for items with only one thing on row
	Label spacer = new Label("");
	Label spacer2 = new Label("");
	Label spacer3 = new Label("");
	Label spacer4 = new Label("");
	Label spacer5 = new Label("");
	Label spacer6 = new Label("");
	Label spacer7 = new Label("");
	
	
	public InstructionScreen(MainScreen ms){
		MS = ms;
		setTitle("Welcome to Frogger by Anthony Mascia");
		setLayout(new GridLayout(13, 2));
		addKeyListener(this);
		
		info.setFont(new Font ("Serif", Font.BOLD, 20));
		soundInfo.setFont(new Font ("Serif", Font.BOLD, 15));
		toKnow.setFont(new Font ("Serif", Font.BOLD, 20));
		
		add(info); add(spacer);
		
		add(arrowsInfo);
		arrows.setIcon(new ImageIcon("arrowkeys.png"));
		add(arrows);
		
		add(carInfo);
		car.setIcon(new ImageIcon("car.gif"));
		add(car);
		
		add(LPadInfo);
		LPad.setIcon(new ImageIcon("lpad.gif"));
		add(LPad);
		
		add(grassInfo);
		grass.setIcon(new ImageIcon("grass.jpg"));
		add(grass);
		
		add(enterInfo);
		enter.setIcon(new ImageIcon("enterkey.png"));
		add(enter);
		
		add(toKnow); add(spacer2);
		
		add(toKnowinfo1);add(spacer3);
		add(toKnowinfo2);add(spacer4);
		add(toKnowinfo3);add(spacer5);
		add(toKnowinfo4);add(spacer6);	
		add(toKnowinfo5);add(spacer7);	
		add(soundInfo);
		

		pack();
		setLocationRelativeTo(null);
	}
	
	

	//Get rid of instruction screen when user presses enter, then show main screen
	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER){
			super.dispose();
			MS.setVisible(true);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) { }


	@Override
	public void keyTyped(KeyEvent e) { }

}
