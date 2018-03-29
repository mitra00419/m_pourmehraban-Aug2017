package textExcel;
import java.util.*;

public class FormulaCell extends RealCell{

	private String makeAnswer;
	private Spreadsheet sheetInfo;	//saves array from spreadsheet to access information from Spreadsheet
	private Cell[][] cellNew; // previously used, but did not work

	// constructor for formula cell
	public FormulaCell (String enteredForm, Spreadsheet sheet1, Cell[][] sheetNew){
		super(enteredForm);        //constructor to fill super's String field (accesses by fullCellText)
		makeAnswer = enteredForm;		
		sheetInfo = sheet1;
		this.cellNew = sheetNew;
	}

	public double sum(String total) { // adds the cells in the when SUM is requested
		String[] insideCell = total.split("-");
		double sum = 0;
		int rowBeg = Integer.parseInt(insideCell[0].substring(1));
		int rowEnd = Integer.parseInt(insideCell[1].substring(1)); //numbers
		char colBeg = (insideCell[0].toUpperCase()).charAt(0); //letters
		char colEnd = (insideCell[1].toUpperCase()).charAt(0);
		for (char i = colBeg; i <= colEnd; i++) {
			for (int j = rowBeg; j <= rowEnd; j++) {
				SpreadsheetLocation gridLoc = new SpreadsheetLocation(i+""+j);
				sum += ((RealCell) sheetInfo.getCell(gridLoc)).getDoubleValue();
			}		
		} 
		return sum;
	}
	public double avg(String total) { // figures out the average of the lot
		String[] cellParts = total.split("-");
		double sumTotal = 0;
		double numofCells = 0;
		int Rstart = Integer.parseInt(cellParts[0].substring(1)); // numbers
		int Rend = Integer.parseInt(cellParts[1].substring(1));
		char Cbeg = (cellParts[0].toUpperCase()).charAt(0); // letters
		char Cend = (cellParts[1].toUpperCase()).charAt(0);
		for (char i = Cbeg; i <= Cend; i++) {
			for (int j = Rstart; j <= Rend; j++) {
				SpreadsheetLocation gridLoc = new SpreadsheetLocation(i+""+j);
				sumTotal += ((RealCell) sheetInfo.getCell(gridLoc)).getDoubleValue();
				numofCells++; // increment amount of cells in  range
			}
		}
		return sumTotal/numofCells; 
	}

	@Override
	public double getDoubleValue() {
		String takeAway = makeAnswer.substring(2,makeAnswer.length()-2);
		String[] fracProc = takeAway.split(" ",takeAway.length()); // holds the fractions and operator
		double result;
		if (fracProc[0].toUpperCase().indexOf("SUM")>=0){ //filters out SUM
			return sum(fracProc[1]);
		}else if (fracProc[0].toUpperCase().indexOf("AVG")>=0) { //filters out AVG
			return avg(fracProc[1]);
		}else{ //anything that doesn't have SUM or AVG
			for (int j = 0; j < fracProc.length; j+=2) {
				if (fracProc[j].substring(0,1).matches("[a-zA-Z]+")) {
					fracProc[j] = getCellValue(fracProc[j]) + "";
				}
			} // this where the math starts
			result = Double.parseDouble(fracProc[0]);
			for (int i = 1; i < fracProc.length; i+=2) {
				if (fracProc[i].equals("+")) {
					result += Double.parseDouble(fracProc[i+1]);
				}else if(fracProc[i].equals("-")) {
					result -= Double.parseDouble(fracProc[i+1]);
				}else if(fracProc[i].equals("/")) {
					result /= Double.parseDouble(fracProc[i+1]);
				}else if (fracProc[i].equals("*")) {
					result *= Double.parseDouble(fracProc[i+1]);
				}else {
					throw new IllegalArgumentException("Error, this operation is not available");
				}
			}
		}
		return result;
	}
	
	public double getCellValue(String cellLoc) { // finds the location and gets the double value out of that location
		SpreadsheetLocation gridLoc = new SpreadsheetLocation(cellLoc);
		double cellvalue =  ((RealCell) sheetInfo.getCell(gridLoc)).getDoubleValue();
		return cellvalue;
	}
	
	@Override
	public String abbreviatedCellText() { // for the needed spaces
		String answer1 = getDoubleValue() +"";
		int cellLength = answer1.length();
		if (cellLength < 10){
			while (answer1.length() < 10){
				answer1 += " ";
			}
			return answer1;
		}else if (cellLength > 10){
			answer1 = answer1.substring(0, 10);
			return answer1;
		}else{
			return answer1;
		}
	}

	@Override
	public String fullCellText() { // returns the full cell only and nothing else
		return super.fullCellText();
	}
}