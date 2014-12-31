


public class StartProgram {
	public static void main (String[] args){
		Thread t=new Thread(new ControllerFrame());
		t.start();
		
	}
}
