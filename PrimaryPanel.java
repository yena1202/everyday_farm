//////////////////////////////////////////////////////////////////////////////
///////첫 화면에서 양을 고르는 순간부터 일정 시간 이후 밤화면으로 자동 전환 되게 해주는 패널 ///////
/////////////////////////////////////////////////////////////////////////////
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PrimaryPanel extends JPanel
{
	//declasration of listener object
	public BtnListener btnL;

	public DayTimePanel d1;
	public NightTimePanel n1;

	public PrimaryPanel()
	{
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(750,700));
		setLayout(null);

		d1 = new DayTimePanel();
		n1 = new NightTimePanel();
		
		add(d1);
		add(n1);
		
		d1.setBounds(0,0,750,700);
		n1.setBounds(0,0,750,700);
		
		//creation of listener object
		btnL = new BtnListener();
		
		//add listener object to the component
		n1.Wolf.addActionListener(btnL);
		d1.btnStartSheep1.addActionListener(btnL);
		d1.btnStartSheep2.addActionListener(btnL);
		d1.btnStartSheep3.addActionListener(btnL);
		
		d1.FarmPanel.setVisible(true);
		d1.DayPanel.setVisible(false);
		n1.setVisible(false);
	} //constructor
	
	private class BtnListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//event handling
			Object obj = event.getSource();
			
			//ChangeDay (per 30 seconds)
			if ( obj == d1.btnStartSheep1 )
			{
				ChangeDay c = new ChangeDay(d1,n1);
				c.start();
			}
			else if ( obj == d1.btnStartSheep2 )
			{
				ChangeDay c = new ChangeDay(d1,n1);
				c.start();
			}
			else
			{
				ChangeDay c = new ChangeDay(d1,n1);
				c.start();
			}
			
			//늑대가 나타난다.
			if ( obj == n1.Wolf )
			{
				n1.setVisible(false);
				d1.setVisible(true);	
			}	
		}	//actionPerformed	
	}	//BtnListener 	
		
}//primarypanel

////////////////////////////////////////////////////////////////////
///////////낮 화면에서 일정시간 이후 밤 화면으로 바뀌게 해주는 Thread//////////
////////////////////////////////////////////////////////////////////
class ChangeDay extends Thread implements Runnable
{
	DayTimePanel d;
	NightTimePanel n;
	
	public ChangeDay(DayTimePanel d1, NightTimePanel n1)
	{
		d=d1;
		n=n1;
		d1.DayPanel.setVisible(true);
		n1.setVisible(false);
	}
	
	public void run()
	{
		try
		{
			sleep(15000);				
			d.DayPanel.setVisible(false);
			n.setVisible(true);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}//ChangeDay Thread