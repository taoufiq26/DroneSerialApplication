
public class PIDConfiguration {
	public static double MAX_KP=20;
	public static double MIN_KP=0;
	public static double MAX_KI=20;
	public static double MIN_KI=0;
	public static double MAX_KD=200;
	public static double MIN_KD=0;
	
	
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
	
	
}
