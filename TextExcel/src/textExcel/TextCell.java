package textExcel;

public class TextCell implements Cell{

	private String text;
	
	public TextCell(String text) {
		
	}
	
	@Override
	public String abbreviatedCellText() {
		String returntext = text;
		while(returntext.length() < 10) {
			returntext += " ";
		}
		return returntext;
	}

	@Override
	public String fullCellText() {
		return "\"" + text + "\"";
	}

}
