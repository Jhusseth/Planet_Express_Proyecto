package interfaz;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Paint {   
    Color color;
     
   
    public Paint(){          
    }
    
   public static void PaintPoint(Graphics g,int x,int y,String n){
	   ImageIcon background = new ImageIcon("data/pictures/airplane.png");
		g.drawImage(background.getImage(), x, y, 25, 25, null);
		 
	    ((Graphics2D)g).setColor(Color.RED);
	    Font font =new Font("Monospaced",Font.BOLD, 16);
	    g.setFont(font );
	    ((Graphics2D)g).drawString(n, x, y); 
    }    
  
  public static void paintTravel(Graphics g, int x1,int y1,int x2,int y2,int tam){
	  
        int xAux = 0; int yAux = 0; 
        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(3);
        ((Graphics2D)g).setStroke(stroke);  
        g.setColor(Color.BLACK);
       ((Graphics2D)g).drawLine(x1+25, y1+15, x2, y2+15);
       if(x1<=x2)
           xAux=((x2-x1)/2)+x1;       
        if(x1>x2)
           xAux=((x1-x2)/2)+x2;
        if(y1<y2)
           yAux=((y2-y1)/2)+y1;
        if(y1>=y2)
            yAux=((y1-y2)/2)+y2;       
       
        g.fillOval(xAux-3, yAux-15, 35, 20);
        
        g.setColor(Color.YELLOW);
        Font font =new Font("Arial Black",15, 15);
        g.setFont(font );
      ((Graphics2D)g).drawString(String.valueOf(tam), xAux, yAux);
  }   
  
  public static void paintRoute(Graphics g, int x1,int y1,int x2,int y2, Color color){
      ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(3);
        ((Graphics2D)g).setStroke(stroke);
        g.setColor(color);
        g.drawLine(x1+10, y1+10, x2+10, y2+10);
  }
   public static void clickNode(Graphics g,int x,int y,String n,Color co){
	   
       ((Graphics2D)g).setColor(co);
        ((Graphics2D)g).setStroke(new BasicStroke(3));   
        ((Graphics2D)g).fillOval(x, y, 25, 25);        
        ((Graphics2D)g).setColor(Color.BLACK);
        ((Graphics2D)g).drawOval(x, y, 25, 25);
         
    }
}
