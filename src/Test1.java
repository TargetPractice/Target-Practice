import wiiremotej.WiiRemote;

public class Test1{
	public static void main(String[] args){
		BluetoothInterface face = new BluetoothInterface();
		try{
		WiiRemote test = face.findRemote();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}

