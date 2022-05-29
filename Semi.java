package traffic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Semi extends Vehicle {
	Image myimage;
	final int MAX_SPEED = 6;

	public Semi(int newx, int newy) {
		super(newx, newy);
		//semi width height and speed
		width = 250;
		height =20;
		speed = 1;
		accel = (double)0.01;

		try {
			//import the image
		myimage = ImageIO.read(new File("BestSemiTruck.PNG"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void paintMe(Graphics g) {
		/*
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);*/
		//acceleration
		if(speed <=MAX_SPEED) {
			speed+=accel;
		}
		//draw the immage
		g.drawImage(myimage, x, y-65, null);

	}

}
