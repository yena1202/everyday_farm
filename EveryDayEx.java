///////////////////////////////////////////////////////
///////////////JAVA PROGRAMMING (7��)//////////////////
///////////////////////////////////////////////////////
/// 2013111566 ��̼� 2013111571 ��Ƹ� 2013111575 ���̼� 
//////////// 2013111084 �ڼ��� 2013111593 �̿��� //////////
///////////////////////////////////////////////////////
import java.awt.*;
import javax.swing.*;

public class EveryDayEx
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Farm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PrimaryPanel primary = new PrimaryPanel();	
		frame.getContentPane().add(primary);
	
		frame.pack();
		frame.setVisible(true);
	} //main()
	
}	//EveryDayEx class