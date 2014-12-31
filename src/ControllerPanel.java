import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;

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
		
		paintSpeed(g, 30,200,20,200);
		
		paintRollBar(g,Color.blue, 80, 320, 60, 20);
		paintPitchBar(g,Color.red,130,270,20,60);
		DecimalFormat df=new DecimalFormat("#0.00");
		g.drawString("PITCH PID", 300, 10);
		paintPIDBar(g, Color.red, 250, 20, "KPP : "+df.format(config.getPidConfig().getKPP()), 100, config.getPidConfig().getKPP()*(100/PIDConfiguration.MAX_KP));
		paintPIDBar(g, Color.blue, 320, 20, "KIP : "+df.format(config.getPidConfig().getKIP()), 100, config.getPidConfig().getKIP()*(100/PIDConfiguration.MAX_KI));
		paintPIDBar(g, Color.white, 390, 20, "KDP : "+df.format(config.getPidConfig().getKDP()), 100, config.getPidConfig().getKDP()*(100/PIDConfiguration.MAX_KD));
		
		g.setColor(Color.green);
		g.drawString("ROLL PID", 300, 190);
		paintPIDBar(g, Color.red, 250, 200, "KPR : "+df.format(config.getPidConfig().getKPR()), 100, config.getPidConfig().getKPR()*(100/PIDConfiguration.MAX_KP));
		paintPIDBar(g, Color.blue, 320, 200, "KIR : "+df.format(config.getPidConfig().getKIR()), 100, config.getPidConfig().getKIR()*(100/PIDConfiguration.MAX_KI));
		paintPIDBar(g, Color.white, 390, 200, "KDR : "+df.format(config.getPidConfig().getKDR()), 100, config.getPidConfig().getKDR()*(100/PIDConfiguration.MAX_KD));
		
		g.setColor(Color.white);
		
		//COMMANDE DESCRIPTION
		g.fillRect(0, 500, getWidth(), 100);
		g.setColor(Color.black);
		g.drawString("Pitch PID configuration increase/decrease :", 5, 510);
		g.drawString("P: 8 - i", 5, 525);
		g.drawString("I: 9 - o", 55, 525);
		g.drawString("D: 0 - p", 105, 525);
		
		g.drawString("Roll PID configuration increase/decrease :", 5, 540);
		g.drawString("P: J - ,", 5, 555);
		g.drawString("I: K - ;", 55, 555);
		g.drawString("D: L - :", 105, 555);
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
	
	public void paintPIDBar(Graphics g, Color c,int x,int y,String name,double maxHeight,double currentHeight){
		int w=20;
		g.setColor(c);
		g.setColor(Color.yellow);
		g.drawRect(x-1, y-1, w+1, (int)maxHeight+1);
		g.setColor(c);
		g.fillRect(x, y, w, (int) maxHeight);
		g.setColor(Color.black);
		g.fillRect(x, y, w,
				(int) (maxHeight-(currentHeight)/((maxHeight)/currentHeight)));
		g.setColor(c);
		g.drawString(name, x-20, (int) (y+maxHeight+25));
	}
	
	public void paintRollBar(Graphics g,Color c,int x,int y,int w,int h){
		g.setColor(Color.white);
		g.drawRect(x-1, y-1, 2*w+1, h+1);
		g.setColor(c);
		//g.fillRect(100, 10, 50, 20);
		//g.fillRect(100, 50, 50, 20);
		double r=config.getRollError();
		double ratio=w/config.MAX_ERROR;
		if(r>=0)
			g.fillRect(x+w, y, (int) (r*ratio), h);
		else
			g.fillRect(x+w+(int)(r*ratio), y,(int) (-r*ratio), h);
		g.setColor(Color.white);
		g.drawString("RollE :"+r, (int) (x+2*w-0.2*w), y+h+15);
	}
	public void paintPitchBar(Graphics g,Color c,int x,int y,int w,int h){
		g.setColor(Color.white);
		g.drawRect(x-1, y-1, w+1, 2*h+1);
		g.setColor(c);
		//g.fillRect(100, 10, 50, 20);
		//g.fillRect(100, 50, 50, 20);
		double p=config.getPitchError();
		double ratio=h/config.MAX_ERROR;
		if(p<0)
			g.fillRect(x, y+h, w, (int) (-p*ratio));
		else
			g.fillRect(x, y+h-(int)(p*ratio),w, (int) (p*ratio));
		g.drawString("PitchE :"+p, (int) (x-15), y-15);
	}
}
