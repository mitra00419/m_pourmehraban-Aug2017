package textExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class Spreadsheet implements Grid {

	//Initializes a the array to store the needed text in the Excel Table.
	private Cell[][] sheet1 = new Cell[12][20];

	//Constructor for Spreadsheet class
	public Spreadsheet() {
		for (int i = 0; i < sheet1.length; i++) {
			for (int j = 0; j < sheet1[i].length; j++) {
				sheet1[i][j] = new EmptyCell();
			}
		}
	}


	@Override
	// Method that takes in the command and sends it to the proper class to be processed. 
	public String processCommand(String command) {
		if (command.equals("")) {
			return "";
		}
		String[] inputcommand = command.split(" ", 3); //Splits this string around matches of the given regular expression. 
		//public String[] split(String regex,  int limit(which is 3, MAX SPACES))
		if (command.length() <= 3) { // Command is less than 3 or less characters, its got to be an inspection command
			SpreadsheetLocation location = new SpreadsheetLocation(command);	
			return getCell(location).fullCellText();
			//represents any other command that is can be inputted
		}else if (inputcommand.length > 1) { 
			if (inputcommand[1].equals("=")) {
				SpreadsheetLocation location1 = new SpreadsheetLocation(inputcommand[0]);
				int row = location1.getRow();
				int col = location1.getCol();			
				// Sends to TextCell (checkpoint 2)
				if (inputcommand[2].charAt(0) == '"' && inputcommand[2].charAt(inputcommand[2].length() - 1) == '"') {
					sheet1[col][row] = new TextCell(inputcommand[2].substring(1, inputcommand[2].length() - 1));
					// Processes Percentages (checks for percentage before looking for decimals)
				} else if (inputcommand[2].substring(inputcommand[2].length() - 1).equals("%")) {
					sheet1[col][row]= new PercentCell(inputcommand[2]);
					// Handles formula cells
				} else if (inputcommand[2].charAt(0) == '(' && inputcommand[2].charAt(inputcommand[2].length() - 1) == ')') {
					// Processes FormulaCell ( the two plus two and the A2 plus A2)
					sheet1[col][row]= new FormulaCell(inputcommand[2],this, sheet1);// Another practical example of using “this” is when you need to pass your current object to another method. Example:
					// Processes ValueCell (any decimal number)
				} else if (inputcommand[2].indexOf(".") > 0) {
					sheet1[col][row] = new ValueCell(inputcommand[2]);
					// Processes to ValueCell if a regular string or non decimal is assigned
				} else if (inputcommand[2] != null){ 
					sheet1[col][row] = new ValueCell(inputcommand[2]);
					// If the command is not reconizged in any way....
				} else {
					throw new IllegalArgumentException("ERROR: Invalid Command");
				}
				return getGridText();
				//This clear works only if there is spacing(ex. , so it will only clear one cell instead of the entire thing
			}else if (inputcommand[0].equalsIgnoreCase("clear")) {
				for (int i = 1; i < inputcommand.length; i++) {
					SpreadsheetLocation gridLoc = new SpreadsheetLocation(inputcommand[i]);
					int rowNum = gridLoc.getRow();
					int colNum = gridLoc.getCol();
					sheet1[colNum][gridLoc.getRow()] = new EmptyCell();
				}
				return getGridText();
				//If command is blank
			}else{

				throw new IllegalArgumentException("ERROR: Where's your command?");
			}
		}
		if(command.equalsIgnoreCase("clear")) { // clears the entire cell 
			for (int i = 0; i < sheet1.length; i++) {
				for (int j = 0; j < sheet1[i].length; j++) {
					sheet1[i][j] = new EmptyCell();
				}
			}
			return getGridText();
		}else{
			// if something other than the other clear commands happen...
			throw new IllegalArgumentException("Error: Something wrong with clear command.");
		}
	}



	//Method that returns how many rows there are in emptyCell
	@Override
	public int getRows() {
		return 20;
	}

	//Method that returns how many columns there are in emptyCell
	@Override
	public int getCols() {
		return 12;
	}

	//Method that accesses the location of any cell (eg A4)
	@Override
	public Cell getCell(Location loc) {
		return sheet1[loc.getCol()][loc.getRow()];
	}

	//Method that returns the entire grid physically
	@Override
	public String getGridText() {
		String letterRow = "   ";	
		String modifiedRow = "";		
		for (char c = 'A'; c <= 'L'; c++) { // the ascii in use here
			letterRow += "|" + c + "         ";
		}		
		letterRow  = letterRow + "|";
		for (int i = 0; i < 20; i++) {
			if (i + 1 < 10) {
				modifiedRow += (i + 1) + "  ";
			} else  {
				modifiedRow += (i + 1) + " ";
			}
			for (int k = 0; k < 12; k++) {
				modifiedRow += "|" + sheet1[k][i].abbreviatedCellText();
			}
			modifiedRow += "|\n";
		}		
		return letterRow + "\n" + modifiedRow;
	}
}