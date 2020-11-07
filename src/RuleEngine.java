import java.util.*;
import java.io.*;

public class RuleEngine {

    public static void main(String[] args ) throws FileNotFoundException{
        
    	// it is assumed that all sensors and actuators have already been created
    	// and that names of sensors/actuators are correct
        
    	// read input from file
    	// input of the form: SensorName, attributeValue (boolean or double, i.e true/false or >/<double),
        // ActuatorName, value (boolean, double)
        // where SensorName, attributeValue is "if" and rest is statement
        // trivial if attributeValue is boolean (if,else)
        // what if attributeValue is a double? then we want to know if it is above or below
        // a certain value -> add < or > before double value
        
        // what about multiple inputs/outputs?
        
        Scanner fileInput = new Scanner(new File("RuleInput.txt"));
            

        while (fileInput.hasNextLine()) {

        	String line = fileInput.nextLine();
        	Scanner scan_line = new Scanner(line);
        	// each line must contain the following variables (in this order):
        	String sensor_name = scan_line.next();
        	String valueS = scan_line.next();
        	String actuator_name = scan_line.next();
        	String valueA = scan_line.next();

        	// check if sensor and actuator have been initialized
        	if (!map.containsKey(sensor_name)) {
        		return; // Error 
        	}
        	if (!maps.containsKey(actuator_name)) {
        		return; // Error
        	}
    
    
        	// check value of sensor
        	String sensor_value = "" + map.get(sensor_name).ATTRIBUTE
        			// check if condition is true
        			// CASE 1: valueS is boolean
        			if (valueS.equals("true") || valueS.equals("false")) {
        				if (sensor_value.equals(valueS)) {
        					// change actuator value
        					// actuator is boolean
        					try {
        						maps.get(actuator_name).ATTRIBUTE = Boolean.parseBoolean(valueA); continue;
        					}
        					catch(NumberFormatException ex) {}
        					// actuator is double
        					try {
        						maps.get(actuator_name).ATTRIBUTE = Double.parseDouble(valueA); continue;
        					}
        					catch(NumberFormatException ex) {
        						// not boolean AND not double
        						return; // Error
        					}
        				}
        			}
        	// CASE 2: valueS is double
        	// must start with either ">", "=" or "<"
        	if (!valueS.startsWith(">") || !valueS.startsWith("=") || !valueS.startsWith("<")) {
        		return; // Error
        	}
        	// try parsing the number to a double
        	double valueS_double;
        	try {
        		valueS_double = Double.parseDouble(valueS.substring(1,valueS.length()));
        	}
        	catch(NumberFormatException ex) {
        		return; // Error
        	}
        	// check that sensor attribute is of type double
        	if (!(map.get(sensor_name).ATTRIBUTE instanceof Double)) {
        		return; // Error
        	}

        	// compare valueS_double to attribute of sensor in hashmap

        	switch(valueS.substring(0, 1)) {
        	case ">": {if (map.get(sensor_name).ATTRIBUTE <= valueS_double) {
        		continue; // (condition hasn't been met)
        		}
        	}
        	case "=": { if (map.get(sensor_name).ATTRIBUTE != valueS_double) {
        		continue; // (condition hasn't been met)
        		}
        	}
        	case "<": { if (map.get(sensor_name).ATTRIBUTE >= valueS_double) {
        		continue; // (condition hasn't been met)
        		}
        	}
        	} // end switch
        	
        	// arriving here means that the condition has been met
        	// change actuator value
        	// actuator is boolean
        	try {
        		maps.get(actuator_name).ATTRIBUTE = Boolean.parseBoolean(valueA); continue;
        	}
        	catch(NumberFormatException ex) { }
        	// actuator is double
        	try {
        		maps.get(actuator_name).ATTRIBUTE = Double.parseDouble(valueA); continue;
        	}
        	catch(NumberFormatException ex) {
        		// not boolean AND not double
        		return; // Error
        	}
        }
    }
}