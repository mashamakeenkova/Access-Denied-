
public class Actuator {
	String name;
	String state;
	boolean someBool;
	double someDouble;
	int someInt;
	
	Actuator(String names, int someInt){
		name = names;		
		this.someInt = someInt;
		this.type = "int";
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
