// @author Alex Lee
// @version March 4, 2019

package textExcel;

import java.util.ArrayList;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
//constructor
	private int numberOfRows = 20;
	private int numberOfColumns = 12;
	static Cell[][] spreadsheet = new Cell [21][13];
	
	public Spreadsheet() {
		//initialize a 2D array of EmptyCells
		for(int i = 0; i < 21; i++) {
			for(int j = 0; j < 13; j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		// cell, clear, clear cell
		int row, column;
		String returnString = "";
		if (command.contains("=")){
			String[] data = command.split(" ", 3);
			SpreadsheetLocation location = new SpreadsheetLocation(data[0]);
			TextCell cell = new TextCell(data[2]);
			spreadsheet[location.getRow() + 1][location.getCol() + 1] = cell;
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
			}}}
		}
		if (command.equals("")) {
			return "";
		}
		return getGridText();
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return numberOfRows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return numberOfColumns;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return spreadsheet[loc.getRow() + 1][loc.getCol() + 1];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
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
}
