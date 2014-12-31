import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardListner implements KeyListener{
	QuadConfig quadConfig;
	public KeyboardListner(QuadConfig quadConfig) {
		// TODO Auto-generated constructor stub
		this.quadConfig=quadConfig;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_Z){
			quadConfig.setSpeedUp(true);
		}
		if(e.getKeyCode()==KeyEvent.VK_S)
			quadConfig.setSpeedDown(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_Z)
			quadConfig.setSpeedUp(false);
		if(e.getKeyCode()==KeyEvent.VK_S)
			quadConfig.setSpeedDown(false);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
