
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sun.xml.internal.ws.resources.SenderMessages;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
   
public class QuadController extends JFrame implements Runnable{  
    QuadConfig quadConfig;
    KeyboardListner keyboardListner;
    MyMouseListner mouseListener;
    GraphicInterface graphicInterface;
    JButton pitchController;
	public QuadController(){
		try {
			connect("COM8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	setVisible(true);
    	setSize(600, 400);
    	setResizable(false);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	quadConfig=new QuadConfig();
    	keyboardListner= new KeyboardListner(quadConfig);
    	mouseListener=new MyMouseListner(quadConfig);
    	graphicInterface=new GraphicInterface(quadConfig);
    	graphicInterface.repaint();
    	addKeyListener(keyboardListner);
    	addMouseListener(mouseListener);
    	setContentPane(graphicInterface);
    }
    public void connect(String portName) throws Exception {  
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);  
   
        if (portIdentifier.isCurrentlyOwned()) {  
            System.out.println("Port in use!");  
        } else {  
            // points who owns the port and connection timeout  
            SerialPort serialPort = (SerialPort) portIdentifier.open("RS232Example", 2000);  
              
            // setup connection parameters  
            serialPort.setSerialPortParams(  
                38400, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);  
   
            // setup serial port writer  
            CommPortSender.setWriterStream(serialPort.getOutputStream());  
              
            // setup serial port reader  
            new CommPortReceiver(serialPort.getInputStream()).start();  
        }  
    } 
 
    
    static void SendMessage(String msg){
    	 CommPortSender.send(new ProtocolImpl().getMessage(msg));  
    }

	@Override
	
	public void run() {
		
		while(true){
		graphicInterface.repaint();
		// TODO Auto-generated method stub
		if(quadConfig.isSpeedUp()){
			SendMessage("19");
			quadConfig.addSpeed();
		}
		if(quadConfig.isSpeedDown()){
			SendMessage("20");
			quadConfig.subSpeed();
		}
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Speed : "+quadConfig.getSpeed());
		}
		
	}


  
}  