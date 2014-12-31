
public class PIDConfiguration {
	SerialCommunication serial;
	
	public PIDConfiguration(SerialCommunication serial) {
		this.serial=serial;
	}
	public static double MAX_KP=20;
	public static double MIN_KP=0;
	public static double MAX_KI=10;
	public static double MIN_KI=0;
	public static double MAX_KD=200;
	public static double MIN_KD=0;
	public static double KP_STEP=0.1;
	public static double KD_STEP=1;
	public static double KI_STEP=0.01;
	
	//PID CONTROLLE
	private double KPP=0;
	private double KDP=0;
	private double KIP=0;
	
	private double KPR=0;
	private double KDR=0;
	private double KIR=0;
	
	private boolean kppUp=false;
	private boolean kdpUp=false;
	private boolean kipUp=false;
	
	private boolean kppDown=false;
	private boolean kdpDown=false;
	private boolean kipDown=false;
	
	private boolean kprUp=false;
	private boolean kdrUp=false;
	private boolean kirUp=false;
	
	private boolean kprDown=false;
	private boolean kdrDown=false;
	private boolean kirDown=false;
	
	public void addKpp(){
		KPP+=KP_STEP;
		if(KPP>MAX_KP)
			KPP=MAX_KP;
		else{
			serial.send("ajout KP PITCH");
		}
	}
	public void decKpp(){
		KPP-=KP_STEP;
		if(KPP<MIN_KP)
			KPP=MIN_KP;
		else{
			serial.send("decrease KP PITCH");
		}
	}
	
	public void addKdp(){
		KDP+=KD_STEP;
		if(KDP>MAX_KD)
			KDP=MAX_KD;
		else{
			serial.send("ajout KD PITCH");
		}
	}
	public void decKdp(){
		KDP-=KD_STEP;
		if(KDP<MIN_KD)
			KDP=MIN_KD;
		else{
			serial.send("decrease KD PITCH");
		}
	}
	
	public void addKip(){
		KIP+=KI_STEP;
		if(KIP>MAX_KI)
			KIP=MAX_KI;
		else{
			serial.send("ajout KI PITCH");
		}
	}
	public void decKip(){
		KIP-=KI_STEP;
		if(KIP<MIN_KI)
			KIP=MIN_KI;
		else{
			serial.send("decrease KI PITCH");
		}
	}
	
	public void addKpr(){
		KPR+=KP_STEP;
		if(KPR>MAX_KP)
			KPR=MAX_KP;
		else{
			serial.send("ajout KP ROLL");
		}
	}
	public void decKpr(){
		KPR-=KP_STEP;
		if(KPR<MIN_KP)
			KPR=MIN_KP;
		else{
			serial.send("decrease KP ROLL");
		}
	}
	
	public void addKdr(){
		KDR+=KD_STEP;
		if(KDR>MAX_KD)
			KDR=MAX_KD;
		else{
			serial.send("ajout KD ROLL");
		}
	}
	public void decKdr(){
		KDR-=KD_STEP;
		if(KDR<MIN_KD)
			KDR=MIN_KD;
		else{
			serial.send("decrease KD ROLL");
		}
	}
	
	public void addKir(){
		KIR+=KI_STEP;
		if(KIR>MAX_KI)
			KIR=MAX_KI;
		else{
			serial.send("ajout KI ROLL");
		}
	}
	public void decKir(){
		KIR-=KI_STEP;
		if(KIR<MIN_KI)
			KIR=MIN_KI;
		else{
			serial.send("decrease KI ROLL");
		}
	}

	public boolean isKppUp() {
		return kppUp;
	}
	public void setKppUp(boolean kppUp) {
		this.kppUp = kppUp;
	}
	public boolean isKdpUp() {
		return kdpUp;
	}
	public void setKdpUp(boolean kdpUp) {
		this.kdpUp = kdpUp;
	}
	public boolean isKipUp() {
		return kipUp;
	}
	public void setKipUp(boolean kipUp) {
		this.kipUp = kipUp;
	}
	public boolean isKppDown() {
		return kppDown;
	}
	public void setKppDown(boolean kppDown) {
		this.kppDown = kppDown;
	}
	public boolean isKdpDown() {
		return kdpDown;
	}
	public void setKdpDown(boolean kdpDown) {
		this.kdpDown = kdpDown;
	}
	public boolean isKipDown() {
		return kipDown;
	}
	public void setKipDown(boolean kipDown) {
		this.kipDown = kipDown;
	}
	public boolean isKprUp() {
		return kprUp;
	}
	public void setKprUp(boolean kprUp) {
		this.kprUp = kprUp;
	}
	public boolean isKdrUp() {
		return kdrUp;
	}
	public void setKdrUp(boolean kdrUp) {
		this.kdrUp = kdrUp;
	}
	public boolean isKirUp() {
		return kirUp;
	}
	public void setKirUp(boolean kirUp) {
		this.kirUp = kirUp;
	}
	public boolean isKprDown() {
		return kprDown;
	}
	public void setKprDown(boolean kprDown) {
		this.kprDown = kprDown;
	}
	public boolean isKdrDown() {
		return kdrDown;
	}
	public void setKdrDown(boolean kdrDown) {
		this.kdrDown = kdrDown;
	}
	public boolean isKirDown() {
		return kirDown;
	}
	public void setKirDown(boolean kirDown) {
		this.kirDown = kirDown;
	}
	public double getKPP() {
		return KPP;
	}
	public double getKDP() {
		return KDP;
	}
	public double getKIP() {
		return KIP;
	}
	public double getKPR() {
		return KPR;
	}
	public double getKDR() {
		return KDR;
	}
	public double getKIR() {
		return KIR;
	}
	
	
	
}
