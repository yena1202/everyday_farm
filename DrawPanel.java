import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class DrawPanel extends JPanel
{
 private int nDrawMode;
 //2.
 private DrawingListener drawingL;
 
 
 private ArrayList<DrawData> dataList; 
 
 private Point ptTemp;
 private Point drag1, drag2;
 private boolean dragFlag;
 
 private PrimaryPanel primary;
 
 private Color selectedColor;
 
 public DrawPanel(PrimaryPanel p)
 {
  setBackground(Color.white);
  
  //primar = new PrimaryPanel();
  primary = p;
  
  //2.
  drawingL = new DrawingListener();
  
  //3. add
  addMouseListener(drawingL);
  addMouseMotionListener(drawingL);
  
  nDrawMode = DrawConstants.NONE;
  
  dataList = new ArrayList<DrawData>(); //ArrayList »ý¼º.
  
  dragFlag = false;
  
  selectedColor = Color.black;
  
 } //constructor
 
 
 public void setSelectedColor(Color c) {
 	selectedColor = c;
 }
 public Color getSelectedColor() {
 	return selectedColor;
 }
 
 public void setDrawMode(int mode) { nDrawMode = mode; }
 public int getDrawMode() { return nDrawMode; }
 
 public void paintComponent(Graphics page)
 {
  super.paintComponent(page);
  
  //boundary
  page.drawRect(0,0,499,399);
  
  page.setColor(selectedColor);
  
  if(dragFlag){
  	
  	switch(nDrawMode){
  		
  		case DrawConstants.LINE:
  		page.drawLine(drag1.x, drag1.y, drag2.x, drag2.y);
  		break;
  		case DrawConstants.RECT:
  		break;
  		case DrawConstants.OVAL:
  		break;
  		
  		
  		
  	}
  	
  	
  }
  
  for(int i=0 ; i<dataList.size() ; i++)
  {
   DrawData data = dataList.get(i);
   switch(data.drawMode)
   {
    case DrawConstants.POINT:
     page.fillOval(data.pt.x, data.pt.y, data.ptSize, data.ptSize);
     break;
    case DrawConstants.LINE:
     page.drawLine(data.pt1.x, data.pt1.y, data.pt2.x, data.pt2.y);
     break;
    case DrawConstants.RECT:
     rect(page, data.pt1, data.pt2);
     break;
    case DrawConstants.OVAL:
     System.out.println("OVAL");
     break; 
   }//switch-case 
   
  }//for
 } //paintComponent()
 
 
 private void rect(Graphics page, Point pt1, Point pt2) {
 	
 	if(pt1.x<pt2.x && pt1.y<pt2.y)
 	page.drawRect(pt1.x, pt1.y, pt2.x-pt1.x, pt2.y-pt1.y);
 	else if(pt1.x<pt2.x && pt1.y>pt2.y)
 	page.drawRect(pt1.x, pt2.y, pt2.x-pt1.x, pt1.y-pt2.y);
 	else if(pt1.x>pt2.x && pt1.y<pt2.y)
 	page.drawRect(pt2.x, pt1.y, pt1.x-pt2.x, pt1.y-pt2.y);
 	else if(pt1.x>pt2.x && pt1.y>pt2.y)
 	page.drawRect(pt2.x, pt2.y, pt1.x-pt2.x, pt1.y-pt2.y);
 	
 }//rect method
 
 private class DrawingListener implements MouseListener, MouseMotionListener
 {
  public void mouseClicked(MouseEvent event)
  {
   if (nDrawMode == DrawConstants.POINT)
   {
   	int size = primary.getPtSize();
    dataList.add(new DrawData(nDrawMode, event.getPoint(), primary.getPtSize()));
    
    repaint();
   } //if   
  }
  public void mousePressed(MouseEvent event)
  {
   if (nDrawMode == DrawConstants.LINE || nDrawMode == DrawConstants.RECT || nDrawMode == DrawConstants.OVAL)
   {
    ptTemp = event.getPoint();
    drag1 = event.getPoint();
   	drag2 = event.getPoint();
    dragFlag = true;
    
   } //if
   
  }
  public void mouseReleased(MouseEvent event)
  {
   if (nDrawMode == DrawConstants.LINE || nDrawMode == DrawConstants.RECT || nDrawMode == DrawConstants.OVAL)
   {
   	ptTemp = event.getPoint();
   	drag1 = event.getPoint();
   	drag2 = event.getPoint();
    dataList.add(new DrawData(nDrawMode, ptTemp, event.getPoint()));
    dragFlag = false;
    
    repaint();
    
   } //if
  }
  public void mouseEntered(MouseEvent event) {}
  public void mouseExited(MouseEvent event) {}
  
  public void mouseMoved(MouseEvent event) {}
  public void mouseDragged(MouseEvent event) {
  	if (nDrawMode == DrawConstants.LINE || nDrawMode == DrawConstants.RECT || nDrawMode == DrawConstants.OVAL){
  
   drag2 = event.getPoint();
   repaint();
  }
   	
   	}
  
 } //DrawingListener class
 
}  //DrawPanel class
