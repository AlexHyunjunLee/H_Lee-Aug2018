// @author Alex Lee
// @version March 19, 2019

package textExcel;

public class ValueCell extends RealCell {
	//constructor
	public ValueCell(String valueInput) {
		super(valueInput);
	}
	//Returns the value cell truncated to the length of 10
	public String abbreviatedCellText() {
		String value = "" + this.getDoubleValue();//gets the value from the superclass with the method getDoubleValue()
		if(value.length() > 10) {
			return(value.substring(0, 10));
		} else {
			value += "          ";//adds 10 spaces in order to fill up the needed part
			return (value.substring(0, 10));
		}
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		String text = getUserInput();//gets the value from the superclass
		return text;
	}
}