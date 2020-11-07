import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) throws FileNotFoundException {
		
	Scanner scan = new Scanner(new File("Sensors_input.txt"));
	System.out.println("called");
	
	//while (scan.hasNextLine()) {
		
	//String line = scan.nextLine();
    //Scanner lineScan = new Scanner(line);
    //String identity = lineScan.next();
    //identity = identity.toLowerCase();
    
    
    Device[] devices = new Device[scan.nextInt()];
	
	 for(int i = 0; i < devices.length; i++) {
		 String line = scan.nextLine();
		 Scanner lineScan = new Scanner(line);
		 
		 if(lineScan.hasNext()) {
	    	//if Input-guy knows what he wants (or thinks he does)
	    	String anInput = lineScan.next();
	    	anInput = anInput.toLowerCase();
	    		
	    	if(anInput.equals("sensor")) {
	    		
	    		if(lineScan.hasNext()) {
	    			String name = lineScan.next();
	    	    	//if Input-guy knows what he wants (or thinks he does)
	    	    	String variableType = lineScan.next();
	    	    	anInput = anInput.toLowerCase();
	    		
	    		if(variableType.equals("boolean")) {

	    		//if input-guy decides the sensor has a bool-something something
	    		boolean aBool = false;
	    		Sensor sensor = new Sensor(name, aBool);
	    		devices[i].sensor = sensor;
	    	    System.out.println(anInput + " called " + devices[i].sensor.name);
	    		}
	    		}
	    	}
   
		 }
	 
	}
	}
}
