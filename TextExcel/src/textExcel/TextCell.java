package textExcel;

public class TextCell implements Cell{

	private String text;
	
	private String cellText;
	public TextCell(String cellText) {		// constructor
		this.cellText=cellText;
	}

	public String abbreviatedCellText() { 		// show only abbreviated to 10 characters
		if(cellText.contains("\"")) {		// if it has quotes then 
			if(cellText.length()<12) {
				String result=cellText.substring(1,cellText.length()-1);
				for(int i=0; i<(12-cellText.length());i++) {
					result+=" ";
				}
				return result;
			}else {
				return cellText.substring(1,11);
			}
		}else {
			return cellText.substring(0,10);
		}
		
	}

	public String fullCellText() { 			// show everything in the cell
		return cellText;
	}
}
