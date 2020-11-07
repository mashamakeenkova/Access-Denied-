import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) throws FileNotFoundException {
		
	Scanner scan = new Scanner(new File("Sensors_input.txt"));
	
	
	//while (scan.hasNextLine()) {
		
	//String line = scan.nextLine();
    //Scanner lineScan = new Scanner(line);
    //String identity = lineScan.next();
    //identity = identity.toLowerCase();
    
    
    Sensor[] devices = new Sensor[scan.nextInt()];
	
	 for(int i = -1; i < devices.length; i++) {
		 System.out.println("called");
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

	    		//if input-guy decides the sensor has a bool-something something
	    		boolean aBool = false;
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
	}
}
