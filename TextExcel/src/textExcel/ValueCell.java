// @author Alex Lee
// @version March 19, 2019

package textExcel;

public class ValueCell extends RealCell {
	public ValueCell(String valueInput) {
		super(valueInput);
	}
	//Returns the contents of a value cell truncated to ten spaces
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
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		String initial = getUserInput();
		return initial;
	}
}