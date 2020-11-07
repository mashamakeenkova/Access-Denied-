
public class SmartLamp {
	
	double state;
	
	public SmartLamp() {
		state = 0.0;
		
	}
	
	public SmartLamp(double initial_state) {
		// @EXCEPTION  -  0 <= state <= 1
		if (initial_state > 1) {
			state = 1.0;
		}
		else {
			state = initial_state;
		}
	}
	
	public void update(double update_state) {
		// @EXCEPTION  -  0 <= state <= 1
		if (update_state > 1) {
			state = 1.0;
		}
		else {
			state = update_state;
		}
	}
}
