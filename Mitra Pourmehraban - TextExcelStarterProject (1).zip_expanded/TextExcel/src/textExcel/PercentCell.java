package textExcel;

public class PercentCell extends RealCell implements Cell{
	private String input;
	//Constructor for PercentCell class

	public PercentCell (String test){
		super (test);
		this.input = test;
	}

	public String abbreviatedCellText() { // returns the needed percentages for the table
		String giveValue;
		if(this.input.indexOf(".")<0){
			giveValue = this.input;
		}else{
			giveValue = this.input.substring(0, this.input.indexOf("."));
		}
		giveValue += "%";
		int cellValueLength = giveValue.length()-1;
		if (cellValueLength < 10){
			while (giveValue.length() < 10){
				giveValue += " ";
			}
			return giveValue;
		} else if (cellValueLength > 10){
			giveValue = giveValue.substring(0, 10);
			return giveValue;
		}else{
			return giveValue +"       ";
		}
	}

	public String fullCellText() { // gets value for the inspect file
		return getDoubleValue()+"";
	}

	public double getDoubleValue (){ // truncates it
		return Double.parseDouble(this.input.substring(0, this.input.length()-1))/100;
	}
}