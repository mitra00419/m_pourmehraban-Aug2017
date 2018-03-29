package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int col;

	public SpreadsheetLocation (String cellName) // set location given string name which is cell
	{
	    		row = Integer.parseInt(cellName.substring(1)) - 1;	// parseint changes string into integer value
	    		col = Character.toUpperCase(cellName.charAt(0)) - 'A'; // to make sure all letters are capital
	}
	
    @Override
    public int getRow()
    {
        return row;
    }

    @Override
    public int getCol()
    {
        return col;
    }

}
