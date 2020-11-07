
public class SwissFlag {

	public static void main(String[] args) {
		linie();
		for (int i = 0; i < 3; i++) {
		kreuze(6);
	}
		for (int i = 0; i < 3; i++) {
			kreuze(20);
		}
		
		for (int i = 0; i < 3; i++) {
			kreuze(6);
		}
		linie();
	}

	public static void kreuze(int a) {
		if(a < 10) {
			System.out.print("|           ");
		}
		else if (a > 10) {
			System.out.print("|    ");
		}
		for (int i = 0; i < a; i++) {
		
		System.out.print("+");
		}
		System.out.print("+");
		
		if(a < 10) {
			System.out.println("           |");
		}
		else if (a > 10) {
			System.out.println("    |");
		}
	
	}
	
	public static void linie() {
		for (int i = 0; i < 30; i++) {
			System.out.print("_");
		}
		System.out.println("_");
		
	}
}
