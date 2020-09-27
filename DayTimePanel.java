import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.GridLayout;


public class DayTimePanel extends JPanel {
	
	
	public JPanel FarmPanel,DayPanel, upPanel, downPanel,StorePanel;
	public JLabel lblcount,lblmoney,lbllimit;
	public JLabel[] lblCage;
	public JButton btn_farmer;
	public JButton btn_buySheep, btn_buyCow, btn_buyRibbon, btn_buySunglass, btn_buyNecklace;
	public JLabel lblBackground;
	public int count=1;	//양과 소의 총 합계.
	public int limit=3;//Max count
	public int money=10000;
	public JButton btnSheep;
	public SheepThread[] st;
	public BtnListener btnL;
	public JLabel lbltest;
	public int type=0;
	public int i;
	public int sheepType;
	
	public JButton btnStartSheep1, btnStartSheep2, btnStartSheep3;
	public JLabel lblLogo, lblHelpMessage;
	
	public int temp;	//sheep color
	
	//constructor
	public DayTimePanel() {
		
		//전체 화면 
		setBackground(Color.black);
		setPreferredSize(new Dimension(750,700));
		setLayout(null);
		
		btnL = new BtnListener();
		
//#############################################
//
//					FarmPanel
//
//#############################################
		FarmPanel = new JPanel();
		FarmPanel.setBackground(Color.pink);
		FarmPanel.setBounds(0,0,750,700);
		FarmPanel.setLayout(null);
		FarmPanel.setVisible(true);
        add(FarmPanel);
		
		//Game title logo
		JLabel lblLogo = new JLabel(new ImageIcon("images/logo.png"),SwingConstants.CENTER);
		lblLogo.setBounds(50,50,650,200);
		FarmPanel.add(lblLogo);
		
		btnStartSheep1 = new JButton(new ImageIcon("images/sheep1_red.png"));
		btnStartSheep1.setBounds(25,400,200,190);
		btnStartSheep1.setOpaque(false);
		btnStartSheep1.setContentAreaFilled(false);
		btnStartSheep1.setBorderPainted(false);
		FarmPanel.add(btnStartSheep1);
		
		btnStartSheep2 = new JButton (new ImageIcon("images/sheep1_blue.png"));
		btnStartSheep2.setBounds(275,400,200,190);
		btnStartSheep2.setOpaque(false);
		btnStartSheep2.setContentAreaFilled(false);
		btnStartSheep2.setBorderPainted(false);
		FarmPanel.add(btnStartSheep2);
		
		btnStartSheep3 = new JButton (new ImageIcon("images/sheep1_orange.png"));
		btnStartSheep3.setBounds(525,400,200,190);
		btnStartSheep3.setOpaque(false);
		btnStartSheep3.setContentAreaFilled(false);
		btnStartSheep3.setBorderPainted(false);
		FarmPanel.add(btnStartSheep3);
		
		lblHelpMessage = new JLabel("Choose one to start game!");
		lblHelpMessage.setBounds(200,600,400,50);
		lblHelpMessage.setFont(new Font("Estrangelo Edessa",Font.BOLD,30));
		FarmPanel.add(lblHelpMessage);
		
		btnStartSheep1.addActionListener(btnL);
		btnStartSheep2.addActionListener(btnL);
		btnStartSheep3.addActionListener(btnL);


//#############################################
//
//					upPanel
//
//#############################################
		
		DayPanel = new JPanel();
		DayPanel.setBackground(Color.white);
		DayPanel.setBounds(0,0,750,700);
		DayPanel.setLayout(null);
		DayPanel.setVisible(false);
        add(DayPanel);
		

		upPanel = new JPanel();
		upPanel.setBackground(new Color(223,234,253));
		upPanel.setBounds(0,0,750,300);
		upPanel.setLayout(null);
		upPanel.setVisible(true);
        DayPanel.add(upPanel);
        
        lblcount = new JLabel("Count: "+count);//마리수를 나타내는 라벨
        lblcount.setBounds(10,20,120,80);
        lblcount.setFont(new Font("Verdana", Font.BOLD, 20));
        lblcount.setVerticalAlignment(SwingConstants.CENTER);
        upPanel.add(lblcount);
        
        lbllimit = new JLabel(" /"+ limit);//레벨당 최대마리수를 나타내는 라벨
        lbllimit.setBounds(120,20,60,80);
        lbllimit.setFont(new Font("Verdana", Font.BOLD, 23));
        lbllimit.setHorizontalAlignment(SwingConstants.CENTER);
        lbllimit.setVerticalAlignment(SwingConstants.CENTER);
        upPanel.add(lbllimit);
        
        ImageIcon icon = new ImageIcon("images/money.png");//money label에 돈주머니 이미지 추가
        JLabel lblicon = new JLabel("", icon, SwingConstants.CENTER);
        lblicon.setBounds(500,20,100,90);
        upPanel.add(lblicon);
          
        lblmoney = new JLabel(": "+money);//총 벌어들인 돈을 나타내는 라벨
        lblmoney.setBounds(600,20,150,80);
        lblmoney.setFont(new Font("Verdana", Font.BOLD, 30));
        lblmoney.setHorizontalAlignment(SwingConstants.CENTER);
        lblmoney.setVerticalAlignment(SwingConstants.CENTER);
        upPanel.add(lblmoney);    
        
        btn_farmer = new JButton(new ImageIcon("images/farmer.png"));//농부버튼 누르면 상점으로 이동
        btn_farmer.setBounds(100,150,100,150);
        btn_farmer.setFont(new Font("Arial", Font.PLAIN, 30));
        btn_farmer.setOpaque(false);
      	btn_farmer.setContentAreaFilled(false);
        btn_farmer.setBorderPainted(false);
        upPanel.add(btn_farmer);
        
        lblBackground = new JLabel(new ImageIcon("images/store.png"));
		lblBackground.setBounds(280,100,400,200);
		upPanel.add(lblBackground);
		
		ImageIcon[] image = new ImageIcon[5];
       	image[0] = new ImageIcon("images/cage1.png");
       	image[1] = new ImageIcon("images/cage2.png");
       	image[2] = new ImageIcon("images/cage3.png");
       	image[3] = new ImageIcon("images/cage4.png");
       	image[4] = new ImageIcon("images/cage5.png");
		
		lblCage = new JLabel[5];
		
		for(i=0;i<5;i++){
			lblCage[i] = new JLabel("",image[i],SwingConstants.CENTER);
			lblCage[i].setBounds(0,0,750,300);
			lblCage[i].setVisible(false);
			upPanel.add(lblCage[i]);
			}
		lblCage[0].setVisible(true);
		
		//Button
		btn_buySheep = new JButton("sheep 500");
		btn_buySheep.setBounds(100,40,90,50);
		btn_buySheep.addActionListener(btnL);
		btn_buySheep.setBorderPainted(false);
		btn_buySheep.setContentAreaFilled(false);
		lblBackground.add(btn_buySheep);
		
		btn_buyCow = new JButton("cow 1000");
		btn_buyCow.setBounds(200,40,90,50);
		btn_buyCow.addActionListener(btnL);
		btn_buyCow.setBorderPainted(false);
		btn_buyCow.setContentAreaFilled(false);
		lblBackground.add(btn_buyCow);
		
		btn_buyRibbon = new JButton(new ImageIcon("images/ribbon.png"));
		btn_buyRibbon.setBounds(80,100,80,50);
		btn_buyRibbon.addActionListener(btnL);	
		btn_buyRibbon.setBorderPainted(false);
		btn_buyRibbon.setContentAreaFilled(false);
		lblBackground.add(btn_buyRibbon);
		
		btn_buySunglass = new JButton(new ImageIcon("images/sunglass.png"));
		btn_buySunglass.setBounds(170,100,80,50);
		btn_buySunglass.addActionListener(btnL);
		btn_buySunglass.setBorderPainted(false);
		btn_buySunglass.setContentAreaFilled(false);
		lblBackground.add(btn_buySunglass);
		
		btn_buyNecklace = new JButton(new ImageIcon("images/necklace.png"));
		btn_buyNecklace.setBounds(260,100,80,50);
		btn_buyNecklace.addActionListener(btnL);
		btn_buyNecklace.setBorderPainted(false);
		btn_buyNecklace.setContentAreaFilled(false);
		lblBackground.add(btn_buyNecklace);
		//Label
        
        

       	
   	   

       
        
        
        
//#############################################
//
//					downPanel
//
//#############################################  

		downPanel = new JPanel();
		downPanel.setBackground(new Color(167,232,102));
		downPanel.setBounds(0,300,750,400);
		downPanel.setVisible(true);
		
		DayPanel.add(downPanel);
		
		
		color(getSheepType());
		} //constructor

		
		private class BtnListener implements ActionListener {
			
			public void actionPerformed(ActionEvent event) {
			
			Object obj = event.getSource();
			
			//for(int i = 0;i<10;i++)			
				//st[i].start();
			if ( obj == btnStartSheep1 )
			{
				FarmPanel.setVisible(false);
				DayPanel.setVisible(true);
			    myThreadStart();
			    type = 1;
			    temp = 1;
				color(1);
				st[count].setVisible(true);
			}
			
			
			else if ( obj == btnStartSheep2 )
			{
				FarmPanel.setVisible(false);
				DayPanel.setVisible(true);
				myThreadStart();
				type = 2;
				temp = 2;
				color(2);
				st[count].setVisible(true);				
			}
			else if(obj == btnStartSheep3)
			{
				FarmPanel.setVisible(false);
				DayPanel.setVisible(true);
				myThreadStart();
				type = 3;
				temp = 3;
				color(3);
				st[count].setVisible(true);
			}
						
			if(obj == btn_buySheep)
			{
				System.out.println("buysheep");
				if(money >= 500)
				{
					money-=500;
					type = temp;
					color(type);
					st[count].setVisible(true);
					count++;
					
					lblmoney.setText(""+money);
					lblcount.setText("Count : "+count);
					
					if(count == 3) 
					{
						limit = 5;
						lbllimit.setText("/ "+limit);
						lblCage[0].setVisible(false);
						lblCage[1].setVisible(true);
					}
					else if( count == 5 )
					{
						limit = 7;
						lbllimit.setText("/ "+limit);
						lblCage[1].setVisible(false);
						lblCage[2].setVisible(true);
					}
					
					else if (count == 7 )
					{
						limit = 10;
						lbllimit.setText("/ "+limit);
						lblCage[2].setVisible(false);
						lblCage[3].setVisible(true);
					}
					else if(count ==10){
						lblCage[3].setVisible(false);
						lblCage[4].setVisible(true);
					}
								
				}
			}
			else if(obj == btn_buyCow)
			{
				System.out.println("buycow");
				if(money >= 1000)
				{
					money-=1000;
					type = 4;
					color(type);
					st[count].setVisible(true);
					count++;
					lblmoney.setText(""+money);
					lblcount.setText("Count : "+count);
					if(count == 3) 
					{
						limit = 5;
						lbllimit.setText("/ "+limit);
						lblCage[0].setVisible(false);
						lblCage[1].setVisible(true);
					}
					else if( count == 5 )
					{
						limit = 7;
						lbllimit.setText("/ "+limit);
						lblCage[1].setVisible(false);
						lblCage[2].setVisible(true);
					}
					
					else if (count == 7 )
					{
						limit = 10;
						lbllimit.setText("/ "+limit);
						lblCage[2].setVisible(false);
						lblCage[3].setVisible(true);
					}	
					else if(count ==10){
						lblCage[3].setVisible(false);
						lblCage[4].setVisible(true);
					}	
				}
			}
			else if(obj == btn_buyRibbon)
			{
				if(money >= 1500)
				{
					money -= 1500;
					lblmoney.setText(""+money);
					//setVisible 양
				}
			}
			else if(obj == btn_buySunglass)
			{
				if(money >= 1000)
				{
					money -= 1000;
					lblmoney.setText(""+money);
					//setVisible 양
				}
				
			}
			else if(obj == btn_buyNecklace)
			{
				if(money >= 2000)
				{
					money -= 2000;
					lblmoney.setText(""+money);
					//setVisible 양
				}	
			}
		}//actionPerformed
	}//BtnListener
	
	public void myThreadStart() {
		System.out.println("test");
	}
	
	public int getSheepType() {
		
		if(sheepType == 1) {
			System.out.println("is 1");
			return 1;
		}
		else if(sheepType == 2) {
			System.out.println("is 2");
			return 2;
		}
		else if(sheepType ==3) {
			System.out.println("is 3");
			return 3;
		}
		else if(sheepType == 4)
		return 4;
		else
			return 0;
			
	}//getSheepType()
	
	public void color(int a) {
		
		st = new SheepThread[10];
		type = a;
		System.out.println(type);
			
			st[count] = new SheepThread(2000,type);
			st[count].addActionListener(btnL);
			st[count].setVisible(false);
			st[count].setOpaque(false);
			st[count].setContentAreaFilled(false);
			st[count].setBorderPainted(false);
			st[count].start();
			downPanel.add(st[count]);
		//	st[0].setVisible(true);
	}//color
} //end
		
	