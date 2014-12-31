
public class Main {
	public static void main(String args[]){
		QuadController ctrl=new QuadController();
		try {
			//ctrl.connect("COM8");
			Thread t=new Thread(ctrl);
			t.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
