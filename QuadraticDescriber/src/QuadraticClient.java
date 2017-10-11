/* Mitra Pourmehraban
 * October 5, 2017
 * This is the code for the Quadratic Client class.
 */

import java.util.*;

public class QuadraticClient {
	
	public static void main(String[] args) {
		String rerun = "";
		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Quadratic Describer\n" + "Provide values for coefficients a, b, and c");
		System.out.println();
		do {
			System.out.print("a: ");
			double a = userInput.nextDouble();
			System.out.print("b: ");
			double b = userInput.nextDouble();
			System.out.print("c: ");
			double c = userInput.nextDouble();
			System.out.println();
			System.out.println("Description of the graph of:");
			System.out.println("y = " + a + " x^2 + " + b + " x + " + c);
			System.out.println();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.println();
			System.out.println("Do you want to keep going? (Type \"quit\" to end)");
			rerun = userInput.next();
		} while (rerun != ("quit"));
		}
	}

