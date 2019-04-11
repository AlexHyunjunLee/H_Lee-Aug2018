// @author Alex Lee
// @version March 19, 2019
//This class contain methods for the real cell

package textExcel;

public class RealCell implements Cell {
	private String cell;
	//constructor
	public RealCell(String input) {
		this.cell = input;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String cellContents = cell+= "          ";//adds 10 spaces in order to fill up the needed part;
		return (cellContents.substring(0, 10));
	}
	//Returns the double value of a real cell
	public double getDoubleValue() {
		return Double.parseDouble(cell);
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return cell;          
	}
	//created to get the values from the real cell class in the subclasses and not to get confused with fullCellText in subclasses
	public String getUserInput() {
		return cell;
	}
}