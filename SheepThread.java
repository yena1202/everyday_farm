///////////////////////////////////////////////////////
/////////// 양의 털 또는 소의 우유가 저절로 생성되는 Thread///////////
////////////버튼 클릭시 다시 원상태로 돌아가는 기능도 포함한다.
///////////////////////////////////////////////////////


import java.awt.*;
import javax.swing.*;

public class SheepThread extends JButton implements Runnable { //JButton을 상속받아 양을 Button으로 만듬.
	
	private Thread myThread;//thread변수 설정.
	private int delayTime,t;//양털 자라는 시간과 색 변수
	
	//모든 양, 소의 이미지 설정 
	ImageIcon red1 = new ImageIcon("images/sheep1_red.png");
   	ImageIcon red2 = new ImageIcon("images/sheep2_red.png");
   	ImageIcon blue1 = new ImageIcon("images/sheep1_blue.png");
   	ImageIcon blue2 = new ImageIcon("images/sheep2_blue.png");
  	ImageIcon orange1 = new ImageIcon("images/sheep1_orange.png");
  	ImageIcon orange2 = new ImageIcon("images/sheep2_orange.png");
  	ImageIcon cow1 = new ImageIcon("images/cow.png");
  	ImageIcon cow2 = new ImageIcon("images/cow_2.png");
	

	public SheepThread(int time, int num) { //매개 변수로 양털이 자라는 시간(time)과 양털의 색깔(num)을 받음.
      
		delayTime = time;
		t = num;
      
		if(t == 1) // 양털색이 빨간색일때.   
		{
			setIcon(red1); //양털이 아직 없는 양으로 설정.
			setDisabledIcon(red1); 
      	}
		else if(t == 2) //양털색이 파란색일때.  
		{
         	setIcon(blue1);
         	setDisabledIcon(blue1);
		}
		else if(t == 3) //양털색이 주황색일때.  
		{
        	 setIcon(orange1);
        	 setDisabledIcon(orange1);
		}   
		else if(t == 4) //소를 선택하였을때.  
		{
         	setIcon(cow1);
        	setDisabledIcon(cow1);   
		}
      
		setEnabled(false);
		myThread = null; //양 선택된 후 바로 start()함수 실행-양털을 자라게 하는 함수  
	}
   
	public void start() {
		if (myThread == null) {
			myThread = new Thread(this);//thread 실행.
			myThread.start();//실제 실행할때 호출.
		}
	}
	   
	public void stop() { //thread가 start()에 의해 실행되고나서 멈추는 함수.
		if (myThread != null) myThread.stop();
	}
   
	public void run() { 
		try {
            
            myThread.sleep(delayTime);//초 단위로 프로그램 실행을 지연시키는 함수인 sleep함수를 사용하여 thread를 실행. 시간은 매개변수로 delayTime사용.
			if(t == 1) //thread실행 후 양의 색이 빨간색일때.                                                                     
			{
				setIcon(red2); //털이 자란 양으로 설정
			}
			else if(t == 2) //양이 파란색일때
			{
				setIcon(blue2); //털이 자란 파란색 양
         
			}
			else if(t == 3)
			{
				setIcon(orange2); //털이 자란 주황색 양
			}
			else if(t == 4)
			{
				setIcon(cow2); //우유가 나오는 소
            }   
      
     		setEnabled(true);
      } catch (Exception e) {}
	}
	public void reset() { //양털을 깎는 메소드.
   	 
   
     if (myThread != null) { //thread실행이 멈췄을때 다시 양털이 없어지게 하도록 설정  
      if(t == 1) //양 색이 빨간색일때    
      {
         setIcon(red1);//양털이 없는 함수로 다시 설정
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
  myThread.start();//reset()호출되면 자동으로 다시 start()함수 
  
} //reset()
}
