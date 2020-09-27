///////////////////////////////////////////////////////
///////////////JAVA PROGRAMMING (7조)//////////////////
///////////////////////////////////////////////////////
/// 2013111566 김미소 2013111571 김아름 2013111575 김이선 
//////////// 2013111084 박세은 2013111593 이예나 //////////
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