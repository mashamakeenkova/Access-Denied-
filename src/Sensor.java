

public class Sensor extends Device {
	String name;
	String type;
	int someInt;
	boolean someBool;
	double someDouble;
	
	
	Sensor(String names){
		name = names;
	}
	Sensor(String names, int anInt){
		name = names;
		someInt = anInt;
		type = "double";
	}
	Sensor(String names, boolean aBool){
		name = names;
		someBool = aBool;
		type = "boolean";
	}
	Sensor(String names, double aDouble){
		name = names;
		someDouble = aDouble;
		type = "double";
	}
	
	
	
	
}
