import java.io.IOException;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRIREvent;

public class BluetoothInterface {
	public BluetoothInterface(){
		
	}
	public WiiRemote findRemote() throws IllegalArgumentException, IllegalStateException, IOException{
		WiiRemote remote = null;

		while (remote == null) {
			try {
				remote = WiiRemoteJ.findRemote();
			}
			catch(Exception e) {
				remote = null;
				e.printStackTrace();
				System.out.println("Failed to connect remote. Trying again.");
			}
		}
		remote.setIRSensorEnabled(true, WRIREvent.BASIC);
		remote.setLEDIlluminated(0, true);
		remote.setLEDIlluminated(3, true);
		return remote;
	}
	
	  public void IRInputReceived(WRIREvent evt)
	    {
	        /*for (IRLight light : evt.getIRLights())
	        {
	            if (light != null)
	            {
	                System.out.println("X: "+light.getX());
	                System.out.println("Y: "+light.getY());
	            }
	        }*/
	        
	    }
}

