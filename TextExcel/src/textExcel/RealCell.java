// @author Alex Lee
// @version March 19, 2019

package textExcel;

public class RealCell implements Cell {

	private String cell;
	//constructor
	public RealCell(String input) {
		this.cell = input;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String newCellContents = cell;
		if(cell.length() > 10) {
			return(cell.substring(0, 10));
		}
		else {
			newCellContents += "          ";//adds 10 spaces in order to fill up the needed part
			return (newCellContents.substring(0, 10));
		}
	}
	//Returns the double value of a real cell
	public double getDoubleValue() {
		return Double.parseDouble(cell);
	}
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		String newCellContents = cell;
		return newCellContents;          
	}
	//created to get the values from the real cell class in the subclasses
	public String getUserInput() {
		return cell;
	}

}