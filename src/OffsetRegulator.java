
public class OffsetRegulator implements Runnable{
	public static int SPEED=40;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		QuadConfiguration config=QuadConfiguration.getInstance();
		while(true){
			if(!config.isAddingPitchError() && !config.isDecPitchError()){
				if(config.getPitchError()>0){
					config.decPitchError();
				}else if(config.getPitchError()<0){
					config.addPitchError();
				}
				if(config.getPitchError()>=-0.5 && config.getPitchError()<=0.5 && config.getPitchError()!=0){
					SerialCommunication.getInstance().send(""+Messages.CLR_POFFSET);
					config.setPitchError(0);
				}
				
			}
			
			if(!config.isAddingRollError() && !config.isDecRollError()){
				if(config.getRollError()>0){
					config.decRollError();
				}else if(config.getRollError()<0){
					config.addRollError();
				}
				if(config.getRollError()>=-0.5 && config.getRollError()<=0.5 && config.getRollError()!=0){
					SerialCommunication.getInstance().send(""+Messages.CLR_POFFSET);
					config.setRollError(0);
				}
			}
			try {
				Thread.sleep(SPEED);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
