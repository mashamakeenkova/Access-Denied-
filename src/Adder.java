import java.util.*;
public class Adder {

	public static void main(String[] args) {
		Scanner Baum = new Scanner(System.in);
		System.out.println("Geben Sie Zahl 1 ein:");
		int zahl1 = Baum.nextInt();
		
		System.out.println("Geben Sie Zahl 2 ein:");
		int zahl2 = Baum.nextInt();
		int sum = zahl1+zahl2;
		System.out.println(zahl1 + " + " + zahl2 + " = " + sum);

	}

}
