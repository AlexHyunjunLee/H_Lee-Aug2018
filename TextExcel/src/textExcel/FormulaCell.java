// @author Alex Lee
// @version March 19, 2019
//This class contain methods for the formula cell

package textExcel;

public class FormulaCell extends RealCell {
	Cell [][] newSpreadsheet = Spreadsheet.dataTable;
	//constructor
	public FormulaCell(String input) {
		super(input);
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String cellContents = this.getDoubleValue()+ "          ";//adds 10 spaces in order to fill up the needed part
		return(cellContents.substring(0, 10));
	}
	//calculates the formula of a formula cell
	public double getDoubleValue() {
		String [] arr = super.fullCellText().substring(2, super.fullCellText().length()-2).split(" ");
		double value = 0.0;
		double valueForCalc = 0.0;
		if(arr[0].toLowerCase().equals("sum") || arr[0].toLowerCase().equals("avg")) {//Evaluation of arithmetic formula
			int count = 0;//counts how many cells were used in this calculation (for finding average value)
			String [] arr2 = arr[1].split("-");
			SpreadsheetLocation firstCell = new SpreadsheetLocation(arr2[0]);
			SpreadsheetLocation lastCell = new SpreadsheetLocation(arr2[1]);
			for(int row = firstCell.getRow() + 1; row <= lastCell.getRow() + 1; row++) {
				for(int col = firstCell.getCol() + 1; col <= lastCell.getCol() + 1; col++) {
					if(newSpreadsheet[row][col] instanceof FormulaCell) {
						value += ((RealCell) newSpreadsheet[row][col]).getDoubleValue();
					} else {
						value += Double.valueOf(newSpreadsheet[row][col].fullCellText());
					}
					count ++;
				}
			}
			if(arr[0].toLowerCase().equals("avg") && count > 1) {
				value = value/count;//averaging
			}
		} else {//checkpoint 3-4
			if(isNumeric(arr[0].substring(0, 1))) {
				value = Double.valueOf(arr[0]);
			} else {
				SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
				if(newSpreadsheet[location.getRow() + 1][location.getCol() + 1] instanceof FormulaCell) {//adds "+1" because first row/col are headings. (eg. 1st row is actually in the 2nd row)
					value = ((RealCell) newSpreadsheet[location.getRow() + 1][location.getCol() + 1]).getDoubleValue();
				} else {
					value = Double.valueOf(newSpreadsheet[location.getRow() + 1][location.getCol() + 1].fullCellText());
				}
			}
			for(int i = 0; i < arr.length - 1; i += 2) {
				if(isNumeric(arr[i+2].substring(0, 1))) {
					valueForCalc = Double.valueOf(arr[i+2]);
				} else {
					SpreadsheetLocation location = new SpreadsheetLocation(arr[i+2]);
					if(newSpreadsheet[location.getRow() + 1][location.getCol() + 1] instanceof FormulaCell) {
						valueForCalc = ((RealCell) newSpreadsheet[location.getRow() + 1][location.getCol() + 1]).getDoubleValue();
					} else {
						valueForCalc = Double.valueOf(newSpreadsheet[location.getRow() + 1][location.getCol() + 1].fullCellText());
					}
				}
				if(arr[i+1].equals("+")) {//if it is addition
					value += valueForCalc;
				} else if(arr[i+1].equals("-")) {//if it is subtraction
					value -= valueForCalc;
				} else if(arr[i+1].equals("*")) {//if it is multiplication
					value *= valueForCalc;
				} else if(arr[i+1].equals("/")) {//if it is division
					value /= valueForCalc;
				}
			}
		}
		return value;
	}
	//Tests if a string is numeric (only containing number, a '.', or a '-') Got it from the spreadsheet
	public boolean isNumeric(String input) {
		String testedValue = input;
		boolean returnValue = true;
		if(input.charAt(0) == '-') {//if it has the negative sign		
			testedValue = input.substring(1);			
		} 
		for(int i=0; i<testedValue.length(); i++) {
			if(testedValue.charAt(i) != '.') {//if it doesn't have the decimal point, it checks for that value
				if(!Character.isDigit(testedValue.charAt(i))) {//if it is number, it is true, but if it is letter, it returns false
					return !returnValue;
				}
			}
		}
		return returnValue;
	}
}