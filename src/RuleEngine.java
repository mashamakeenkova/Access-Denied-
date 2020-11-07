import java.util.*;
import java.io.*;
import java.util.Map;

public class RuleEngine {
	
    public static void run(Map<String, Actuator> actuatorMap, Map<String, Sensor> sensorMap) throws FileNotFoundException{
        
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
        
    	while(true) {
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
            	if (!sensorMap.containsKey(sensor_name)) {
            		scan_line.close();
            		return; // Error 
            	}
            	if (!actuatorMap.containsKey(actuator_name)) {
            		scan_line.close();
            		return; // Error
            	}
            	
            	// check type of sensor and actuator
            	String sensor_type = sensorMap.get(sensor_name).type;
            	String actuator_type = actuatorMap.get(actuator_name).type;
            	
            	// CASE 1: sensor is boolean
            	if (sensor_type.equals("boolean")) {
            		if (valueS.equals("" + sensorMap.get(sensor_name).someBool)) {
            			// change actuator value
            			// CASE 1.1: actuator is boolean
            			if (actuator_type.equals("boolean")) {
        					try {
        						actuatorMap.get(actuator_name).someBool = Boolean.parseBoolean(valueA); continue;
        					}
        					catch(NumberFormatException ex) {}
            			}
            			// CASE 1.2: actuator is double
            			else if (actuator_type.equals("double")) {
            				try {
        						actuatorMap.get(actuator_name).someDouble = Double.parseDouble(valueA); continue;
        					}
        					catch(NumberFormatException ex) {
        						// CASE 1.3: neither bool nor double... error :c
        						System.out.println("Actuator is neither boolean nor double; gg on finding the egg.");
        						scan_line.close();
        						return; // Error ;)
        					}
            			}
            		}
            		else {
            			continue;
            		}
            	}
    			// CASE 2: sensor is double
            	// must start with either ">", "=" or "<"
            	if (!valueS.startsWith(">") || !valueS.startsWith("=") || !valueS.startsWith("<")) {
            		System.out.println("Double value needs either <, = or > in front:\n" + line);
            		scan_line.close();
            		return; // Error rip Fs in chat
            	}
            	// try parsing the number to a double
            	double valueS_double;
            	try {
            		valueS_double = Double.parseDouble(valueS.substring(1,valueS.length()));
            	}
            	catch(NumberFormatException ex) {
            		System.out.println("Argument is not a valid type:\n" + line);
            		scan_line.close();
            		return; // Error
            	}
            	// check that sensor attribute is of type double
            	if (!sensor_type.equals("double")) {
            		System.out.println("Sensor type is neither boolean nor double.");
            		scan_line.close();
            		return; // Error
            	}

            	// compare valueS_double to attribute of sensor in hashmap
            	switch(valueS.substring(0, 1)) {
            	case ">": {if (sensorMap.get(sensor_name).someDouble <= valueS_double) {
            		continue; // (condition hasn't been met)
            		}
            	}
            	case "=": { if (sensorMap.get(sensor_name).someDouble != valueS_double) {
            		continue; // (condition hasn't been met)
            		}
            	}
            	case "<": { if (sensorMap.get(sensor_name).someDouble >= valueS_double) {
            		continue; // (condition hasn't been met)
            		}
            	}
            	} // end switch
            	
            	// arriving here means that the condition has been met
            	// change actuator value
            	// CASE 2.1
            	if (actuator_type.equals("boolean")) {
    				try {
    					actuatorMap.get(actuator_name).someBool = Boolean.parseBoolean(valueA); continue;
    				}
    				catch(NumberFormatException ex) {}
    			}
    			// CASE 2.2: actuator is double
    			else if (actuator_type.equals("double")) {
    				try {
    					actuatorMap.get(actuator_name).someDouble = Double.parseDouble(valueA); continue;
    				}
    				catch(NumberFormatException ex) {
    					// CASE 2.3: neither bool nor double... error :c
    					System.out.println("Actuator is neither boolean nor double; this egg is boring.");
    					scan_line.close();
    					return; // Error ;)
    				}
    			}
            }
    	}
    }
}