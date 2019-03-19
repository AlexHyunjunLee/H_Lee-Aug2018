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
						System.out.println(data[2] + " hello");
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
					}
				}
			}
		}
		if (command.equals("")) {
			return "";
		}
		if (command.toLowerCase().contains("sorta")){
			String[] data = command.split(" ", 2)[1].split("-");
			SpreadsheetLocation starter = new SpreadsheetLocation(data[0]);
			SpreadsheetLocation ender = new SpreadsheetLocation(data[1]);
			ArrayList <String> sorting = new ArrayList<String>();
			for (int i = starter.getRow() ; i <= ender.getRow() ; i++) {
				for (int j = starter.getCol() ; j <=ender.getCol(); j++) {
					sorting.add(spreadsheet[i+1][j+1].fullCellText());
				}
			}
			//String print = "";
			//for (String ele : sorting) {
			//	print += " "+ele;
			//}
			//System.out.println(print);
			//up to here works fine
			int count2;
			for (count2=0; count2 < sorting.size() ; count2++) {
				for (int count3=count2+1; count3 < sorting.size() ; count3++) {
					if (Character.getNumericValue(sorting.get(count2).charAt(0)) > Character.getNumericValue(sorting.get(count3).charAt(0))) {
						String backup = sorting.get(count2);//changed the > sign above for sortd
						sorting.set(count2, sorting.get(count3));
						sorting.set(count3, backup);
					} else {
						int count = 0;
						while (Character.getNumericValue(sorting.get(count2).charAt(count)) == Character.getNumericValue(sorting.get(count3).charAt(count))) {
							count ++;
						}
						if (Character.getNumericValue(sorting.get(count2).charAt(count)) > Character.getNumericValue(sorting.get(count3).charAt(count))) {
							String backup = sorting.get(count2);//changed the > sign above for sortd
							sorting.set(count2, sorting.get(count3));
							sorting.set(count3, backup);
						}
					}
				}
			}
			//for (String ele : sorting) {
			//	print += " "+ele;
			//}
			//System.out.println(""+sorting.size() + print);
			//print test of arraylist
			
			int count = 0;
			for (int i = starter.getRow() ; i <= ender.getRow() ; i++) {
				for (int j = starter.getCol() ; j <=ender.getCol(); j++) {
					spreadsheet[i+1][j+1] = new TextCell(sorting.get(count));
					count++;
				}
			}
		}
		if (command.contains("sortd")){
			String[] data = command.split(" ", 2)[1].split("-");
			SpreadsheetLocation starter = new SpreadsheetLocation(data[0]);
			SpreadsheetLocation ender = new SpreadsheetLocation(data[1]);
			ArrayList <String> sorting = new ArrayList<String>();
			for (int i = starter.getRow() ; i <= ender.getRow() ; i++) {
				for (int j = starter.getCol() ; j <=ender.getCol(); j++) {
					sorting.add(spreadsheet[i+1][j+1].abbreviatedCellText());
				}
			}
			//String print = "";
			//for (String ele : sorting) {
			//	print += " "+ele;
			//}
			//System.out.println(print);
			//up to here works fine
			int count2;
			for (count2=0; count2 < sorting.size() ; count2++) {
				for (int count3=count2+1; count3 < sorting.size() ; count3++) {
					if (Character.getNumericValue(sorting.get(count2).charAt(0)) < Character.getNumericValue(sorting.get(count3).charAt(0))) {
						String backup = sorting.get(count2);//changed the > sign above for sortd
						sorting.set(count2, sorting.get(count3));
						sorting.set(count3, backup);
					} else {
						int count = 0;
						while (Character.getNumericValue(sorting.get(count2).charAt(count)) == Character.getNumericValue(sorting.get(count3).charAt(count))) {
							count ++;
						}
						if (Character.getNumericValue(sorting.get(count2).charAt(count)) < Character.getNumericValue(sorting.get(count3).charAt(count))) {
							String backup = sorting.get(count2);//changed the > sign above for sortd
							sorting.set(count2, sorting.get(count3));
							sorting.set(count3, backup);
						}
					}
				}
			}
			//for (String ele : sorting) {
			//	print += " "+ele;
			//}
			//System.out.println(""+sorting.size() + print);
			//print test of arraylist
			
			int count = 0;
			for (int i = starter.getRow() ; i <= ender.getRow() ; i++) {
				for (int j = starter.getCol() ; j <=ender.getCol(); j++) {
					spreadsheet[i+1][j+1] = new TextCell(sorting.get(count));
					count++;
				}
			}
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
