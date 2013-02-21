import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class ScoreList extends JFrame{
	
	//Declare a new arraylist of Score to hold scores of user and other made up scores
	ArrayList<Score>scores = new ArrayList<Score>();
	
	//Add made up names and scores
	Score one = new Score("Chuck Norris", 49130);
	Score two = new Score("David Hassalhoff", 41420);
	Score three = new Score("Howard Stern", 35125);
	Score four = new Score("Beethoven", 31674);
	Score five = new Score("MLK Jr", 24543);
	Score six = new Score("Mr. Rogers", 20230);
	Score sev = new Score("Oprah Winfrey", 11533);
	Score eight = new Score("Obama", 7021);
	JLabel scoreInfo = new JLabel("Name: Score");
	
	public ScoreList(){
		setTitle("Hall of Fame");
		setLayout(new GridLayout(11, 1));
		
		scoreInfo.setFont(new Font ("Serif", Font.BOLD, 20));
		add(scoreInfo);
			scores.add(one);scores.add(two);scores.add(three);
			scores.add(four);scores.add(five);scores.add(six);
			scores.add(sev);scores.add(eight);

			
		setSize(430,600);
		setLocationRelativeTo(null);
	}

	
	

}