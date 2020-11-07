
public class SmartNoiseDetector {
	
	boolean value;
	
	public SmartNoiseDetector() {
		value = false;
	}
	
	public SmartNoiseDetector(boolean aValue) {
		value = aValue;
	}
	
	public void update(boolean aValue) {
		value = aValue;
	}

}
