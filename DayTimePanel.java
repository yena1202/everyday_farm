import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Button;
import java.awt.GridLayout;


public class DayTimePanel extends JPanel {
	
	//declasration of listener object
	public BtnListener btnL;
	
	public JPanel FarmPanel, DayPanel, upPanel, downPanel;
	
	//FarmPanel elements
	public JLabel lblLogo, lblHelpMessage;
	public JButton btnStartSheep1, btnStartSheep2, btnStartSheep3;
	
	//upPanel elements
	public int count=1;	//양과 소의 총 합계.
	public int limit=3;//Max count 3에서 5,7,10단위로 커짐 
	public int money=1000;
	public JLabel lblcount,lblmoney,lbllimit;
	public JLabel[] lblCage;
	public JLabel lblfarmer, lblribbon, lblsunglass, lblnecklace;
	public JLabel lblBackground;
	public JButton btn_buySheep, btn_buyCow, btn_buyRibbon, btn_buySunglass, btn_buyNecklace;
	
	//downPanel elements
	public int type=0;	//SheepThread의 색깔 타입 저장 변수
	public int temp;	//색깔타입 임시 저장 변수                      
	public SheepThread[] st;
	public SheepThread a;
	
	
	public DayTimePanel() {
		st = new SheepThread[10];
		
		
		//전체 화면 
		setBackground(Color.black);
		setPreferredSize(new Dimension(750,700));
		setLayout(null);
		
		btnL = new BtnListener();
		
//#############################################
//
//					FarmPanel
//		기본 양을 btnStartSheep을 통해 type 결정. 
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
		
		//StartButton
		btnStartSheep1 = new JButton(new ImageIcon("images/sheep1_red.png"));
		btnStartSheep1.setBounds(25,400,200,190);
		btnStartSheep1.setOpaque(false);
		btnStartSheep1.setContentAreaFilled(false);
		btnStartSheep1.setBorderPainted(false);
		btnStartSheep1.addActionListener(btnL);
		FarmPanel.add(btnStartSheep1);
		
		btnStartSheep2 = new JButton (new ImageIcon("images/sheep1_blue.png"));
		btnStartSheep2.setBounds(275,400,200,190);
		btnStartSheep2.setOpaque(false);
		btnStartSheep2.setContentAreaFilled(false);
		btnStartSheep2.setBorderPainted(false);
		btnStartSheep2.addActionListener(btnL);
		FarmPanel.add(btnStartSheep2);
		
		btnStartSheep3 = new JButton (new ImageIcon("images/sheep1_orange.png"));
		btnStartSheep3.setBounds(525,400,200,190);
		btnStartSheep3.setOpaque(false);
		btnStartSheep3.setContentAreaFilled(false);
		btnStartSheep3.setBorderPainted(false);
		btnStartSheep3.addActionListener(btnL);
		FarmPanel.add(btnStartSheep3);
		
		lblHelpMessage = new JLabel("Choose one to start game!");
		lblHelpMessage.setBounds(200,600,400,50);
		lblHelpMessage.setFont(new Font("Estrangelo Edessa",Font.BOLD,30));
		FarmPanel.add(lblHelpMessage);
		
		
	


//#############################################
//
//					DayPanel
//	 		upPanel과 downPanel을 합침 
//
//#############################################
		
		DayPanel = new JPanel();
		DayPanel.setBackground(Color.white);
		DayPanel.setBounds(0,0,750,700);
		DayPanel.setLayout(null);
		DayPanel.setVisible(false);
        add(DayPanel);
		
//#############################################
//
//					upPanel
//
//#############################################

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
        
        //악세사리     
        lblsunglass = new JLabel(new ImageIcon("images/lblsunglass.png"));
        lblsunglass.setBounds(100,155,100,100);
        lblsunglass.setVisible(false);
        upPanel.add(lblsunglass);
        
        lblribbon = new JLabel(new ImageIcon("images/lblribbon.png"));
        lblribbon.setBounds(100,120,100,100);
        lblribbon.setVisible(false);
        upPanel.add(lblribbon);
        
        lblnecklace = new JLabel(new ImageIcon("images/lblnecklace.png"));
        lblnecklace.setBounds(100,195,100,100);
        lblnecklace.setVisible(false);
        upPanel.add(lblnecklace);
        
        //사용자 캐릭터 농부 
        lblfarmer = new JLabel(new ImageIcon("images/farmer.png"));
        lblfarmer.setBounds(100,150,100,150);
        lblfarmer.setFont(new Font("Arial", Font.PLAIN, 30));
        upPanel.add(lblfarmer);
        
        lblBackground = new JLabel(new ImageIcon("images/store.png"));
		lblBackground.setBounds(280,100,400,200);
		upPanel.add(lblBackground);
		
		//배경 이미지 아이콘   
		ImageIcon[] image = new ImageIcon[5];
       	image[0] = new ImageIcon("images/cage1.png");
       	image[1] = new ImageIcon("images/cage2.png");
       	image[2] = new ImageIcon("images/cage3.png");
       	image[3] = new ImageIcon("images/cage4.png");
       	image[4] = new ImageIcon("images/cage5.png");
		
		lblCage = new JLabel[5];
		
		for(int i=0;i<5;i++){
			lblCage[i] = new JLabel("",image[i],SwingConstants.CENTER);
			lblCage[i].setBounds(0,0,750,300);
			lblCage[i].setVisible(false);
			upPanel.add(lblCage[i]);
		}
			
		lblCage[0].setVisible(true);
		
		//Store Button 
		btn_buySheep = new JButton(new ImageIcon("images/sheepprice.png"));
		btn_buySheep.setBounds(100,40,90,50);
		btn_buySheep.addActionListener(btnL);
		btn_buySheep.setBorderPainted(false);
		btn_buySheep.setContentAreaFilled(false);
		lblBackground.add(btn_buySheep);
		
		btn_buyCow = new JButton(new ImageIcon("images/cowprice.png"));
		btn_buyCow.setBounds(210,40,100,50);
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
		
  
//#############################################
//
//					downPanel
//
//				양과 소를 표시하는 패널 
//#############################################  

		downPanel = new JPanel();
		downPanel.setBackground(new Color(167,232,102));
		downPanel.setBounds(0,300,750,400);
		downPanel.setVisible(true);
		DayPanel.add(downPanel);
		
		color(getSheepType());//처음 양 색깔 결정
	} //constructor

		
	private class BtnListener implements ActionListener {
			
		public void actionPerformed(ActionEvent event) {
			
			Object obj = event.getSource();
			
			//StartSheep버튼을 누를 경우 패널 전환이 일어나고 양 색깔 타입이 결정
			
			if ( obj == btnStartSheep1 )
			{
				FarmPanel.setVisible(false);
				DayPanel.setVisible(true);
			    type = 1;
			    temp = 1;
				color(1);
				st[count].setVisible(true);
			}
			else if ( obj == btnStartSheep2 )
			{
				FarmPanel.setVisible(false);
				DayPanel.setVisible(true);
				type = 2;
				temp = 2;
				color(2);
				st[count].setVisible(true);				
			}
			else if(obj == btnStartSheep3)
			{
				FarmPanel.setVisible(false);
				DayPanel.setVisible(true);
				type = 3;
				temp = 3;
				color(3);
				st[count].setVisible(true);
			}
			
			//buyObject 버튼 클릭시 소지금이 해당 금액이상이어만 구매가능
			
			//양 구매시 처음 선택한 색깔 타입의 양이 구매됨                       
			if(obj == btn_buySheep)
			{
				if(money >= 500)
				{
					money-=500;
					type = temp;//임시 변수에 저장된 색깔 타입을 가져옴 
					color(type);
					st[count].setVisible(true);
					count++;
					
					lblmoney.setText(""+money);
					lblcount.setText("Count : "+count);
					
					//일정 마리수 초과시 cage이미지를 업그레이드 
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
			//소 구매
			else if(obj == btn_buyCow)
			{
				if(money >= 1000)
				{
					money-=1000;
					type = 4;
					color(type);
					st[count].setVisible(true);
					count++;
					lblmoney.setText(""+money);
					lblcount.setText("Count : "+count);
					
					//일정 마리수 초과시 cage이미지를 업그레이드 
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
			//농부에 적용 한번구매한 악세사리는 setEnable(false)로 재구매 불가 
			else if(obj == btn_buyRibbon)
			{
				if(money >= 1500)
				{
					money -= 1500;
					lblmoney.setText(""+money);
					lblribbon.setVisible(true);
					btn_buyRibbon.setEnabled(false);
				}
			}
			else if(obj == btn_buySunglass)
			{
				if(money >= 1000)
				{
					money -= 1000;
					lblmoney.setText(""+money);
					lblsunglass.setVisible(true);
					btn_buySunglass.setEnabled(false);
				}
				
			}
			else if(obj == btn_buyNecklace)
			{
				if(money >= 2000)
				{
					money -= 2000;
					lblmoney.setText(""+money);
					lblnecklace.setVisible(true);
					btn_buyNecklace.setEnabled(false);
				}	
			}
			
			for(int i=0; i<10; i++)
			{
			  	if(obj == st[i]) 
			    {
			    	money+=500;
			    	lblmoney.setText(""+money);
		    		st[i].reset();
		    		st[i].start();	
		 		}	
		 	}
		
		}//actionPerformed
	
	}//BtnListener
	
	
	//처음 양 색깔 타입을 반환하는 함수
	public int getSheepType() {
		
		if(type == 1) {
			return 1;
		}
		else if(type == 2) {
			return 2;
		}
		else if(type == 3) {
			return 3;
		}
		else if(type == 4)
		return 4;
		else
			return 0;
			
	}//getSheepType()
	
	//색깔 타입을 받아SheepThread를 통해 객체 생성 
	public void color(int a) {
	
		type = a;
			
		st[count] = new SheepThread(2000,type);
			
		st[count].setVisible(false);
		st[count].setOpaque(false);
		st[count].setContentAreaFilled(false);
		st[count].setBorderPainted(false);
		st[count].start();
		
		st[count].addActionListener(btnL);
		downPanel.add(st[count]);

	}//color
} //end
		
	