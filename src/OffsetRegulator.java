
public class OffsetRegulator implements Runnable{
	public static int SPEED=20;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		QuadConfiguration config=QuadConfiguration.getInstance();
		while(true){
			if(!config.isAddingPitchError()){
				if(config.getPitchError()>0){
					config.decPitchError();
				}else if(config.getPitchError()<0){
					config.addPitchError();
				}
			}
			
			if(!config.isAddingRollError() && !config.isDecRollError()){
				if(config.getRollError()>0){
					config.decRollError();
				}else if(config.getRollError()<0){
					config.addRollError();
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
