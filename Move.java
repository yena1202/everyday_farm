///////////////////////////////////////////////////////
///////////늑대가 자유롭게 움직일 수 있도록 함 ////////
///////////////////////////////////////////////////////
import java.awt.*;
import javax.swing.*;

public class Move extends JButton implements Runnable
{
	private int x,y,w,h;
	private Thread myThread1;

	private JLabel lblwolf;
	
	public Move(int px, int py,int width,int height){
		
		JLabel lblwolf = new JLabel(new ImageIcon("images/wolf.png"));
		x = px;
		y = py;
		w = width;
		h = height;
		myThread1 = null;
		add(lblwolf);
	} //Constructor
	
	public void start() {
		if (myThread1 == null) {
			myThread1 = new Thread(this);
			myThread1.start();
		}
		else myThread1.start();
	} //start
	
	public void stop() {
		if (myThread1 != null) myThread1.stop();
	} //stop
	
	public void run() {
	    
		  try {
		      while(true) {
		      	myThread1.sleep(600);
		      	x = (int)(Math.random()*500)+100;
				y = (int)(Math.random()*400)+200;
				setBounds(x,y,w,h);
		      }
		     } catch(Exception e) {}
	} //run
} //Move class