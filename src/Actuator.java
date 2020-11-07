
public class Actuator extends Device {
	String name;
	String state;
	boolean someBool;
	double someDouble;
	int someInt;
	
	Actuator(String names){
		name = names;			
	}
	Actuator(String names, int someInt){
		name = names;		
		this.someInt = someInt;
		this.state = "int";
	}
	Actuator(String names, boolean someBool){		
		name = names;
		this.someBool = someBool;
		this.state = "boolean";
	}
	Actuator(String names, double someDouble){
		name = names;
		this.someDouble = someDouble;
		this.state = "double";
	}
}
