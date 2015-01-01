
public class QuadConfiguration {
	//CONFIGURATION STEPS AND RANGES
	
	public static int MIN_SPEED=700;
	public static int MAX_SPEED=2000;
	public static double speedStep=10;
	
	public static double MAX_ERROR=40;
	public static double MIN_ERROR=-40;
	public static double ERROR_STEP=0.5;
	//CONFIGURATION STATE
	// START AND STOP
	private boolean ON=false;
	//SPEED
	private int speed=MIN_SPEED;
	private boolean goingUp=false;
	private boolean goingDown=false;
	
	//ROLL AND PITCH ERRORS
	private double rollError=0;
	private double pitchError=0;
	private boolean addingPitchError=false;
	private boolean decPitchError=false;
	private boolean addingRollError=false;
	private boolean decRollError=false;
	
	SerialCommunication serial;
	PIDConfiguration pidConfig;
	public QuadConfiguration(SerialCommunication serial){
		this.serial=serial;
		pidConfig=new PIDConfiguration(serial);
		initialize();
		pidConfig.setToZero();
	}
	public boolean isGoingUp() {
		return goingUp;
	}
	public void setGoingUp(boolean goingUp) {
		this.goingUp = goingUp;
	}
	public boolean isGoingDown() {
		return goingDown;
	}
	public void setGoingDown(boolean goingDown) {
		this.goingDown = goingDown;
	}
	public void addSpeed(){
		speed+=speedStep;
		if(speed>MAX_SPEED)
			speed=MAX_SPEED;
		else
			serial.send(""+Messages.ADD_SPEED);
	}
	public void decSpeed(){
		speed-=speedStep;
		if(speed<MIN_SPEED)
			speed=MIN_SPEED;
		else
			serial.send(""+Messages.DEC_SPEED);
	}
	
	public void addPitchError(){
		pitchError+=ERROR_STEP;
		if(pitchError>MAX_ERROR)
			pitchError=MAX_ERROR;
		else
			serial.send(""+Messages.ADD_PITCHERROR);
	}
	public void decPitchError(){
		pitchError-=ERROR_STEP;
		if(pitchError<MIN_ERROR)
			pitchError=MIN_ERROR;
		else
			serial.send(""+Messages.DEC_PITCHERROR);
	}
	public void addRollError(){
		rollError+=ERROR_STEP;
		if(rollError>MAX_ERROR)
			rollError=MAX_ERROR;
		else
			serial.send(""+Messages.ADD_ROLLERROR);
	}
	public void decRollError(){
		rollError-=ERROR_STEP;
		if(rollError<MIN_ERROR)
			rollError=MIN_ERROR;
		else
			serial.send(""+Messages.DEC_ROLLERROR);
	}
	
	public int getSpeed(){
		return speed;
	}
	public double getRollError() {
		return rollError;
	}
	public void setRollError(double rollError) {
		this.rollError = rollError;
	}
	public double getPitchError() {
		return pitchError;
	}
	public void setPitchError(double pitchError) {
		this.pitchError = pitchError;
	}
	public boolean isDecPitchError() {
		return decPitchError;
	}
	public void setDecPitchError(boolean decPitchError) {
		this.decPitchError = decPitchError;
	}
	public boolean isDecRollError() {
		return decRollError;
	}
	public void setDecRollError(boolean decRollError) {
		this.decRollError = decRollError;
	}
	
	public boolean isAddingPitchError() {
		return addingPitchError;
	}
	public void setAddingPitchError(boolean addingPitchError) {
		this.addingPitchError = addingPitchError;
	}
	public boolean isAddingRollError() {
		return addingRollError;
	}
	public void setAddingRollError(boolean addingRollError) {
		this.addingRollError = addingRollError;
	}
	public PIDConfiguration getPidConfig() {
		return pidConfig;
	}
	public void setPidConfig(PIDConfiguration pidConfig) {
		this.pidConfig = pidConfig;
	}
	public void initialize() {
		// TODO Auto-generated method stub
		speed=MIN_SPEED;
	
	}
	public boolean isON() {
		return ON;
	}
	public void setON(boolean oN) {
		ON = oN;
	}
	public SerialCommunication getSerial(){
		return serial;
	}
	
}
