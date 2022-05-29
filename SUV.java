package traffic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class SUV extends Vehicle{
	Image myimage;
	final int MAX_SPEED = 9;

	public SUV(int newx, int newy) {
		super(newx, newy);
		//SUV width height and speed
		width = 150;
		height =32;
		speed = 1;
		accel = (double)0.015;

		try {
			//import the image
		myimage = ImageIO.read(new File("BestSuvCar.PNG"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void paintMe(Graphics g) {
		/*
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);*/
		//acceleration
		if(speed <= MAX_SPEED) {
			speed+=accel;
		}
		//draw car
		g.drawImage(myimage, x-75, y-60, null);
		

	}

}
