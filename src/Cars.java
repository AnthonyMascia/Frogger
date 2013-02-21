import java.awt.Color;


public class Cars {
	float x, y; //x and y position of each car
	int dir; //direction of each car
	double randSpeed; //speed of each car
	Color randColor; //color of each car
	int randSize; //size of each car
	public Cars(float carStartX, float carStartY, int direction,
			    double speed, Color color, int size) {
		x = carStartX;
		y = carStartY;
		dir = direction;
		randSpeed = speed;
		randColor = color;
		randSize = size;
	}

}