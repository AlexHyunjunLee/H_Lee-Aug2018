// @author Alex Lee
// @version March 19, 2019

package textExcel;

public class ValueCell extends RealCell {
	public ValueCell(String valueInput) {
		super(valueInput);
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		double doubleValue = this.getDoubleValue();
		String value = "" + doubleValue;
		if(value.length() > 10) {
			return(value.substring(0, 10));
		} else {
			value += "          ";
			return(value.substring(0, 10));
		}
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		String returnString = "" + this.getDoubleValue();
		return returnString;
	}
	public double getDoubleValue() {
		return (Double.parseDouble(fullCellText()));
	}
}
