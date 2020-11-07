package old_and_unrelevant;

public class SmartLamp {

	double state;
	static double MIN_value = 0.0;
	static double MAX_value = 1.0;

	public SmartLamp() {
		state = 0.0;
 
	}

	public SmartLamp(double initial_state) {
		// @EXCEPTION - 0 <= state <= 1
		if (initial_state > MAX_value) {
			state = 1.0;
		} else if (initial_state < MIN_value) {
			state = 0.0;

		} else {
			state = initial_state;
		}
	}

	public void update(double update_state) {
		// @EXCEPTION - 0 <= state <= 1
		if (update_state > MAX_value) {
			state = 1.0;
		} else if (update_state < MIN_value) {
			state = 0.0;
		} else {
			state = update_state;
		}
	}
}

