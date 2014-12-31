import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class CustomKeyListner implements KeyListener{
	QuadConfiguration config;
	public CustomKeyListner(QuadConfiguration config) {
		// TODO Auto-generated constructor stub
		this.config=config;
	}
	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode()==e.VK_Z)
			config.setGoingUp(true);
		
		if(e.getKeyCode()==e.VK_S)
			config.setGoingDown(true);
		
		if(e.getKeyCode() == e.VK_8) // adding kp pitch
			config.getPidConfig().setKppUp(true);
		if(e.getKeyCode() == e.VK_I) // adding kp pitch
			config.getPidConfig().setKppDown(true);
		
		if(e.getKeyCode() == e.VK_9) // adding kp pitch
			config.getPidConfig().setKipUp(true);
		
		if(e.getKeyCode() == e.VK_O) // adding kp pitch
			config.getPidConfig().setKipDown(true);
		
		if(e.getKeyCode() == e.VK_0) // adding kp pitch
			config.getPidConfig().setKdpUp(true);
		if(e.getKeyCode() == e.VK_P) // adding kp pitch
			config.getPidConfig().setKdpDown(true);
		
		//ROLL PID INCREASING
		if(e.getKeyCode() == e.VK_J) // decrease kp pitch
			config.getPidConfig().setKprUp(true);
		if(e.getKeyCode() == e.VK_COMMA) // decrease kp pitch
			config.getPidConfig().setKprDown(true);
		
		if(e.getKeyCode() == e.VK_K) // decrease kp pitch
			config.getPidConfig().setKirUp(true);
		if(e.getKeyCode() == e.VK_SEMICOLON) // decrease kp pitch
			config.getPidConfig().setKirDown(true);
		
		if(e.getKeyCode() == e.VK_L) // decrease kp pitch
			config.getPidConfig().setKdrUp(true);
		if(e.getKeyCode() == e.VK_COLON) // decrease kp pitch
			config.getPidConfig().setKdrDown(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_Z)
			config.setGoingUp(false);
		
		if(e.getKeyCode()==e.VK_S)
			config.setGoingDown(false);
		
		//PID PITCH
		if(e.getKeyCode() == e.VK_8) // decrease kp pitch
			config.getPidConfig().setKppUp(false);
		if(e.getKeyCode() == e.VK_I) // decrease kp pitch
			config.getPidConfig().setKppDown(false);
		
		if(e.getKeyCode() == e.VK_9) // decrease kp pitch
			config.getPidConfig().setKipUp(false);
		if(e.getKeyCode() == e.VK_O) // decrease kp pitch
			config.getPidConfig().setKipDown(false);
		
		if(e.getKeyCode() == e.VK_0) // decrease kp pitch
			config.getPidConfig().setKdpUp(false);
		if(e.getKeyCode() == e.VK_P) // decrease kp pitch
			config.getPidConfig().setKdpDown(false);
		
		//PID ROLL
		
		if(e.getKeyCode() == e.VK_J) // decrease kp pitch
			config.getPidConfig().setKprUp(false);
		if(e.getKeyCode() == e.VK_COMMA) // decrease kp pitch
			config.getPidConfig().setKprDown(false);
		
		if(e.getKeyCode() == e.VK_K) // decrease kp pitch
			config.getPidConfig().setKirUp(false);
		if(e.getKeyCode() == e.VK_SEMICOLON) // decrease kp pitch
			config.getPidConfig().setKirDown(false);
		
		if(e.getKeyCode() == e.VK_L) // decrease kp pitch
			config.getPidConfig().setKdrUp(false);
		if(e.getKeyCode() == e.VK_COLON) // decrease kp pitch
			config.getPidConfig().setKdrDown(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
