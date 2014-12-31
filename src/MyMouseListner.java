import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MyMouseListner implements MouseListener{
	QuadConfig config;
	
	public MyMouseListner(QuadConfig config) {
		// TODO Auto-generated constructor stub
		this.config=config;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("clicked "+e.getX()+" "+e.getY());
		if(e.getY()>=30 && e.getY()<=50 && e.getX()>=3 && e.getX()<=25){
			System.out.println("Send 23");
			config.setPitchOn(!config.isPitchOn());
		}
		if(e.getY()>=55 && e.getY()<=75 && e.getX()>=3 && e.getX()<=25){
			System.out.println("Send 24");
			config.setRollOn(!config.isRollOn());
		}
		if(e.getY()>=80 && e.getY()<=100 && e.getX()>=3 && e.getX()<=25){
			System.out.println("clicked"+e.getX()+e.getY());
			config.setYawOn(!config.isYawOn());
			
		}
		
		if(e.getY()>=120 && e.getY()<=180 && e.getX()>=3 && e.getX()<=80){
			config.setQuadOn(!config.isQuadOn());
			if(config.isQuadOn()){
				System.out.println("send 23 24");
				SendMessage("23");
				SendMessage("24");
			}
			else{
				System.out.println("send 22");
				SendMessage("22");
			}
		}
		
	}
	
	static void SendMessage(String msg){
   	 CommPortSender.send(new ProtocolImpl().getMessage(msg));  
   }

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
