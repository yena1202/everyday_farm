import java.awt.*;
import javax.swing.*;

public class SheepThread extends JButton implements Runnable {
	
	public Thread myThread;
	public int delayTime,t;
	
	ImageIcon red1 = new ImageIcon("images/sheep1_red.png");
   	ImageIcon red2 = new ImageIcon("images/sheep2_red.png");
   	ImageIcon blue1 = new ImageIcon("images/sheep1_blue.png");
   	ImageIcon blue2 = new ImageIcon("images/sheep2_blue.png");
  	ImageIcon orange1 = new ImageIcon("images/sheep1_orange.png");
  	ImageIcon orange2 = new ImageIcon("images/sheep2_orange.png");
  	ImageIcon cow1 = new ImageIcon("images/cow.png");
  	ImageIcon cow2 = new ImageIcon("images/cow_2.png");
	


	   public SheepThread(int time, int num) {
      
      
      
      delayTime = time;
      t = num;
      
      if(t == 1)
      {
         setIcon(red1);
         setDisabledIcon(red1);

      }
      else if(t == 2)
      {
         setIcon(blue1);
         setDisabledIcon(blue1);
      }
      else if(t == 3)
      {
         setIcon(orange1);
         setDisabledIcon(orange1);
      }   
      else if(t == 4)
      {
         setIcon(cow1);
         setDisabledIcon(cow1);   
      }
      
      setEnabled(false);
      myThread = null;
   }
   
   public void start() {
      if (myThread == null) {
         myThread = new Thread(this);
         myThread.start();
      }
      
   }
   
   public void stop() {
      if (myThread != null) myThread.stop();
   }
   
   public void run() {
      try {
            // If you change image to continue, you can use while loop and set string strImage2
            myThread.sleep(delayTime);
      if(t == 1)
      {
         setIcon(red2);
      }
      else if(t == 2)
      {
         setIcon(blue2);
         
      }
      else if(t == 3)
      {
         setIcon(orange2);
         
      }
      else if(t == 4)
      {
         setIcon(cow2);
            
      }   
      
      setEnabled(true);
      } catch (Exception e) {}
         
   }
   
   public void reset() {
   	 
   
     if (myThread != null) {
      if(t == 1)
      {
      	System.out.println("reset1");
         setIcon(red1);
      }
      else if(t == 2)
      {
         setIcon(blue1);
         
      }
      else if(t == 3)
      {
         setIcon(orange1);
         
      }
      else if(t == 4)
      {
         setIcon(cow1);
            
      }   
      
  }
  myThread = new Thread(this);
  myThread.start();
  
  
  
   		 	
   }//reset
}