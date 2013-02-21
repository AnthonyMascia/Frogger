
public class Frogger {
	float x, y; //Frogger's x and y position
	int dir; //direction
	double frogSpeed; //how much Frogger moves on a key press
	public Frogger(float FroggerStartX, float FroggerStartY, int direction, double speed) {
		x = FroggerStartX;
		y = FroggerStartY;
		dir = direction;
		frogSpeed = speed;
	}

}
