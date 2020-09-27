import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;


public class NightTimePanel extends JPanel
{
	//data
	public JButton btnWolf;	//start button.
	private JPanel NightPanel;
	
	private int x,y;	//���� ��ġ ��ǥ.
	
	public WolfListener wolfL;	//Move Thread ����.
	
	public Move Wolf;	//Move Thread
	
	
	//method	
	public NightTimePanel()
	{
		setBackground(Color.white); //����
		setPreferredSize(new Dimension(750,700));
		setLayout(null);
		
		wolfL = new WolfListener();
	
		x = 0;
		y = 0;
		
		NightPanel =new JPanel();
		NightPanel.setBackground(Color.black); // ����
		NightPanel.setBounds(0,0,750,700);
		NightPanel.setLayout(null);
		add(NightPanel);	
			
		Wolf = new Move(x,y,350,300);
		Wolf.setBounds(0,0,350,300);
		Wolf.setOpaque(false);
		Wolf.setContentAreaFilled(false);
		Wolf.setBorderPainted(false);
		NightPanel.add(Wolf);
			
		btnWolf = new JButton(new ImageIcon("images/start.png")); //���븦 �����̰� �ϴ� ��ư.
  		btnWolf.setBounds(210,280,300,200);
  		btnWolf.setOpaque(false);
		btnWolf.setContentAreaFilled(false);
		btnWolf.setBorderPainted(false);
  		btnWolf.addActionListener(wolfL); 
		NightPanel.add(btnWolf);
	} //constructor
	
	private class WolfListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Wolf.start();
			btnWolf.setVisible(false);
		} //actionPerformed 
		
	} //WolfListener class

} //NightTimePanel class