// @author Alex Lee
// @version March 19, 2019

package textExcel;

public class ValueCell extends RealCell {
	public ValueCell(String valueInput) {
		super(valueInput);
	}
	//Returns the contents of a value cell truncated to ten spaces
	public String abbreviatedCellText() {
		String value = "" + this.getDoubleValue();
		if(value.length() > 10) {
			return(value.substring(0, 10));
		} else {
			value += "          ";
			return (value.substring(0, 10));
		}
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		String text = getUserInput();
		return text;
	}
}