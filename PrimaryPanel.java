import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PrimaryPanel extends JPanel
{
	
	//2.declasration of listener object
	public BtnListener btnL;
	public MListener mouseL;
	
	public FarmPanel f1;
	public DayTimePanel d1;
	public NightTimePanel n1;

	
	public JButton SheepColor;

	public PrimaryPanel()
	{
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(750,700));
		setLayout(null);
		
		
		
		f1 = new FarmPanel();
		d1 = new DayTimePanel();
		n1 = new NightTimePanel();
		
		
		add(f1);
		add(d1);
		add(n1);
		
		f1.setBounds(0,0,750,700);
		d1.setBounds(0,0,750,700);
		n1.setBounds(0,0,750,700);
		//2. creation of listener object
		btnL = new BtnListener();
		mouseL = new MListener();
		
		//3. add listener object to the component
		f1.btnStartSheep1.addActionListener(btnL);
		f1.btnStartSheep2.addActionListener(btnL);
		f1.btnStartSheep3.addActionListener(btnL);
		d1.btn_farmer.addActionListener(btnL); 
	
		addMouseListener(mouseL);
		
		
		f1.setVisible(true);
		d1.setVisible(false);
	
		n1.setVisible(false);
		
		ChangeDay c = new ChangeDay(d1,n1);
		c.start();
	
	}
	
	public int getSheepColor()
	{
		if ( SheepColor == f1.btnStartSheep1 )
			return 1;
		else if ( SheepColor == f1.btnStartSheep2 )
			return 2;
		else
			return 3;
	}
	
	
	private class BtnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//4. event handling
			Object obj = event.getSource();
			
			if ( obj == f1.btnStartSheep1 )
			{
				f1.setVisible(false);
				d1.setVisible(true);
			    d1.myThreadStart();
			    d1.setSheepType(1);
				
			
		
				}
			else if ( obj == f1.btnStartSheep2 )
			{
				f1.setVisible(false);
				d1.setVisible(true);
				d1.myThreadStart();
				d1.setSheepType(2);
				
				
			}
			else
			{
				f1.setVisible(false);
				d1.setVisible(true);
				d1.myThreadStart();
				d1.setSheepType(3);
				
					
			}
			
			
			
			
			if ( obj == n1.btnWolf )
			{
				n1.setVisible(false);
				d1.setVisible(true);	
			}		

			
		
		}	//actionPerformed	
	}	//BtnListener 
	
	private class MListener implements MouseListener
	{
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseClicked(MouseEvent event)
		{
						
	}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event)
		{
	
		}	//actionPerformed	
	}	//BtnListener	
		
}//primarypanel

class ChangeDay extends Thread implements Runnable
{
	
	DayTimePanel d;
	NightTimePanel n;
	
	public ChangeDay(DayTimePanel d1, NightTimePanel n1)
	{
		d=d1;
		n=n1;
		d.setVisible(true);
		n.setVisible(false);
	}
	
	public void run()
	{
		try
		{
			sleep(3000);				
			d.setVisible(false);
			n.setVisible(true);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
		

