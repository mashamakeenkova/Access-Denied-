
public class DoorLock {
	
	boolean state;
	
	
	public DoorLock() {
		state = false;
	}
	
	public DoorLock(boolean initial_state) {
		state = initial_state;
	}

	public void update(boolean update_state) {
		state = update_state;
	}
}
