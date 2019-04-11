// @author Alex Lee
// @version March 4, 2019
//This class contain methods to make the spreadsheet and to command any changes to it

package textExcel;

public class Spreadsheet implements Grid	{
	private int numberOfRows = 20;
	private int numberOfColumns = 12;
	static Cell [][] spreadsheet = new Cell [21][13];
	//constructor - puts empty cells initially
	public Spreadsheet() {
		for(int row = 0; row < 21; row++) {
			for(int col = 0; col < 13; col++) {
				spreadsheet [row][col] = new EmptyCell();
			}
		}
	}
	//method used to command changes in the spreadsheet
	public String processCommand(String command)	{
		if (command.contains("=")){//if it is assigning values into the cell
			String[] data = command.split(" ", 3);
			SpreadsheetLocation location = new SpreadsheetLocation(data[0]);
			if (isNumeric(data[2])) {//if it is value cell
				ValueCell valueCell = new ValueCell(data[2]);
				spreadsheet[location.getRow() + 1][location.getCol() + 1] = valueCell;	
				return getGridText();
			} else if (data[2].contains("%")) {//if it is percent cell
				PercentCell percentCell = new PercentCell(data[2]);
				spreadsheet[location.getRow() + 1][location.getCol() + 1] = percentCell;	
				return getGridText();
			} else if(data[2].substring(0,1).equals("(") && (command.contains("+") || command.contains("-") || command.contains("*") || command.contains("/") || command.substring(command.length()-1).equals(")"))) {
				FormulaCell formulaCell = new FormulaCell(data[2]);//if it is formula cell
				spreadsheet[location.getRow() + 1][location.getCol() + 1] = formulaCell;
				return getGridText();
			} else {//if it is not value, formula, or percent, it has to be text cell
				TextCell cell = new TextCell(data[2]);
				System.out.println(data[2]);
				spreadsheet[location.getRow() + 1][location.getCol() + 1] = cell;
			}
		}
		if (command.length() <= 3 && command.length() != 0) {//if it is less than or equal to length of 3, it is definitely asking for the full cell text of that cell
			SpreadsheetLocation location = new SpreadsheetLocation(command);
			return spreadsheet [location.getRow()+1][location.getCol()+1].fullCellText();
		}
		if (command.toLowerCase().contains("clear ")) {//if the command is to clear certain cell, it just replace the cell with empty cell
			String [] splitInput = command.split(" ", 2);
			SpreadsheetLocation location = new SpreadsheetLocation(splitInput[1]);
			spreadsheet[location.getRow() + 1][location.getCol() + 1] = new EmptyCell();
		} else { 
			if (command.toLowerCase().equals("clear")) {//if the command is just clear, it clears entire spreadsheet
				for(int row = 0; row < 21; row++) {
					for(int col = 0; col < 13; col++) {
						spreadsheet [row][col] = new EmptyCell();
					}
				}
			}
		}
		if (command.equals("")) {
			return "";
		}
		return getGridText();
	}
	//Returns the number of rows in the spreadsheet
	public int getRows() {
		return numberOfRows;
	}
	//Returns the number of columns in the spreadsheet
	public int getCols() {
		return numberOfColumns;
	}
	//returns the cell from the desired location
	public Cell getCell(Location loc) {
		return spreadsheet[loc.getRow() + 1][loc.getCol() + 1];
	}
	//Returns the entire spreadsheet
	public String getGridText() {
		String grid = "";
		char colCount = 'A';
		for(int row = 0; row < 21; row++) {
			for(int col = 0; col < 13; col++) {
				if(row == 0) {
					if(col == 0) {
						grid += "   |";
					} else {
						grid += "" + colCount + "         |";
						colCount++;	
					}
				}
				else {
					if (col == 0) {
						if(row < 10) {
							grid += "" + row + "  |";
						} else {
							grid += "" + row + " |";
						}
					} else {
						String cell = spreadsheet[row][col].abbreviatedCellText();//fill in with the abbreviated values
						if(cell.equals("")){
							grid += "          |";
						} else {
							grid += cell + "|";
						}
					}
				
				}
			}	
		grid += "\n";
		}
		return grid;
	}
	//Tests if a string is numeric (only containing number, a '.', or a '-')
	public boolean isNumeric(String input) {
		String testedValue;
		boolean returnValue = true;
		if(input.charAt(0) == '-') {//if it has the negative sign		
			testedValue = input.substring(1);			
		}
		else {
			testedValue = input;	
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