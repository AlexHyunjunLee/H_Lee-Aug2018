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
		String newValue = value;
		if(value.length() > 10) {
			return(value.substring(0, 10));
		} else {
			for(int i = 0; i < 10 - value.length(); i++) {
				newValue += " ";
			}
		}
		return newValue;
	}
	public void dCellText(double value) {
		String doubleValue = value+"          ";
		doubleValue.substring(0, 9);
		doubleValue+="";
	}
}
