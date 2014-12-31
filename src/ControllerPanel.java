import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class ControllerPanel extends JPanel{
	QuadConfiguration config;
	public ControllerPanel(QuadConfiguration config) {
		// TODO Auto-generated constructor stub
		this.config=config;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		paintSpeed(g, 120,200,20,200);
	}
	public void paintSpeed(Graphics g,int x,int y,int w,int h){
		g.setColor(Color.yellow);
		g.drawRect(x-1, y-1, w+1, h+1);
		g.setColor(Color.green);
		g.fillRect(x, y, w, h);
		g.setColor(Color.black);
		g.fillRect(x, y, w,
				(int) (h-(config.getSpeed()-config.MIN_SPEED)/((config.MAX_SPEED-config.MIN_SPEED)/h)));
		g.setColor(Color.green);
		g.drawString("Speed :"+config.getSpeed(), x-20, y+h+25);
	}
}
