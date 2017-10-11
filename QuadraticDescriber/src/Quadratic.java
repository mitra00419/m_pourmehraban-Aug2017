/* Mitra Pourmehraban
 * October 5, 2017
 * This is the code for the Quadratic class.
 */
public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
	
		
		
	}
	
	
	public static double min(double num1, double num2) {
		if (num1 <= num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	public static double discriminant(double a, double b, double c) {
		double discriminant = (b * b) - (4 * a * c);
		return discriminant;
	}
	
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
	
	public static double sqrt(double num) {
		if(num < 0) {
			throw new IllegalArgumentException("Cannot find the square root of a negative value");
		}
		double i;
		for(i = 0; (i * i) < num; i++) {}
		while((i * i) > num) {
			i -= 0.1;
			}
		while(i * i < num) {
			i += 0.01;
			}
		while(i * i > num) {
			i -= 0.001;
			}
		return round2(i);
	}
	
	public static String quadForm (int a, int b, int c) {	
		if(discriminant(a, b, c) < 0 ) {
			return "No real roots";
		}else if (discriminant(a, b, c) == 0) {
			double realroot = -b / (2.0 * a);
			return "" + realroot;
		}else {
			double squarerootdisc = sqrt(discriminant(a, b, c));
			double root1 = (-b + squarerootdisc) / (2 * a);
			double root2 = (-b - squarerootdisc) / (2 * a);
			double roundedroot1 = round2(root1);
			double roundedroot2 = round2(root2);
			if (min(roundedroot1, roundedroot2) == roundedroot1) {
				return roundedroot1 + " and " + roundedroot2;
			}else {
				return roundedroot2 + " and " + roundedroot1;
			}
		}
	}
	
	public static String completeSquare(double a, double b, double c) {
		double xValue = round2(-b / a / 2);
		double yValue = round2(c - (xValue * xValue * a));
		return "The vertex is at (" + xValue + "," + yValue + ").";
	}
}
