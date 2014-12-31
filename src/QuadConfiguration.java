
public class QuadConfiguration {
	//CONFIGURATION STEPS AND RANGES
	
	public static int MIN_SPEED=700;
	public static int MAX_SPEED=2000;
	public static double speedStep=10;
	
	//CONFIGURATION STATE
	
	//SPEED
	private int speed=MIN_SPEED;
	private boolean goingUp=false;
	private boolean goingDown=false;
	

	
	
	SerialCommunication serial;
	public QuadConfiguration(SerialCommunication serial){
		this.serial=serial;
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
			serial.send("sending add speed");
	}
	public void decSpeed(){
		speed-=speedStep;
		if(speed<MIN_SPEED)
			speed=MIN_SPEED;
		else
			serial.send("sending remove speed");
	}
	public int getSpeed(){
		return speed;
	}
	
	
}
