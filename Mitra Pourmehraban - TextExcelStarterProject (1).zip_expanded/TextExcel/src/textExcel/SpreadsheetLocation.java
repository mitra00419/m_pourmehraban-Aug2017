package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location {
	private String name;

	// constructor for SpreadsheetLocation
	public SpreadsheetLocation(String cellname) {
		name = cellname;
	}

	public int getRow() {	// gets the row from the first letter in command
		return Integer.parseInt(name.substring(1))-1;
	}

	public int getCol() { // retrieves the column from the number value in command  	
		return Character.toUpperCase(name.charAt(0)) - 'A';

	}
}

