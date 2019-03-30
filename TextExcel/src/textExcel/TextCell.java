// @author Alex Lee
// @version March 12, 2019

package textExcel;

public class TextCell implements Cell {
	private String text;
	//constructor
	public TextCell(String text) {
		this.text = text;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String newCellContents = text;
		if (text.contains("\"")){//checks if there is a quotation marks
			newCellContents = text.substring(1, text.length()-1);
		}
		int count = newCellContents.length();
		if(count> 10) {
			return(newCellContents.substring(0, 10));
		} else {
			newCellContents += "          ";//adds 10 spaces in order to fill up the needed part
			return (newCellContents.substring(0, 10));
		}
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return text;
	}

}