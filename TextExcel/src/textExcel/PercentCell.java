// @author Alex Lee
// @version March 19, 2019
//This class contain methods for the percent cell

package textExcel;

public class PercentCell extends RealCell {
	//constructor
	public PercentCell(String percentString) {
		super(percentString);
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String percent = super.fullCellText();
		if (super.fullCellText().contains(".")) {//checks if there is a decimal point
			percent = super.fullCellText().substring(0, super.fullCellText().indexOf("."));//removes values after the decimal point
		} 
		percent += "%          ";//adds percent sign with 10 spaces at the end
		return(percent.substring(0, 10));
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {//override necessary since need to remove "%" sign
		return ""+getDoubleValue();
	}
	//Returns the double value of a percent cell
	public double getDoubleValue() {
		return (Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().indexOf("%")))/100);
		//first, removes % sign with substring. Then, convert String into double. Lastly, divide by 100 to give a decimal form
	}
}