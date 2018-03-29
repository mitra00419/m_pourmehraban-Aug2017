package textExcel;

public class EmptyCell implements Cell{

	private String value;

	//Constructor for EmptyCell class
	public EmptyCell() {
		this.value = fullCellText();
		abbreviatedCellText();
	}

	public String abbreviatedCellText() { // 10 spaces needed to fill the cell
		return "          ";
	}

	public String fullCellText() { //returns this if cell is blank
		return "";
	}
}