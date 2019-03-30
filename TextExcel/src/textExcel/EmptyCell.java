 // @author Alex Lee
// @version March 4, 2019

package textExcel;

public class EmptyCell implements Cell{
	public EmptyCell() {
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return "          ";//returns 10 spaces because the cell has to be empty
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "";
	}
}