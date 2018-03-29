package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	private Cell[][] cellArray;
	public Spreadsheet() {				// constructor to make the actual sheet print 20x12
		cellArray=new Cell[20][12];
		for(int i=0;i<cellArray.length;i++) {		// makes sure every cell is empty to begin w
			for (int j=0;j<cellArray[i].length;j++) {
				cellArray[i][j]=new EmptyCell();
		}
	}
}

public String processCommand(String command)
{
	if(command.toLowerCase().equals("clear")) { 		// if user puts clear then you empty entire sheet
		clear();
		return getGridText();
	}else if(command.contains("=")) { 	// use contains method that returns boolean
		assignCell(command);				// if there's equals sign then go to assignCell method
		return getGridText();
	}else if(command.length()==2||command.length()==3) { // if there's only 'a2' and 'a22'
		Location position = new SpreadsheetLocation(command);
		return inspectCell(position); // then go inspect cell method for that cell position
	}else if (command.toLowerCase().contains("clear")&& command.length()>5){
		Location position=new SpreadsheetLocation(command.substring(6));
		clearCell(position); // clear the specific cell at position entered
		return getGridText();
	}else {
		return "";
	}
}
public String inspectCell(Location loc) {	// do the returning of EVERYTHING in the cell
	return getCell(loc).fullCellText();
}
public String assignCell(String input) { // do the cell assigning after splitting between the equals
	String[] assignit=input.split("=", 2);		// to know what's being returned
	Location loc = new SpreadsheetLocation(assignit[0].substring(0,assignit[0].indexOf(" ")));
	if(assignit[1].contains("\"")) { // ^ that makes new array to put the rest of the str in
		cellArray[loc.getRow()][loc.getCol()]=new TextCell(assignit[1].substring(1));
	}else if(assignit[1].contains("(")&&assignit[1].contains(")")){ // if parentheses
		cellArray[loc.getRow()][loc.getCol()]=new FormulaCell(assignit[1].substring(1).toLowerCase());
	}else if(assignit[1].contains("%")) {
		cellArray[loc.getRow()][loc.getCol()]=new PercentCell(assignit[1].substring(1));
	}else {
		cellArray[loc.getRow()][loc.getCol()]=new ValueCell(assignit[1].substring(1));
	}
	
	return getGridText();
	
}

public String clear() { // how to clear all sheet by creating empty cells efficiently for every cell
	for (int i=0;i<cellArray.length;i++) {
		for (int j=0; j<cellArray[i].length;j++) {
			cellArray[i][j]=new EmptyCell();
		}
	}
	return getGridText(); // return once emptied
}

public String clearCell(Location loc) {
	cellArray[loc.getRow()][loc.getCol()]=new EmptyCell(); // clear cell at specific
	return getGridText();
}

public int getRows()
{
	return 20;
}

public int getCols()
{
	return 12;
}

public Cell getCell(Location loc)
{
	return cellArray[loc.getRow()][loc.getCol()];
}

public String getGridText()
{
	String result=""; // marks horizontal letters using ascii
	result+="   |";		
	for (int i=65; i<=76;i++) {
		result+=(char)i;
		for(int j=0; j<9; j++) {
			result+=" ";
		}
		result+="|"; // bar to distinguish cells
	}
	result+="\n";
	for(int k=1;k<=20;k++) { // marks the vertical numbers
		if(k<10) {
			result+=k+"  ";
		}else {
			result+=k+" ";
		}
		result+="|";
		for(int l=0;l<12;l++) {
			result+=cellArray[k-1][l].abbreviatedCellText();		// fill them in
			result+="|";
		}
		result+="\n";
	}
	return result;}

}
