package traffic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Sports extends Vehicle{
	Image myimage;
	final int MAX_SPEED = 12;

	public Sports(int newx, int newy) {
		super(newx, newy);
		//sports width height and speed

		width = 130;
		height =15;
		speed = 1;
		accel = 0.02;
		try {
			//import car function
		myimage = ImageIO.read(new File("BestSportsCar.PNG"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void paintMe(Graphics g) {
		/*
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		*/
		//acceleration
		if(speed <=MAX_SPEED) {
			speed+=accel;
		}
		//draw car
		g.drawImage(myimage, x-75, y-50, null);
	}

}
