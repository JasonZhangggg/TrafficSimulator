package traffic;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class traffic implements ActionListener, Runnable {
	JFrame frame = new JFrame("Traffic Simulator");
	Road road = new Road();
	// south container
	//start stop buttons
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	Container south = new Container();
	JLabel throughput  = new JLabel("Thoughput: 0");
	// west container
	//all the cars
	JButton semi = new JButton("Add Semi");
	JButton suv = new JButton("Add SUV");
	JButton sports = new JButton("Add Sports");
	Container west = new Container();

	boolean running = false;
	int carCount = 0;
	long startTime= 0;
	public traffic() {
		//create border layout and add the road
		frame.setSize(1000, 550);
		frame.setLayout(new BorderLayout());
		frame.add(road, BorderLayout.CENTER);
		//create the grid layout and add the buttons
		south.setLayout(new GridLayout(1, 3));
		south.add(start);
		start.addActionListener(this);
		south.add(stop);
		stop.addActionListener(this);
		south.add(throughput);
		frame.add(south, BorderLayout.SOUTH);
		//create another grid layout and add the car buttons
		west.setLayout(new GridLayout(3, 1));
		west.add(semi);
		semi.addActionListener(this);
		west.add(suv);
		suv.addActionListener(this);
		west.add(sports);
		sports.addActionListener(this);
		frame.add(west, BorderLayout.WEST);
 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
/*
		Semi testSemi = new Semi(10, 20);
		road.addCar(testSemi);
		SUV testSUV = new SUV(10, 170);
		road.addCar(testSUV);
		Sports testSport = new Sports(10, 320);
		road.addCar(testSport);
*/
		frame.repaint();
	}

	public static void main(String args[]) {
		new traffic();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		//if the semi button is pressed, add a semi in
		if (event.getSource().equals(semi)) {
			//draw the semi
			Semi semi = new Semi(0, 20);
			road.addCar(semi);
			//make sure you are not placing a car in another one
			for (int x = 0; x < road.ROAD_WIDTH; x += 20) {
				for (int y = 40; y < 480; y += 120) {
					semi.setX(x);
					semi.setY(y);
					if(road.collision(x, y, semi) == false) {
						frame.repaint();
						return;
					}
				}
			}
		}
		//if the sports button is pressed, add a sports in
		if (event.getSource().equals(sports)) {
			//draw the sports
			Sports sports = new Sports(0, 20);
			road.addCar(sports);
			//make sure you are not placing a car in another one
			for (int x = 0; x < road.ROAD_WIDTH; x += 20) {
				for (int y = 40; y < 480; y += 120) {
					sports.setX(x);
					sports.setY(y);
					if(road.collision(x, y,  sports) == false) {
						frame.repaint();
						return;
					}
				}
			}
		}
		//if a suv button is pressed, add a suv
		if (event.getSource().equals(suv)) {
			//draw the suv
			SUV suv = new SUV(0, 20);
			road.addCar(suv);
			//make sure you are not placing a car in another one
			for (int x = 0; x < road.ROAD_WIDTH; x += 20) {
				for (int y = 40; y < 480; y += 120) {
					suv.setX(x);
					suv.setY(y);
					if(road.collision(x, y, suv) == false) {
						frame.repaint();
						return;
					}
				}
			}
		}
		//if the start button is pressed
		if (event.getSource().equals(start)) {
			//if not running already
			if (running == false) {
				running = true;
				//start counting the time
				road.resetCarCount();
				startTime = System.currentTimeMillis();
				Thread t = new Thread(this);
				t.start();
			}
		}
		if (event.getSource().equals(stop)) {
			running = false;
		}
	}

	@Override
	public void run() {
		//if running is true, which means start was pressed
		while (running == true) {
			//take a step
			road.step();
			//add the throughput
			carCount = road.getCarCount();
			double throughputCalc = carCount/1000*(double)(System.currentTimeMillis() - startTime);
			throughput.setText("Throughput: "+throughputCalc);
			//repaint
			frame.repaint();
			try {
				Thread.sleep(15);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
