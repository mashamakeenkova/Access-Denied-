
public class MotionSensor {
	
	boolean state;
	
	public MotionSensor() {
		state = false;
	}
	
	public MotionSensor(boolean initial_state) {
		state = initial_state;
	}
	
	public void update(boolean update_state) {
		state = update_state;
	}
	
}
