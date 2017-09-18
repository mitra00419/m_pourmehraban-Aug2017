/* Mitra Pourmehraban
 * September 5, 2017
 * This is our library that will contain various
 * mathematical methods.
 */
public class Calculate {
	/*
	 * This method takes an integer and returns its square.
	 * 
	 */
	public static int square(int operand) {
		return operand * operand;
	}

	/*
	 * This method takes an integer and returns its cube.
	 * 
	 */
	public static int cube(int operand) {
		return operand * operand * operand;
	}

	/*
	 * This method takes 2 doubles and returns the average of them.
	 * 
	 */
	public static double average(double operand1, double operand2) {
		double average = (operand1 + operand2) / 2;
		return average;
	}

	/*
	 * This method takes 3 doubles and returns the average of them.
	 * 
	 */
	public static double average(double operand1, double operand2, double operand3) {
		double average = (operand1 + operand2 + operand3) / 3;
		return average;
	}

	/*
	 * This method converts an angle measure in radians to degrees.
	 * 
	 */
	public static double toDegrees(double operand) {
		double toDegrees = (operand * (180 / 3.14159));
		return toDegrees;
	}

	/*
	 * This method converts an angle measure in radians to degrees.
	 * 
	 */
	public static double toRadians(double operand) {
		double toRadians = (operand * (3.14159 / 180));
		return toRadians;
	}

	/*
	 * This method determines the discriminant from the three coefficients in
	 * standard form.
	 *
	 */
	public static double discriminant(double a, double b, double c) {
		double discriminant = (b * b) - (4 * a * c);
		return discriminant;
	}

	/*
	 * This method takes a mixed number and converts it to an improper fraction.
	 *
	 */
	public static String toImproperFrac(int coefficient, int numerator, int denominator) {
		int numeratorFrac = (coefficient * denominator) + numerator;
		return numeratorFrac + "/" + denominator;
	}

	/*
	 * This method takes an improper fraction and converts it into a mixed number.
	 *
	 */
	public static String toMixedNum(int numerator, int denominator) {
		return numerator / denominator + "_" + numerator % denominator + "/" + denominator;
	}

	/*
	 * This method takes four integers and a string to convert binomial
	 * multiplication into the form of a quadratic equation.
	 */
	public static String foil(int a, int b, int c, int d, String letter) {
		return (a * c + letter + "^2") + "+" + ((a * d) + (b * c) + letter) + "+" + (b * d);
	}

	/*
	 * This method takes two integers and determines if one integer if divisible by
	 * the other.
	 *
	 */
	public static boolean isDivisibleBy(int dividend, int divisor) {
		if (dividend % divisor == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * This method takes a double and returns the absolute value of that double.
	 *
	 */
	public static double absValue(double number) {
		if (number < 0) {
			return number * -1;
		} else {
			return number;
		}
	}

	/*
	 * This method takes a two numbers and determines the max of the values.
	 *
	 */
	public static double max(double num1, double num2) {
		if (num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}

	/*
	 * This method takes a three numbers and determines the max of the values.
	 *
	 */
	public static double max(double num1, double num2, double num3) {
		if (num1 > num2 & num1 > num3) {
			return num1;
		} else if (num2 > num1 & num2 > num3) {
			return num2;
		} else {
			return num3;
		}
	}

	/*
	 * This method takes a two numbers and determines the min of the values.
	 *
	 */
	public static double min(double num1, double num2) {
		if (num1 <= num2) {
			return num1;
		} else {
			return num2;
		}
	}

	/*
	 * This method rounds a number to two decimal places.
	 *
	 */
	public static double round2(double number) {
		number = number * 1000;
		if (number % 10 < 5) {
			number = number - (number % 10);
			return number / 1000;
		} else {
			number = number - (number % 10) + 10;
			return number / 1000;
		}
	}
	/*
	 * This method takes a double and an integer and uses the double as the base
	 * and the integer as the exponent. It calculates this and returns a double.
	 */
	public static double exponent(double base, double exponent) {
		double result = 1;
		if (exponent < 0) {
			base = 1.0 / base;
			exponent = -exponent;
		}
		while (exponent > 0) {
			result = result * base;
			exponent = exponent - 1;
		}
		return result;
		}
		
}
