/* Mitra Pourmehraban
 * September 5, 2017
 * This is our library that will contain various
 * mathematical methods.
 */
public class Calculate {
/* This method takes an integer and returns its square.
 * 
 */
	public static int square(int operand) {
		return operand * operand;
	}	
/* This method takes an integer and returns its cube.
 * 
 */
	public static int cube(int operand) {
		return operand * operand * operand;
	}
/* This method takes 2 doubles and returns the average of them.
 * 
 */
	public static double average(double operand1, double operand2) {
		double average = (operand1 + operand2)/2;
		return average;
	}
/* This method takes 3 doubles and returns the average of them.
 * 
 */
	public static double average(double operand1, double operand2, double operand3) {
		double average=(operand1 + operand2 + operand3)/3;
		return average;
	}
/* This method converts an angle measure in radians to degrees.
 * 
 */
	public static double toDegrees(double operand) {
			double toDegrees=(operand * (180/3.14159));
			return toDegrees;
	}
/* This method converts an angle measure in radians to degrees.
 * 
 */
	public static double toRadians(double operand) {
			double toRadians=(operand * (3.14159/180));
			return toRadians;
	}
/* This method determines the discrimant from the three coefficients in standard form.
 *
 */
	public static double discriminant(double a, double b, double c) {
			double discriminant=(b * b) - (4 * a * c);
			return discriminant;
	}
/* This method takes a mixed number and converts it to an improper fraction.
 *
 */
	public static String toImproperFrac(int coefficient, int numerator, int denominator) {
			double numeratorFrac = (coefficient * denominator) + numerator;
			return numeratorFrac + "/" + denominator;
	}
/* This method takes an improper fraction and converts it into a mixed number.
 *
 */
	public static String toMixedNum(int numerator, int denominator) {
			return numerator/denominator + "_" + numerator % denominator + "/" + denominator;
	}
/* This method takes four intergers and a string to convert binomial
 * multiplication into the form of a quadratic equation.
 */
	public static String foil(int a, int b, int c, int d, String letter) {
			return (a * b + letter + "^2") + "+" + ((a * d) + (b * c) + letter) + "+" + (b * d);
	}
}
