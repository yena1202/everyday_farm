
import java.awt.*;
 import javax.swing.*;

public class DrawData
 {
  public int drawMode;
  
  public Point pt;
  public int ptSize;
  
  public Point pt1, pt2;
  
  //Point
  public DrawData(int mode, Point p, int size)
  {
   drawMode = mode;
   pt = p;
   ptSize = size;
  }
  
  //Line, Rect, Oval
  public DrawData(int mode, Point p1, Point p2)
  {
   drawMode = mode;
   pt1 = p1;
   pt2 = p2;
  }
  
  
 } //DrawData class
