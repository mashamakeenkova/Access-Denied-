import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulation {
	public static void main(String[] args) throws FileNotFoundException {
		
	Scanner scan = new Scanner(new File("Sensors_input.txt"));
	String line = scan.nextLine();
    Scanner lineScan = new Scanner(line);
    String identity = lineScan.next();
    //System.out.println(identity);
    identity = identity.toLowerCase();
    System.out.println(identity);
    
    if(identity == "sensor") {
    	System.out.println(identity);
    }
    
	}
}
