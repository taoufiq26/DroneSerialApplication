import java.awt.Panel;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class ControllerFrame extends JFrame implements Runnable {
	public static int FRAMESPEED = 30;
	QuadConfiguration config;
	SerialCommunication serial;
	ControllerPanel panel;
	CustomKeyListner klistener;

	public ControllerFrame() {
		SerialCommunication serial = new SerialCommunication();
		serial.initialize();
		config = new QuadConfiguration(serial);
		panel = new ControllerPanel(config);
		klistener = new CustomKeyListner(config);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 600);
		setResizable(false);
		setVisible(true);
		setContentPane(panel);
		addKeyListener(klistener);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				//System.out.println("Speed quad:" + config.getSpeed());
				Thread.sleep(FRAMESPEED);
				if (config.isGoingUp())
					config.addSpeed();

				if (config.isGoingDown())
					config.decSpeed();
				
				if(config.isAddingPitchError())
					config.addPitchError();
				
				if(config.isDecPitchError())
					config.decPitchError();
				
				if(config.isAddingRollError())
					config.addRollError();
				
				if(config.isDecRollError())
					config.decRollError();
				
				//ADING PID PITCH
				if(config.getPidConfig().isKppUp())
					config.getPidConfig().addKpp();
				
				if(config.getPidConfig().isKipUp())
					config.getPidConfig().addKip();
				
				if(config.getPidConfig().isKdpUp())
					config.getPidConfig().addKdp();
				
				//DECREASING PID PITCH
				if(config.getPidConfig().isKppDown())
					config.getPidConfig().decKpp();
				
				if(config.getPidConfig().isKipDown())
					config.getPidConfig().decKip();
				
				if(config.getPidConfig().isKdpDown())
					config.getPidConfig().decKdp();
				
				
				//ADING PID ROLL
				if(config.getPidConfig().isKprUp())
					config.getPidConfig().addKpr();
				
				if(config.getPidConfig().isKirUp())
					config.getPidConfig().addKir();
				
				if(config.getPidConfig().isKdrUp())
					config.getPidConfig().addKdr();
				
				//DECREASING PID ROLL
				if(config.getPidConfig().isKprDown())
					config.getPidConfig().decKpr();
				
				if(config.getPidConfig().isKirDown())
					config.getPidConfig().decKir();
				
				if(config.getPidConfig().isKdrDown())
					config.getPidConfig().decKdr();
				
				panel.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
