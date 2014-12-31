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
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_Z)
			config.setGoingUp(false);
		
		if(e.getKeyCode()==e.VK_S)
			config.setGoingDown(false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
