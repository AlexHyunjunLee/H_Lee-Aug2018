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
		if(value.substring(value.indexOf(".")+1).contains("0")){
			boolean checkpoint = false;
			while(!checkpoint) {
				if(value.substring(value.length()-1).equals("0")){
					value=value.substring(0,value.length()-1);
				}
			}
		}
		if(value.length() > 10) {
			return(value.substring(0, 10));
		} else {
			value += "          ";
			return(value.substring(0, 10));
		}
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		String initial = getUserInput();
		return initial;
	}
}
