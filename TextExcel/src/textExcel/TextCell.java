// @author Alex Lee
// @version March 12, 2019
//This class contain methods for the text cell

package textExcel;

public class TextCell implements Cell, Comparable<Object> {
	private String text;
	//constructor
	public TextCell(String text) {
		this.text = text;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String cellContents = text;
		if (text.contains("\"")){//checks if there is a quotation marks
			cellContents = text.substring(1, text.length()-1);
		}
		cellContents += "          ";//adds 10 spaces in order to fill up the needed part
		return (cellContents.substring(0, 10));
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return text;
	}
	public int compareTo(Object str) {
		TextCell comparedString = (TextCell) str;
		return this.fullCellText().compareTo(comparedString.fullCellText());
	}
}