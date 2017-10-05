/* Mitra Pourmehraban
 * October 3, 2017
 * This is the code for the collaborative program
 * we did in class.
 */
import java.util.*; 

public class CollabProgram {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int max = 0;
		int min = 0;
		int evenSum = 0;
		int maxEven = 0;
		boolean test = true;
		boolean even = true;
		boolean done = false;
		do {
			System.out.print("Enter the next number: ");
			int x = console.nextInt();
			if(x % 2 == 0) {
				evenSum += x;
				if(x > maxEven || even) {
					maxEven = x;
				}
				even = false;
			}
			System.out.print("Add another number? Yes or No?");
			String repeat = console.next();
			if(repeat.equals("no")) {
				done = true;
			}
			if(x < min || test) {
				min = x;
			}
			if(x > max || test) {
				max = x;
			}
			test = false;
		} while(!done);	
		System.out.println("Largest number: " + max);
		System.out.println("Smallest number " + min);
		System.out.println("Sum of even numbers:" + evenSum);
		System.out.println("Largest even number: " + maxEven);

	}

}