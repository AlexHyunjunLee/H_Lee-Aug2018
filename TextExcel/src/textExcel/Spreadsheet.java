// @author Alex Lee
// @version March 4, 2019
package textExcel;

import java.util.ArrayList;
import java.util.Collections;

// Update this file with your own code.

public class Spreadsheet implements Grid	{
	private int numberOfRows = 20;
	private int numberOfColumns = 12;
	static Cell [][] spreadsheet = new Cell [21][13];

	public Spreadsheet() {
		for(int i = 0; i < 21; i++) {
			for(int j = 0; j < 13; j++) {
				spreadsheet [i][j] = new EmptyCell();
			}
		}
	}
	
	public String processCommand(String command)	{
		int row, column;
		String returnString = "";
		if (command.contains("=")){
			String[] data = command.split(" ", 3);
			SpreadsheetLocation location = new SpreadsheetLocation(data[0]);
			if (isNumeric(data[2])) {
				ValueCell valueCell = new ValueCell(data[2]);
				spreadsheet[location.getRow() + 1][location.getCol() + 1] = valueCell;	
				return getGridText();
			} else {
				if (data[2].contains("%")) {
					PercentCell percentCell = new PercentCell(data[2]);
					spreadsheet[location.getRow() + 1][location.getCol() + 1] = percentCell;	
					return getGridText();
				} else { 
					if(data[2].substring(0,1).equals("(") && (command.contains("+") || command.contains("-") || command.contains("*") || command.contains("/") || command.substring(command.length()-1).equals(")"))) {
						FormulaCell formulaCell = new FormulaCell(data[2]);
						spreadsheet[location.getRow() + 1][location.getCol() + 1] = formulaCell;
						return getGridText();
					} else {//needs to be fixed
						TextCell cell = new TextCell(data[2]);
						System.out.println(data[2]);
						spreadsheet[location.getRow() + 1][location.getCol() + 1] = cell;
					}
				}
			}
		}
		if (command.length() <= 3 && command.length() != 0) {
			SpreadsheetLocation location = new SpreadsheetLocation(command);
			return spreadsheet [location.getRow()+1][location.getCol()+1].fullCellText();
		}
		if (command.toLowerCase().contains("clear ")) {
			String [] splitInput2 = command.split(" ", 2);
			SpreadsheetLocation location = new SpreadsheetLocation(splitInput2[1]);
			spreadsheet[location.getRow() + 1][location.getCol() + 1] = new EmptyCell();
		} else { 
			if (command.toLowerCase().equals("clear")) {
				for(int i = 0; i < 21; i++) {
					for(int j = 0; j < 13; j++) {
						spreadsheet [i][j] = new EmptyCell();
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

	public Cell getCell(Location loc)
	{
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
						String test = spreadsheet[row][col].abbreviatedCellText();
						if(test.equals("")){
							grid += "          |";
						} else {
							grid += test + "|";
						}
					}
				
				}
			}	
		grid += "\n";
		}
	return grid;
	}
	public boolean isNumeric(String input) {
		String testString;
		boolean returnValue = true;
		if(input.charAt(0) == '-') {			
			testString = input.substring(1);			
		}
		else {
			testString = input;	
		}
	
		for(int i = 0; i < testString.length(); i ++) {
			if(testString.charAt(i) != '.') {
				if(!Character.isDigit(testString.charAt(i))) {
					return !returnValue;
				}
			}
		}
			return returnValue;
	}
}