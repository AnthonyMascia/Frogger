import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	
	public static void main(String[] args) {
		
		World w = new World(); //Model
		
		Screen s = new Screen(w); //View (based on the world(w))
		MainScreen ms = new MainScreen(s); //Frame that holds Screen and lives/score labels
		ms.addWindowListener(new Closer()); //Makes "x" terminate program
		
		InstructionScreen ic = new InstructionScreen(ms);
		ic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closer
		
		StartScreen sc = new StartScreen(ic); //Frame that will display at start, passes through MainScreen to set it visible when Enter is pressed
		sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closer
		
		ScoreList sl = new ScoreList(); //Class that holds all made up names and scores
		sl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closer
		
		GameOverScreen gm = new GameOverScreen(sl); //Frame that displays user's final score to submit to ScoreList
		gm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closer
		
		BackgroundMusic music = new BackgroundMusic(); //Music that will play in the background
		music.start(); //Begin the music/loop until program executed
		
		sc.setVisible(true); // Begin by setting the Start Screen to visible

		
		
		//Keyboard controller for Frogger
		s.addKeyListener(new Controller(w));
		
		//Time Controller, while user still has lives or still has lily pads to reach
		while(!w.gameOver()){
			//Constantly update life and score display
			ms.lifeNotification.setText("LIVES: " + w.lives);
			ms.score.setText("SCORE: " + World.score);
			
			//For each car in arraylist Cars, all function to move cars to constantly
			//keep cars moving while user still has lives or lily pads to reach
			for(Cars car : w.cars){
			w.moveCar(car);
			}
			
			//Constantly repaint screen to update world as objects move
			w.advanceTime();
			s.repaint();
			
			
			
			
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		//When user loses or wins, completely dispose of the main screen and set the GameOverScreen to true so user
		//can enter name and submit their final score which will then be sent to the Highscore List
		ms.dispose();
		ms = null;
		
		int playerScore = World.score;
		gm.endScore.setText("Final Score: " + playerScore); //Displays user's final score to label in GameOverScreen
		gm.setVisible(true);
		
		//Add user and his score to highscore list
		Score you = new Score("YOU", playerScore);
		sl.scores.add(you);
		
		//Create a temporary "score" for bubble sort
		Score temp = new Score("", 0);
		sl.scores.add(temp);
		
		//Rename size of score list for convenience
		int scoreSize = sl.scores.size();
		
		
		//Bubblesort to sort all player scores so they display in descending order
		//Also puts user's score in correct place on score list
		for(int i = 0; i < scoreSize; i++){
			for(int j = 1; j < scoreSize - i; j++){
				if(sl.scores.get(j-1).s < sl.scores.get(j).s){
					temp.s = sl.scores.get(j-1).s;
					temp.n = sl.scores.get(j-1).n;
					
					sl.scores.get(j-1).s = sl.scores.get(j).s;
					sl.scores.get(j-1).n = sl.scores.get(j).n;
					
					sl.scores.get(j).s = temp.s;
					sl.scores.get(j).n = temp.n;
				}
			}
		}
		
		//After loop is done, remove temp so it does not appear on highscore list
		sl.scores.remove(temp);
		
		//Finally display all scores in correct order on highscore list
		int count = 1;
		for(Score x : sl.scores){
			 sl.add(new JLabel(count + ": " + x.n + ": " + x.s));
			 count++;
		}
		//Self explanatory/fact of life
		sl.add(new JLabel("10: Justin Bieber: Crashed Game With Score of Negative Infinite"));
	}

}
