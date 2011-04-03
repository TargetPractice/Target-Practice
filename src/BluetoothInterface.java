import java.io.IOException;
import java.util.ArrayList;

import wiiremotej.IRLight;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteExtension;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRAccelerationEvent;
import wiiremotej.event.WRButtonEvent;
import wiiremotej.event.WRCombinedEvent;
import wiiremotej.event.WRExtensionEvent;
import wiiremotej.event.WRIREvent;
import wiiremotej.event.WRStatusEvent;
import wiiremotej.event.WiiRemoteListener;

public class BluetoothInterface implements WiiRemoteListener{
	WiiRemote remote;
	Driver driver;
	public BluetoothInterface(Driver driver){
		this.driver = driver;
		remote = null;
	}
	public WiiRemote findRemote() throws IllegalArgumentException, IllegalStateException, IOException{
		System.setProperty("bluecove.jsr82.psm_minimum_off", "true");
			try {
				this.remote = WiiRemoteJ.findRemote();
			}
			catch(Exception e) {
				remote = null;
				WiiRemoteJ.stopFind();
				e.printStackTrace();
				System.out.println("Failed to connect remote. Trying again.");
		}
		this.remote.addWiiRemoteListener(this);
		remote.setIRSensorEnabled(true, WRIREvent.BASIC);
		remote.setLEDIlluminated(0, true);
		remote.setLEDIlluminated(3, true);
		return remote;
	}
	
	  public void IRInputReceived(WRIREvent evt)
	  //This is what triggers the redraw on the system.
	    {
		  ArrayList<Pointz> points = new ArrayList<Pointz>();
	       for (IRLight light : evt.getIRLights())
	        {
	            if (light != null)
	            {
//	                System.out.println("X: "+light.getX());
//	                System.out.println("Y: "+light.getY());
	            	points.add(new Pointz(light.getX(), light.getY(), 0));
	            	
	                
	            }
	            if (points.size() == 2){
	            	driver.update(ShiftCalculator.newPoint(points.get(0), points.get(1),driver.eyera));
	            }
	        }
	    }
	@Override
	public void accelerationInputReceived(WRAccelerationEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void buttonInputReceived(WRButtonEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void combinedInputReceived(WRCombinedEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void disconnected() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void extensionConnected(WiiRemoteExtension arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void extensionDisconnected(WiiRemoteExtension arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void extensionInputReceived(WRExtensionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void extensionPartiallyInserted() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void extensionUnknown() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void statusReported(WRStatusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

