/* Mitra Pourmehraban
 * December 11, 2017
 * APCS 1st Period
 * This is the code for FracCalc with objects. FracCalc Class
 */

package fracCalc;

import java.util.Arrays;
import java.util.Scanner;

public class FracCalc {

	    public static void main(String[] args) {
	    	Scanner control = new Scanner(System.in);
	    	boolean done = false;
	    	while (!done == true) {
	    		System.out.println("Put in your equation or enter quit");
	    		String equation = control.nextLine();
	    		System.out.println(produceAnswer(equation));
	    		System.out.println("Put in your equation or enter quit");
	    		String quitting = control.nextLine();
	    		if (quitting.equals("quit")) {
	    			done = true;
	    			}
	    		}
	    }
	    
	    public static String produceAnswer(String input) { 
			String[] inputArray = input.split(" ");
			String operator = inputArray[1];
			Fraction frac1 = new Fraction(inputArray[0]);
			Fraction frac2 = new Fraction(inputArray[2]);
			Fraction output = doStuff(operator, frac1, frac2); 
			if (inputArray.length > 3) {
				for (int i = 3; i < inputArray.length - 1; i += 2) {
					Fraction nextOperand = new Fraction(inputArray[i + 1]);
					String nextOperator = inputArray[i];
				output = doStuff(nextOperator, output, nextOperand);
				}
			}
			return output.toString();
	    }
	    
	    public static Fraction doStuff(String op, Fraction op1, Fraction op2) {
	    		Fraction answer = new Fraction();
	    		op1.fixMinus();
	    		op2.fixMinus();
	    		if (op.equals("+")) {
	    			answer = addAnswer(op1, op2);
	    		} else if (op.equals("-")) {
	    			answer = subtractAnswer(op1, op2);
	    		} else if (op.equals("*")) {
	    			answer = multiplyAnswer(op1, op2);
	    		} else {
	    			answer = divideAnswer(op1, op2);
	    		}
	    		return answer;
	    }
	    
	    public static Fraction addAnswer(Fraction op1, Fraction op2) {
	    		op1.toImprFrac();
	    		op2.toImprFrac();
	    		Fraction output = new Fraction();
	    		output.setNum((op1.getNum() * op2.getDenom()) + (op2.getNum() * op1.getDenom()));
	    		output.setDenom(op1.getDenom() * op2.getDenom());
	    		output.simplifyResult();
	    		return output;
	    }
	    
	    public static Fraction subtractAnswer(Fraction op1, Fraction op2) {
	    		Fraction alt = new Fraction();
	    		alt.setWhol(op2.getWhol() * -1);
	    		alt.setNum(op2.getNum() * -1);
	    		alt.setDenom(op2.getDenom());
	    		Fraction output = addAnswer(op1, alt);
	    		return output;
	    }
	    		
	    public static Fraction multiplyAnswer(Fraction op1, Fraction op2) {
	    		op1.toImprFrac();
	    		op2.toImprFrac();
	    		Fraction output = new Fraction();
	    		output.setNum(op1.getNum() * op2.getNum());
	    		output.setDenom(op1.getDenom() * op2.getDenom());
	    		output.simplifyResult();
	    		return output;
	    }
	    		
	    public static Fraction divideAnswer(Fraction op1, Fraction op2) {
	    		Fraction answer = new Fraction();
	    		op2.toImprFrac();
	    		int divideA;
	    		int divideB;
	    		if (op2.getNum() < 0) {
	    			divideA = op2.getDenom() * -1;
	    			divideB = op2.getNum() * -1;
	    		} else {
	    			divideA = op2.getDenom();
	    			divideB = op2.getNum();
	    		}
	    		answer.setNum(divideA);
	    		answer.setDenom(divideB);
	    		Fraction multiplyOutput = multiplyAnswer(op1, answer);
	    		return multiplyOutput;
	    }
	    
	}