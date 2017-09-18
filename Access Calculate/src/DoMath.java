/* Mitra Pourmehraban
 * September 5, 2017
 * This is the runner class for my Calculate Library methods.
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(2));
		System.out.println(Calculate.cube(2));
		System.out.println(Calculate.average(3.5,6.5));
		System.out.println(Calculate.average(4,5,6));
		System.out.println(Calculate.toDegrees(3.14159));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(2.1, 1.6, 3.1));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
		System.out.println(Calculate.toMixedNum(7, 2));
		System.out.println(Calculate.foil(2, 3, 6, -7, "n"));
		System.out.println(Calculate.isDivisibleBy(6, 3));
		System.out.println(Calculate.absValue(-.3));
		System.out.println(Calculate.max(2.3, -2.4));
		System.out.println(Calculate.max(2.3, -2.4, 5.5));
		System.out.println(Calculate.min(2, 0));
		System.out.println(Calculate.exponent(2, -2));
		System.out.println(Calculate.factorial(4));
		System.out.println(Calculate.isPrime(7));
		System.out.println(Calculate.gcf(12, 48));
	}

}
