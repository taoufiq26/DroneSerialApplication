


public class StartProgram {
	public static void main (String[] args){
		Thread t=new Thread(new ControllerFrame());
		t.start();
		Thread t2=new Thread(new OffsetRegulator());
		t2.start();
	}
}
