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
		config = new QuadConfiguration(serial);
		panel = new ControllerPanel(config);
		klistener = new CustomKeyListner(config);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
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
				
				panel.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
