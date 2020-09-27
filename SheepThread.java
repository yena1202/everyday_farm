///////////////////////////////////////////////////////
/////////// ���� �� �Ǵ� ���� ������ ������ �����Ǵ� Thread///////////
////////////��ư Ŭ���� �ٽ� �����·� ���ư��� ��ɵ� �����Ѵ�.
///////////////////////////////////////////////////////


import java.awt.*;
import javax.swing.*;

public class SheepThread extends JButton implements Runnable { //JButton�� ��ӹ޾� ���� Button���� ����.
	
	private Thread myThread;//thread���� ����.
	private int delayTime,t;//���� �ڶ�� �ð��� �� ����
	
	//��� ��, ���� �̹��� ���� 
	ImageIcon red1 = new ImageIcon("images/sheep1_red.png");
   	ImageIcon red2 = new ImageIcon("images/sheep2_red.png");
   	ImageIcon blue1 = new ImageIcon("images/sheep1_blue.png");
   	ImageIcon blue2 = new ImageIcon("images/sheep2_blue.png");
  	ImageIcon orange1 = new ImageIcon("images/sheep1_orange.png");
  	ImageIcon orange2 = new ImageIcon("images/sheep2_orange.png");
  	ImageIcon cow1 = new ImageIcon("images/cow.png");
  	ImageIcon cow2 = new ImageIcon("images/cow_2.png");
	

	public SheepThread(int time, int num) { //�Ű� ������ ������ �ڶ�� �ð�(time)�� ������ ����(num)�� ����.
      
		delayTime = time;
		t = num;
      
		if(t == 1) // ���л��� �������϶�.   
		{
			setIcon(red1); //������ ���� ���� ������ ����.
			setDisabledIcon(red1); 
      	}
		else if(t == 2) //���л��� �Ķ����϶�.  
		{
         	setIcon(blue1);
         	setDisabledIcon(blue1);
		}
		else if(t == 3) //���л��� ��Ȳ���϶�.  
		{
        	 setIcon(orange1);
        	 setDisabledIcon(orange1);
		}   
		else if(t == 4) //�Ҹ� �����Ͽ�����.  
		{
         	setIcon(cow1);
        	setDisabledIcon(cow1);   
		}
      
		setEnabled(false);
		myThread = null; //�� ���õ� �� �ٷ� start()�Լ� ����-������ �ڶ�� �ϴ� �Լ�  
	}
   
	public void start() {
		if (myThread == null) {
			myThread = new Thread(this);//thread ����.
			myThread.start();//���� �����Ҷ� ȣ��.
		}
	}
	   
	public void stop() { //thread�� start()�� ���� ����ǰ��� ���ߴ� �Լ�.
		if (myThread != null) myThread.stop();
	}
   
	public void run() { 
		try {
            
            myThread.sleep(delayTime);//�� ������ ���α׷� ������ ������Ű�� �Լ��� sleep�Լ��� ����Ͽ� thread�� ����. �ð��� �Ű������� delayTime���.
			if(t == 1) //thread���� �� ���� ���� �������϶�.                                                                     
			{
				setIcon(red2); //���� �ڶ� ������ ����
			}
			else if(t == 2) //���� �Ķ����϶�
			{
				setIcon(blue2); //���� �ڶ� �Ķ��� ��
         
			}
			else if(t == 3)
			{
				setIcon(orange2); //���� �ڶ� ��Ȳ�� ��
			}
			else if(t == 4)
			{
				setIcon(cow2); //������ ������ ��
            }   
      
     		setEnabled(true);
      } catch (Exception e) {}
	}
	public void reset() { //������ ��� �޼ҵ�.
   	 
   
     if (myThread != null) { //thread������ �������� �ٽ� ������ �������� �ϵ��� ����  
      if(t == 1) //�� ���� �������϶�    
      {
         setIcon(red1);//������ ���� �Լ��� �ٽ� ����
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
  myThread.start();//reset()ȣ��Ǹ� �ڵ����� �ٽ� start()�Լ� 
  
} //reset()
}
