import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class GraphicInterface extends JPanel{
	QuadConfig config;
	public GraphicInterface(QuadConfig quadConfig){
		config=quadConfig;
		
	}
	protected void paintComponent(Graphics g) {
		//System.out.println("IN PAINT");
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		// TODO Auto-generated method stub
		
		//SPEED BAR
		g.setColor(Color.yellow);
		g.drawRect(99, 99, 21, 201);
		g.setColor(Color.green);
		g.fillRect(100, 100, 20, 200);
		g.setColor(Color.black);
		g.fillRect(100, 100, 20, (int) (200-(config.getSpeed()-700)/6.5));
		g.setColor(Color.green);
		g.drawString("Speed :"+config.getSpeed(), 80, 325);
		
		//END SPEED BAR
		
		//STATE PITCH
		Color c=config.isPitchOn()?Color.green:Color.red;
		g.setColor(c);
		g.fillOval(0, 5, 20, 20);
		g.setColor(c);
		g.drawString(config.isPitchOn()?"Pitch On":"Pitch Off", 25, 20);
		
		//STATE ROLL
		c=config.isRollOn()?Color.green:Color.red;
		g.setColor(c);
		g.fillOval(0, 30, 20, 20);
		g.setColor(c);
		g.drawString(config.isRollOn()?"Roll On":"Roll Off", 25, 45);
		
		//STATE YAW 
		c=config.isYawOn()?Color.green:Color.red;
		g.setColor(c);
		g.fillOval(0, 55, 20, 20);
		g.setColor(c);
		g.drawString(config.isYawOn()?"Yaw On":"Yaw Off", 25, 70);
		
		//
		c=config.isQuadOn()?Color.green:Color.red;
		g.setColor(c);
		g.fillOval(0, 90 , 80, 80);
		g.setColor(Color.white);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		g.drawString(config.isQuadOn()?"Allumer":"Eteindre", 10, 132);
	}
}
