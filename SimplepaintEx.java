import javax.swing.JFrame;

public class SimplepaintEx {
	
public static void main(String[] args) {
	
	
	JFrame frame = new JFrame("simple paint program");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	PrimaryPanel primary = new PrimaryPanel();
	frame.getContentPane().add(primary);
	
	frame.pack();
	frame.setVisible(true);
	
	}	
	
	
	
	
}