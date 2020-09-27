
import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;

public class PrimaryPanel extends JPanel
 {
  private DrawPanel drawPanel;
  private JPanel menuPanel, btnPanel;
  private JButton[] btnMenu;
  
  private JPanel ptSizePanel;
  private JLabel lblPtSize;
  private JTextField txtPtSize;
  private int nPtSize;
  
  private JButton btnColor;
  private Color selectedColor;
  
  //2.
  private BtnMenuListener btnMenuL;
  
  
  public PrimaryPanel()
  {
   setBackground(Color.white);
   setPreferredSize(new Dimension(630,420));
   setLayout(null);
   
   //2.
   btnMenuL = new BtnMenuListener();
   
   drawPanel = new DrawPanel(this);
   drawPanel.setBounds(10,10,500,400); 
   add(drawPanel);
   
   menuPanel = new JPanel();
   menuPanel.setLayout(null);
   menuPanel.setBounds(520,10,100,400);
   add(menuPanel);
   
   btnPanel = new JPanel();
   btnPanel.setBackground(Color.red);
   btnPanel.setBounds(5,5,90,180);
   btnPanel.setLayout(new GridLayout(6,1));
   menuPanel.add(btnPanel);
   
   btnMenu = new JButton[6];
   for (int i=0 ; i<6 ; i++)
   {
    btnMenu[i] = new JButton(DrawConstants.MENU[i]);
    //3.
    btnMenu[i].addActionListener(btnMenuL);
    btnPanel.add(btnMenu[i]);
   } //for
   
   ptSizePanel = new JPanel();
   ptSizePanel.setBounds(5,190,90,40);
   ptSizePanel.setVisible(false);
   menuPanel.add(ptSizePanel);
   
   lblPtSize = new JLabel("size : ");
   ptSizePanel.add(lblPtSize);
   
   txtPtSize = new JTextField(4);
   ptSizePanel.add(txtPtSize);
   
   nPtSize = 30;
   txtPtSize.setText(""+nPtSize);
   
   btnColor = new JButton("color");
   btnColor.setBounds(5,240,90,30);
   btnColor.addActionListener(btnMenuL);
   menuPanel.add(btnColor);
   
   selectedColor = Color.black;
   
  } //constructor
  
  public int getPtSize(){
  	
  	nPtSize = Integer.parseInt(txtPtSize.getText());
  	return nPtSize;
  	
  }//getPtSize()
  
  //1.
  private class BtnMenuListener implements ActionListener
  {
   public void actionPerformed(ActionEvent event)
   {
    //4.
    Object obj = event.getSource();
    
    for (int i=0 ; i<6 ; i++)
    {
     if (obj == btnMenu[i])
     {
      drawPanel.setDrawMode(i);
      if(i == DrawConstants.POINT) {
      	ptSizePanel.setVisible(true);
      }else {
      	ptSizePanel.setVisible(false);
      }//if-else
      
      
      break;
     } //if
    } //for
    
    if(obj == btnColor) {
    	
    	
    	selectedColor = JColorChooser.showDialog(drawPanel, "Select Color", selectedColor);
    	drawPanel.setSelectedColor(selectedColor);
    }//if
    
   }  //actionPerformed()
   
  } //BtnMenuListener class 
 } //PrimaryPanel class
