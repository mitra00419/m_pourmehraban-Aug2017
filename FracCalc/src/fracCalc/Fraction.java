/* Mitra Pourmehraban
 * December 11, 2017
 * APCS 1st Period
 * This is the code for FracCalc with Objects. Fraction class
 */

package fracCalc;

public class Fraction {
	private int num;
	private int denom;
	private int whol;
	
	public Fraction (String fracStr) {
		parseValues(fracStr);
	}
	
	public Fraction() {
		whol = 0;
		num = 0;
		denom = 1;
	}
	
	private void parseValues(String operand) {
		String[] splitFrac = operand.split("_");
		if (splitFrac.length == 2) {
    			String[] splitAgain = splitFrac[1].split("/");
    			whol = intAnswer(splitFrac[0]);
    			num = intAnswer(splitAgain[0]);
    			denom = intAnswer(splitAgain[1]);
		} else {
    			String[] splitAgain = splitFrac[0].split("/");
    			if (splitAgain.length == 2) {
    				whol = 0;
    				num = intAnswer(splitAgain[0]);
    				denom = intAnswer(splitAgain[1]);
    			} else {
    				whol = intAnswer(splitFrac[0]);
    				num = 0; 
    				denom = 1;
    			}
		}
    }
	
	public String toString() {
    		String answer = "";
    		if (whol == 0 && num == 0) {
    			answer += "0";
    		} else if (whol == 0) {
    			answer += num;
    			answer += "/";
    			answer += denom;
    		} else if (num == 0) {
    			answer += whol;
    		} else {
    			answer += whol;
    			answer += "_";
    			answer += num;
    			answer += "/";
    			answer += denom;
    		}
    		return answer;
    }
    
    private int intAnswer(String input) {
    		if (input.indexOf("-") >= 0) {
    			String number = input.substring((input.indexOf("-") + 1), input.length());
    			int i = 0;
    			while (!number.equals("" + i)) {
    				i++;
    			}
    			return i * -1;
    		} else { 
    			int i = 0;
    			while (!input.equals("" + i)) {
    				i++;
    			}
    			return i;
    		}
    }
    
    public int getDenom() {
		return denom;
    }

    public int getWhol() {
    		return whol;
    }	

    public int getNum() {
    		return num;
    }
	
	public void setDenom(int newDenom) {
		denom = newDenom;
	}
	
	public void setWhol(int newWhole) {
		whol = newWhole;
	}
	
	public void setNum(int newNum) {
		num = newNum;
	}
	
	public void toImprFrac() {
		num = (whol * denom) + num;
    		whol = 0;
	}
	
	public void simplifyResult() {
		int gCF = gCfFind();
    		num /= gCF;
    		denom /= gCF;
    		int newNum = num % denom;
    		int plusNum = num / denom;
    		whol += plusNum;
    		num = newNum;
    		if (num < 0 && whol < 0) {
    			num *= -1;
    		}
    }
	
	public void fixMinus() {
    		if (whol < 0) {
    			num *= -1;
    		}
    }
	
	private int gCfFind() {
    		int gCF = 1;
    		int start = 0;
    		if (abs(num) >= abs(denom)) {
    			start = abs(denom);
    		} else {
    			start = abs(num);
    		}
    		for (int i = start; i > 1; i--) {
    			if (abs(num) % i == 0 && abs(denom) % i == 0) {
				gCF = i;
				i = 1;
    				}
    			}
    		return gCF;
    }
	
	private int abs(int op) {
		if (op < 0) {
    			return op * -1;
		} else {
    			return op;
		}
    }
}