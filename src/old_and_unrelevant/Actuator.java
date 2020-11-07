package old_and_unrelevant;
import old_and_unrelevant.Device;

public class Actuator extends Device {
	String name;
	String type;
	boolean someBool;
	double someDouble;
	int someInt;
	
	Actuator(String names){
		name = names;			
	}
	Actuator(String names, int someInt){
		name = names;		
		this.someInt = someInt;
		this.type = "double";
	}
	Actuator(String names, boolean someBool){		
		name = names;
		this.someBool = someBool;
		this.type = "boolean";
	}
	Actuator(String names, double someDouble){
		name = names;
		this.someDouble = someDouble;
		this.type = "double";
	}
}
