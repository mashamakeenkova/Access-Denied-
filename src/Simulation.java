import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) throws FileNotFoundException {
		
	Scanner scan = new Scanner(new File("Sensors_input.txt"));
	
	while (scan.hasNextLine()) {
		
	String line = scan.nextLine();
    Scanner lineScan = new Scanner(line);
    String identity = lineScan.next();
    identity = identity.toLowerCase();
    Map<String, Sensor> map = new HashMap<String, Sensor>();
    Map<String, Actuator> maps = new HashMap<String, Actuator>();
    
    if(identity.equals("sensor")) {
    	String name = lineScan.next();
    	if(lineScan.hasNext()) {
    		String anInput = lineScan.next();
    		anInput = anInput.toLowerCase();
    		if(anInput.equals("boolean")) {
    			boolean aBool = false;
    			Sensor sensor = new Sensor(name, aBool);
    	    	map.put(name, sensor);
    	    	System.out.println(identity + " called " + sensor.name + 
    	    			" has been made, and it has boolean attribute set to " + map.get(name).someBool);
    		}else {
    	    	Sensor sensor = new Sensor(name);
    	    	map.put(name, sensor);
    	    	System.out.println(identity + " called " + sensor.name + " has been made");
    	    	}
    	}else {
    	Sensor sensor = new Sensor(name);
    	map.put(name, sensor);
    	System.out.println(identity + " called " + sensor.name + " has been made");
    	}
    	
    }
    else if(identity.equals("actuator")) {
    	String name = lineScan.next();
    	Actuator actuator = new Actuator(name);
    	maps.put(name, actuator);
    	System.out.println(identity + " called " + actuator.name + " has been made");
    	
    }
    else {
    	System.out.println("make sure all your devices are either sensors or actuators and try again.");
    }
    
	}
	}
}
