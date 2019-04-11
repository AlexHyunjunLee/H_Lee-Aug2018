// @author Alex Lee
// @version March 4, 2019
//This class contain methods of getting the location of the row, column, or whole cell

package textExcel;

public class SpreadsheetLocation implements Location {
	private int columnNumber;
	private int rowNumber;
	//get row
    public int getRow() {
    	return rowNumber;
    }
    //get column
    public int getCol() {
    	return columnNumber;
    }
    //returns the location of the cell in the spreadsheet by using the name of the cell
    public SpreadsheetLocation(String cellName) {
    	columnNumber = Character.getNumericValue(cellName.charAt(0)) - 10;
    	rowNumber = ParseInt(cellName.substring(1)) - 1;
    }
    //returns the input as the integer value
    private int ParseInt(String input) {
		return Integer.valueOf(input);
	}
}