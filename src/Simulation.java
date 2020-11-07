import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) throws FileNotFoundException {
		
	Scanner scan = new Scanner(new File("Sensors_input.txt"));
	
	while (scan.hasNextLine()) {
	String line = scan.nextLine();
    Scanner lineScan = new Scanner(line);
    String identity = lineScan.next();
    identity = identity.toLowerCase();
    
    
    if(identity.equals("sensor")) {
    	System.out.println(identity);
    }
    else if(identity.equals("actuator")) {
    	System.out.println(identity);
    }
    else {
    	System.out.println("make sure all your devices are either sensors or actuators and try again.");
    }
    
	}
	}
}
