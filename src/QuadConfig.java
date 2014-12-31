
public class QuadConfig {
	private boolean speedUp=false;
	private boolean speedDown=false;
	private int speed=700;
	private boolean pitchOn=false;
	private boolean rollOn=false;
	private boolean yawOn=false;
	private boolean quadOn=false;
	public boolean isSpeedUp() {
		return speedUp;
	}
	public void setSpeedUp(boolean speedUp) {
		this.speedUp = speedUp;
	}
	public boolean isSpeedDown() {
		return speedDown;
	}
	public void setSpeedDown(boolean speedDown) {
		this.speedDown = speedDown;
	}
	public void addSpeed(){
		speed++;
		if(speed>2000) speed=2000;
	}
	public void subSpeed(){
		speed--;
		if(speed<700) speed=700;
	}
	public int getSpeed(){
		return speed;
	}
	public boolean isRollOn() {
		return rollOn;
	}
	public void setRollOn(boolean rollOn) {
		this.rollOn = rollOn;
	}
	public boolean isPitchOn() {
		return pitchOn;
	}
	public void setPitchOn(boolean pitchOn) {
		this.pitchOn = pitchOn;
	}
	public boolean isYawOn() {
		return yawOn;
	}
	public void setYawOn(boolean yawOn) {
		this.yawOn = yawOn;
	}
	public boolean isQuadOn() {
		return quadOn;
	}
	public void setQuadOn(boolean quadOn) {
		this.quadOn = quadOn;
	}
	
	
}
