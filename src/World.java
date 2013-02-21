import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class World {
		//Movement assigned to numbers to make it easier to set movement of different objects
		//instead of having to memorize each numbers' direction
		public final static int STILL = 0, UP = 1, RIGHT = 2, DOWN = 3, LEFT =4;
		
		//Set starting positions for all left and right moving cars, as well as Frogger
		float rightCarPosX = 1;
		float rightCarPosY = 18;
		float leftCarPosX = 35;
		float leftCarPosY = 17;
		float froggerPosX = 18;
		float froggerPosY = 20;
		
		//Set minimum and maximum speed for cars
		//These will later increase after every lily pad reached
		double carSpeedMIN = .150;
		double carSpeedMAX = .320;
		
		int lives = 5;
		int lilypadsremaining = 5;
		
		//Make score static so it can be accessed by Main()
		static int score = 0;
		
		//Create random variables to be put in to both random size function and random color function
		//to later set a random color and size to each individual car
		Random carColorGen = new Random();
		Random carSizeGen = new Random();
		
		//Add sounds to play at certain times
		SquishSound squish = new SquishSound();
		HopSound hop = new HopSound();
		ScoreSound level = new ScoreSound();
		
		//Create FROGGER, set him at starting x and y position
		//Set his direction so he does not move
		//Set speed so he moves right amount of space after every hop
		Frogger frogger = new Frogger(froggerPosX, froggerPosY, STILL, .10);
		
		
		//Create array list for all cars
		ArrayList<Cars> cars = new ArrayList<Cars>();
		
		//Create RIGHT MOVING cars, modify all Y coordinates so they are two spaces apart
		Cars car1 = new Cars(rightCarPosX, rightCarPosY, RIGHT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car3 = new Cars(rightCarPosX, rightCarPosY-2, RIGHT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car5 = new Cars(rightCarPosX, rightCarPosY-4, RIGHT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car7 = new Cars(rightCarPosX, rightCarPosY-6, RIGHT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car9 = new Cars(rightCarPosX, rightCarPosY-10, RIGHT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car11 = new Cars(rightCarPosX, rightCarPosY-12, RIGHT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car13 = new Cars(rightCarPosX, rightCarPosY-14, RIGHT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car15 = new Cars(rightCarPosX, rightCarPosY-16, RIGHT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		
		//Create LEFT MOVING cars, modify all Y coordinates so they are two spaces apart
		Cars car2 = new Cars(leftCarPosX, leftCarPosY, LEFT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car4 = new Cars(leftCarPosX, leftCarPosY-2, LEFT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car6 = new Cars(leftCarPosX, leftCarPosY-4, LEFT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car8 = new Cars(leftCarPosX, leftCarPosY-6, LEFT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car10 = new Cars(leftCarPosX, leftCarPosY-10, LEFT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car12 = new Cars(leftCarPosX, leftCarPosY-12, LEFT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car14 = new Cars(leftCarPosX, leftCarPosY-14, LEFT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		Cars car16 = new Cars(leftCarPosX, leftCarPosY-16, LEFT,
							randomSpeed(carSpeedMIN,carSpeedMAX), getRandomColor(), getRandomCarSize());
		

		
		//Initialize tick to start at 0
		public float time = 0;
		
		//Draw world with characters
		private String startboard = 
		 "######o#####o#####o#####o#####o######\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#___________________________________#\n"
		+"#___________________________________#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#...................................#\n"
		+"#___________________________________#\n"
		+"#___________________________________#\n"
		+"#####################################";
	
	private ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>();
	public int nextDirection = STILL;	

	//Constructor
	public World(){
		String[] rows = startboard.split("\n");
		for(String row : rows){
			ArrayList<Character> newrow = new ArrayList<Character>();
			for(int i = 0; i < row.length(); i++)
				newrow.add(row.charAt(i));
			board.add(newrow);
		}
		
		//Add right moving cars to array list Cars
		cars.add(car1);cars.add(car3);cars.add(car5);cars.add(car7);
		cars.add(car9);cars.add(car11);cars.add(car13);cars.add(car15);
		//Add left moving cars to array list Cars
		cars.add(car2);cars.add(car4);cars.add(car6);cars.add(car8);
		cars.add(car10);cars.add(car12);cars.add(car14);cars.add(car16);
		
		
	} //End Constructor
	
	
	
	//Get height of the board
	public int height() {
		return board.size();
	}//end height()
	
	//Get width of the board
	public int width() {
		return board.get(0).size();
	}//end width()
	
	//Get function to get the location of a tile on the board
	public Character get(int x, int y) {
		return board.get(y).get(x);
	}//end get()
	
	//Set function to change a given tile to a different tile
	private void set(int x, int y, Character c) {
		board.get(y).set(x, c);
	}//end set()
	
	//When gameOver() is true, the program executes
	//Game will execute when player runs out of lives are successfully reaches all lily pads
	public boolean gameOver(){
		if(lives > 0){
			if(lilypadsremaining > 0)
			return false;
			else
				return true;
		}
		else
			return true;
		
	}// end gameOver()
	
	// Function that gives a random speed to each car determined by the variables
	// carSpeedMIN ad carSpeedMAX
	public double randomSpeed(double min, double max) { 
		double RandomSpeed;
		RandomSpeed = min + (Math.random() * ((max - min)));
		return RandomSpeed;
	 }//end  randomSpeed()
	
	// This will generate a random color on the RGB color spectrum to be assigned to each
	// individual car
	public Color getRandomColor() {
	     return new Color(carColorGen.nextInt(256), carColorGen.nextInt(256), carColorGen.nextInt(256));
	}// end getRandomColor()
	
	// Function that gives each individual car a random size between a width of 70 and 130
	// Makes things less boring for player
	public int getRandomCarSize(){
		int randomSize;
		randomSize = carSizeGen.nextInt(130-70) + 70;
		return randomSize;
	}//end getRandomCarSize()
	
	public void advanceTime(){
		time += .1;
		//Collision: this keeps track of Frogger's coordinates on the board
		int x = Math.round(frogger.x);
		int y = Math.round(frogger.y);
		
		

		
		
		/*When Frogger lands on a lily pad, remove it and set wall there instead
		 * Also give player points and increase speed of cars by increasing both min
		 * and max variables
		 */
		if(get(x,y) == 'o'){
			level.start();
			lilypadsremaining--;
			frogger.x = froggerPosX;
			frogger.y = froggerPosY;
			frogger.dir = STILL;
			set(x, y, '#');
			score += 10000;
			carSpeedMIN += .150;
			carSpeedMAX += .150;
		}
		
		
		
		/*Car collision code
		If Frogger's x and y coordinate is in the vicinity of any of the car's
		x and y coordinate, Frogger will return to starting position and lose a life and points*/
		for(int i = 0; i < cars.size(); i++){
			if((frogger.x >= cars.get(i).x-.80 && frogger.x <= cars.get(i).x+2.2) &&
			   (frogger.y >= cars.get(i).y-.80 && (int)frogger.y <= (int)cars.get(i).y)){
					squish.start();
					lives--;
					score -= 1500;
					frogger.x = froggerPosX;
					frogger.y = froggerPosY;
					frogger.dir = STILL;
			}
		}
		
		
		
		
		
		
		/*If Frogger reaches a '#' tile (or wall), set Frogger's position to still
		so user cannot hop off screen*/
		if(Math.abs(x - frogger.x) < .1 && Math.abs(y- frogger.y) < .1){
			frogger.dir = nextDirection;
			if(frogger.dir == RIGHT && get(x+1, y) == '#')
				frogger.dir = STILL;
			if(frogger.dir == LEFT && get(x-1, y) == '#')
				frogger.dir = STILL;
			if(frogger.dir == UP && get(x, y-1) == '#')
				frogger.dir = STILL;
			if(frogger.dir == DOWN && get(x, y+1) == '#')
				frogger.dir = STILL;	
		}
		
		
		
		
		/*If statements to control Frogger's movement speed and position
		he goes when an arrow key is pressed. The speed is at .50 because it
		is the perfect speed for the board so when a user presses an arrow key,
		that he does not jump more than one space, thus hitting a car*/
		if(frogger.dir == UP){
			frogger.y -= .50;
			nextDirection = STILL;
			score += 15;
			hop.start(); //Play hopping sound every time user moves Frogger(hits a key)
		}
		if(frogger.dir == RIGHT){
			frogger.x += .50;
			nextDirection = STILL;
			hop.start();
		}
		if(frogger.dir == DOWN){
			frogger.y += .50;
			nextDirection = STILL;
		    score -= 15;
		    hop.start();
		}
		if(frogger.dir == LEFT){
			frogger.x -= .50;
			nextDirection = STILL;
			hop.start();
		}
	
		
		
	} //End advanceTime()
	
	/*Functions to move both left and right moving cars
	These functions also contain code for continuous movement
	by when the coordinate of a car reaches the '#' tile
	that they will return to their starting position and keep going*/
	public void moveCar(Cars car){
		if(car.dir==RIGHT){
			time += .1;
			car.x += car.randSpeed;
			if(get((int)car.x+1, (int)car.y) == '#'){
				car.x = rightCarPosX;
				car.dir = RIGHT;
				car.randSpeed = randomSpeed(carSpeedMIN,carSpeedMAX);
			}
		}
		if(car.dir==LEFT){
			time -= .1;
			car.x -= car.randSpeed;
			if(get((int)car.x+1, (int)car.y) == '#'){
				car.x = leftCarPosX;
				car.dir = LEFT;
				car.randSpeed = randomSpeed(carSpeedMIN,carSpeedMAX);
			}
		}
	}//End moveCar()

		
}
