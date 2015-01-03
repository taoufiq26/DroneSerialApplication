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
		
		if(e.getKeyCode()==e.VK_W){
			config.initialize();
			config.pidConfig.setToZero();
			config.setOnPitch(!config.isOnPitch());
			SerialCommunication.getInstance().send(""+Messages.ACTIVATE_PITCH);
		}
		if(e.getKeyCode()==e.VK_X){
			config.initialize();
			config.pidConfig.setToZero();
			config.setOnRoll(!config.isOnRoll());
			
			SerialCommunication.getInstance().send(""+Messages.ACTIVATE_ROLL);
		}
		//START RESTART CONTROLE 
		if(e.getKeyCode()==e.VK_ESCAPE){
			config.initialize();
			config.pidConfig.setToZero();
			config.getSerial().send(""+Messages.SHUTDOWN_QUAD);
			config.setON(false);
			config.setOnRoll(false);
			config.setOnPitch(false);
		}
		if(e.getKeyCode()==e.VK_ENTER){
			if(!config.isON()){
				config.initialize();
				config.pidConfig.initialize();
				config.getSerial().send(""+Messages.RESTART_QUAD);
				config.getSerial().send(""+Messages.ACTIVATE_PITCH);
				config.getSerial().send(""+Messages.ACTIVATE_ROLL);
				config.setOnPitch(true);
				config.setOnRoll(true);
			}else{
				config.initialize();
				config.pidConfig.setToZero();
				config.getSerial().send(""+Messages.SHUTDOWN_QUAD);
				config.setOnPitch(false);
				config.setOnRoll(false);
			}
			config.setON(!config.isON());
			
		}
		//SPEED CONTROLE
		if(e.getKeyCode()==e.VK_Z)
			config.setGoingUp(true);
		
		if(e.getKeyCode()==e.VK_S)
			config.setGoingDown(true);
		
		//ROLL AND PITCH CONTROLE
		if(e.getKeyCode() == e.VK_UP)
			config.setAddingPitchError(true);
		if(e.getKeyCode() == e.VK_DOWN)
			config.setDecPitchError(true);
		
		if(e.getKeyCode() == e.VK_RIGHT)
			config.setAddingRollError(true);
		if(e.getKeyCode() == e.VK_LEFT)
			config.setDecRollError(true);
		
		
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
		
		//ROLL AND PITCH CONTROLE
		if(e.getKeyCode() == e.VK_UP){
			config.setAddingPitchError(false);
			//config.setPitchError(0);
			//config.getSerial().send(""+Messages.CLR_POFFSET);
		}
		if(e.getKeyCode() == e.VK_DOWN){
			config.setDecPitchError(false);
			//config.setPitchError(0);
			//config.getSerial().send(""+Messages.CLR_POFFSET);
		}
		
		if(e.getKeyCode() == e.VK_RIGHT){
			config.setAddingRollError(false);
			//config.setRollError(0);
			//config.getSerial().send(""+Messages.CLR_ROFFSET);
		}
		
		if(e.getKeyCode() == e.VK_LEFT){
			config.setDecRollError(false);
			//config.setRollError(0);
			//config.getSerial().send(""+Messages.CLR_ROFFSET);
		}
		
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
