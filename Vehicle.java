package traffic;

import java.awt.Graphics;

public class Vehicle {

	int x;
	int y;
	int width=0;
	int height=0;
	double speed=0;
	double accel; 
	public Vehicle(int newx, int newy) {
		x=newx;
		y=newy;
	}
	public void paintMe(Graphics g) {

	}
	//get x position
	public int getX() {
		return x;
	}
	//set x position

	public void setX(int newx) {
		x = newx;
	}
	//set y position

	public void setY(int newy) {
		 y = newy;
	}
	//get speed position

	public double getSpeed() {
		return speed;
	}
	//get y position

	public int getY() {
		return y;
	}
	//get width

	public int getWidth() {
		return width;
	}

}
