import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Actuator> actuatorMap = getActuators();
		Map<String, Sensor> sensorMap = getScanners();
		RuleEngine.run(actuatorMap, sensorMap);
	}
		
	private static Map<String, Actuator> getActuators() throws FileNotFoundException{
		Scanner scan = new Scanner(new File("Actuators_input.txt"));
		 
	    Actuator[] acuDevices = new Actuator[scan.nextInt()];
		
		 for(int i = -1; i < acuDevices.length; i++) {
			 
			 String line = scan.nextLine();
			 Scanner lineScan = new Scanner(line);
			 
			 if(lineScan.hasNext()) {
		    	//if Input-guy knows what he wants (or thinks he does)
		    	String anInput = lineScan.next();
		    	anInput = anInput.toLowerCase();
		    		
		    	if(anInput.equals("actuator")) {
		    		
		    		
		    		if(lineScan.hasNext()) {
		    			String name = lineScan.next();
		    	    	//if Input-guy knows what he wants (or thinks he does)
		    	    	String variableType = lineScan.next();
		    	    	anInput = anInput.toLowerCase();
		    	    	variableType = variableType.toLowerCase();
		    	    	
		    		
		    		if(variableType.equals("boolean")) {

			    		//if input-guy decides the sensor has a bool-something something
			    		boolean aBool = false;
			    		
			    		if(lineScan.hasNextBoolean()) {
		    	    		//if Input-guy initialises the variable on the go
		    	    		aBool = lineScan.nextBoolean();
		    	    	}
			    		
			    		Actuator actuator = new Actuator(name, aBool);
			    		acuDevices[i] = actuator;
			    	    System.out.println(anInput + " called " + acuDevices[i].name);
		    		}
		    		else if(variableType.equals("double")||variableType.equals("int")) {

			    		//if input-guy decides the sensor has a bool-something something
			    		double aDouble = 0.0;
			    		
			    		if(lineScan.hasNextDouble()) {
		    	    		//if Input-guy initialises the variable on the go
		    	    		double firstDouble = lineScan.nextDouble();
		    	    		aDouble = firstDouble;
		    	    		}

			    		Actuator actuator = new Actuator(name, aDouble);
			    		acuDevices[i] = actuator;
			    	    System.out.println(anInput + " called " + acuDevices[i].name + "with value " + acuDevices[i].someDouble);
			    	    
			    		}
		    		}
		    	}
	   
			 }
		 
		}
		 Map<String, Actuator> sensorMap = new HashMap<String, Actuator>();
		 
		 for( int i = 0; i < acuDevices.length; i++ ){
			    System.out.println(i);
			    sensorMap.put( acuDevices[0].name, acuDevices[0] );
			    System.out.println(sensorMap.get(acuDevices[0].name).name);
			}
		return sensorMap;
		
	}
		

	private static Map<String, Sensor> getScanners() throws FileNotFoundException{
		
		Scanner scan = new Scanner(new File("Sensors_input.txt"));   
	    Sensor[] devices = new Sensor[scan.nextInt()];
		
		 for(int i = -1; i < devices.length; i++) {
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
		    	    	variableType = variableType.toLowerCase();
		    	    	
		    		
		    		if(variableType.equals("boolean")) {
		    			
			    		boolean aBool = false;

			    		//if input-guy decides the sensor has a bool-something something

			    		if(lineScan.hasNextBoolean()) {
		    	    		//if Input-guy initialises the variable on the go
		    	    		aBool = lineScan.nextBoolean();
		    	    	}
			    		Sensor sensor = new Sensor(name, aBool);
			    		devices[i] = sensor;
			    	    System.out.println(anInput + " called " + devices[i].name);
		    		}
		    		else if(variableType.equals("double")||variableType.equals("int")) {

			    		//if input-guy decides the sensor has a bool-something something
			    		double aDouble = 0.0;
			    		
			    		if(lineScan.hasNextDouble()) {
		    	    		//if Input-guy initialises the variable on the go
		    	    		double firstDouble = lineScan.nextDouble();
		    	    		aDouble = firstDouble;
		    	    		}

			    		Sensor sensor = new Sensor(name, aDouble);
			    		devices[i] = sensor;
			    	    System.out.println(anInput + " called " + devices[i].name + "with value " + devices[i].someDouble);
			    	    
			    		}
		    	}
		    }
	   
		}
		 
		}
		 Map<String, Sensor> sensorMap = new HashMap<String, Sensor>();
		 
		 for( int i = 0; i < devices.length; i++ ){
			    System.out.println(i);
			    sensorMap.put( devices[i].name, devices[i] );
			    System.out.println(sensorMap.get(devices[i].name).name);
			}
		return sensorMap;
		
	}
}
