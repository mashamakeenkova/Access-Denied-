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
    	//if input-guy decides they want a sensor
    	
    	String name = lineScan.next();
    	
    	if(lineScan.hasNext()) {
    		//if Input-guy knows what he wants (or thinks he does)
    		String anInput = lineScan.next();
    		anInput = anInput.toLowerCase();
    		
    		if(anInput.equals("boolean")) {
    			//if input-guy decides the sensor has a bool-something something
    			boolean aBool = false;
    			Sensor sensor = new Sensor(name, aBool);
    	    	map.put(name, sensor);
    	    	System.out.println(identity + " called " + sensor.name + 
    	    			" has been made, and it has boolean attribute set to " + map.get(name).someBool);
    		}
    		
    		else if(anInput.equals("int")) {
    			//if input-guy decides the sensor has a int-something something
    			int aInt = 0;
    	    	if(lineScan.hasNextInt()) {
    	    		//if Input-guy initialises the variable on the go
    	    		int firstInt = lineScan.nextInt();
    	    		aInt = firstInt;
    	    		}
    	    	Sensor sensor = new Sensor(name, aInt);
    	    	map.put(name, sensor);
    	    	System.out.println(identity + " called " + sensor.name + " has been made, and it has integer attribute set to " + map.get(name).someInt);
    		}
    		
    		else if(anInput.equals("double")) {
    			//if input-guy decides the sensor has a int-something something
    			double aDouble = 0.0; 
    	    	if(lineScan.hasNextDouble()) {
    	    		//if Input-guy initialises the variable on the go
    	    		System.out.println("Huston, we have a double");
    	    		double firstDouble = lineScan.nextDouble();
    	    		aDouble = firstDouble;
    	    		}
    	    	Sensor sensor = new Sensor(name, aDouble);
    	    	map.put(name, sensor);
    	    	System.out.println(identity + " called " + sensor.name + " has been made, and it has double attribute set to " + map.get(name).someInt);
    		}
    		
    		else {
    			//if input-guy is too dumb to define a proper input
    			//or if I am to dumb to handle it
    	    	Sensor sensor = new Sensor(name);
    	    	map.put(name, sensor);
    	    	System.out.println(identity + " called " + sensor.name + " has been made");
    	    	}
    		
    	}else {
    	//if Input-guy is just lost and typing weird s**t without attributes to set
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
