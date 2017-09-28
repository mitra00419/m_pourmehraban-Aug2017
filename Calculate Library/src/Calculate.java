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
		double total = operand1 + operand2 ;
		return total / 2;
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
	public static boolean isDivisibleBy(double dividend, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("Cannot divide by 0");
		}
		return dividend % divisor == 0;
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
	public static double exponent(double base, int exponent) {
		if (exponent < 0) {
			throw new IllegalArgumentException("Cannot raise to an exponent less than 1");
		}
		double result = 1;
		if (exponent == 1) {
			result = 1;
		}
		for(int i = 0; i < exponent; i++) {
			result = result * base;
		}
		return result;
		}
	/*
	 * This method takes an integer and returns its factorial
	 *  
	 */
	public static int factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Cannot find the factorial of a negative number");
		}
		int result = 1;
		if (n == 0) {
			result = 1;
		}
		while(n > 0) {
			result = n * result;
			n--;
		}
		return result;
	}
		
	/*
	 * This method determines whether or not the integer entered is
	 * a prime number. It returns true or false
	 */

	public static boolean isPrime(int number) {
		boolean answer;
		for (int counter = number - 1; counter > 1; counter--) {
			answer = Calculate.isDivisibleBy(number, counter);
			if (answer == true) {
					return (false);
			}
		}
		return (true);
	}
	/*
	 * This method takes two positive integers and returns the greatest
	 * common factor of the two integers
	 */
	
	public static int gcf(int a, int b){
		int gfc = 1;
		for (int i=1; i<= a; i++){
			if (isDivisibleBy(a,i) && isDivisibleBy(b, i)){
				gfc =i;
			}
		}
		return(gfc);

	}
	}
	/*
	 * This method return the approximation of the square root
	 * of double given and rounds it to two decimal places.
	 */
	/*public static double sqrt(double num) {
		if(num < 0) {
			throw new IllegalArgumentException("Cannot find the square root of a negative value");
		}
		double i;
		for(i = 0; (i * i) < num; i++) {
				while(i * i > num) {
					i -= 0.1;
				}
				while(i * i < num) {
					i += 0.01;
				}
				while(i * i > num) {
					i -= 0.001;
				}
		i = round2(i);
		return i;
		}
	}
	/* This method returns the number and value of the roots
	 * of a function
	 */
	/*public static String quadForm (int a, int b, int c) {	
		if(discriminant(a, b, c) < 0 ) {
			return "No real roots";
		}else if (discriminant(a, b, c) == 0) {
			double realroot = (-b / (2 * a));
			double realrootrounded = round2(realroot);
				return "" + realrootrounded;
			}else {
			double root1 = (-b + sqrt(discriminant(a, b, c))) / (2 * a);
			double root2 = (-b - sqrt(discriminant(a, b, c))) / (2 * a);
			double roundedroot1 = round2(root1);
			double roundedroot2 = round2(root2);
			if (min(roundedroot1, roundedroot2) == roundedroot1) {
				return root1 + " and " + root2;
			}else {
				return root2 + " and " + root1;
			}
		}
		
	}*/
	

	
