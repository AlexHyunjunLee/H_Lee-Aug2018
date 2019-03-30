// @author Alex Lee
// @version March 19, 2019

package textExcel;

public class PercentCell extends RealCell {
	//constructor
	public PercentCell(String percentString) {
		super(percentString);
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String percent;
		if (getUserInput().contains(".")) {//checks if there is a decimal point
			percent = getUserInput().substring(0, getUserInput().indexOf("."));
		} else {
			percent = getUserInput();
		}
		percent += "%          ";//adds percent sign with 10 spaces at the end
		return(percent.substring(0, 10));
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		String initial = getUserInput();
		String returnString = "" + getDoubleValue(initial);
		return returnString;
	}
	//Returns the double value of a percent cell
	public double getDoubleValue(String input) {
		return (Double.parseDouble(input.substring(0, input.indexOf("%")))/100);
	}
	
}