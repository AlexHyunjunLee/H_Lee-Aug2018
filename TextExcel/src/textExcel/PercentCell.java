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
		String percent;
		if (super.fullCellText().contains(".")) {//checks if there is a decimal point
			percent = super.fullCellText().substring(0, super.fullCellText().indexOf("."));
		} else {
			percent = super.fullCellText();
		}
		percent += "%          ";//adds percent sign with 10 spaces at the end
		return(percent.substring(0, 10));
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return ""+getDoubleValue(super.fullCellText());
	}
	//Returns the double value of a percent cell
	public double getDoubleValue(String input) {
		return (Double.parseDouble(input.substring(0, input.indexOf("%")))/100);
	}
	public int compareTo(Object str) {
		PercentCell you = (PercentCell) str;
		double comparison = this.getDoubleValue()-you.getDoubleValue();
		System.out.println(comparison);
		return (int) comparison;
	}
}