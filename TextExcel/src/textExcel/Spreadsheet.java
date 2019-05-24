// @author Alex Lee
// @version March 4, 2019
//This class contain methods to make the spreadsheet and to command any changes to it

package textExcel;

import java.util.ArrayList;
import java.util.Collections;

public class Spreadsheet implements Grid	{
	private int numberOfRows = 20;
	private int numberOfColumns = 12;
	static Cell [][] dataTable = new Cell [21][13];//one more row for the Alphabet and more column for the number
	//constructor - puts empty cells initially
	public Spreadsheet() {
		for(int row = 0; row <= 20; row++) {
			for(int col = 0; col <= 12; col++) {
				dataTable [row][col] = new EmptyCell();
			}
		}
	}
	//method used to command changes in the spreadsheet
	public String processCommand(String command)	{
		if (command.contains("=")){//if it is assigning values into the cell
			whichCell(command);
			return getGridText();
		}
		if (command.length() <= 3 && command.length() != 0) {//if it is less than or equal to length of 3, it is definitely asking for the full cell text of that cell
			SpreadsheetLocation location = new SpreadsheetLocation(command);
			return dataTable [location.getRow()+1][location.getCol()+1].fullCellText();
		}
		if (command.toLowerCase().contains("clear ")) {//if the command is to clear certain cell, it just replace the cell with empty cell
			String [] splitInput = command.split(" ", 2);
			SpreadsheetLocation location = new SpreadsheetLocation(splitInput[1]);
			dataTable[location.getRow() + 1][location.getCol() + 1] = new EmptyCell();
		} else { 
			if (command.toLowerCase().equals("clear")) {//if the command is just clear, it clears entire spreadsheet
				for(int row = 0; row < 21; row++) {
					for(int col = 0; col < 13; col++) {
						dataTable [row][col] = new EmptyCell();
					}
				}
			}
		}
		if (command.equals("")) {
			return "";
		}
		if (command.toLowerCase().contains("sorta")){
			String[] data = command.split(" ", 2)[1].split("-");//example: J10-L19
			SpreadsheetLocation startCell = new SpreadsheetLocation(data[0]);
			SpreadsheetLocation endCell = new SpreadsheetLocation(data[1]);
			ArrayList <String> sortingAlphabet = new ArrayList<String>();
			ArrayList <Double> sortingNumber = new ArrayList<Double>();
			for (int row = startCell.getRow(); row <= endCell.getRow(); row++) {
				for (int col = startCell.getCol(); col <=endCell.getCol(); col++) {
					if(isNumeric(dataTable[row+1][col+1].fullCellText())) {
						sortingNumber.add(Double.valueOf(dataTable[row+1][col+1].fullCellText()));//stores every value into array list
					} else {
						sortingAlphabet.add(dataTable[row+1][col+1].fullCellText());//stores every value into array list
					}
				}
			}//variable count is needed because in this code, I have to count the how much I'm repeating multiple times
			for (int count1=0; count1 < sortingAlphabet.size(); count1++) {
				for (int count2=count1+1; count2 < sortingAlphabet.size(); count2++) {
					if (sortingAlphabet.get(count1).compareTo(sortingAlphabet.get(count2))>0) {//only needs first character; greater number for char means that it is the alphabet coming after
						String characterComingAfter = sortingAlphabet.get(count1);
						sortingAlphabet.set(count1, sortingAlphabet.get(count2));
						sortingAlphabet.set(count2, characterComingAfter);
					}
				}
			}
			for (int count1=0; count1 < sortingNumber.size(); count1++) {
				for (int count2=count1+1; count2 < sortingNumber.size(); count2++) {
					if (sortingNumber.get(count1).compareTo(sortingNumber.get(count2))>0) {//only needs first character; greater number for char means that it is the alphabet coming after
						Double characterComingAfter = sortingNumber.get(count1);
						sortingNumber.set(count1, sortingNumber.get(count2));
						sortingNumber.set(count2, characterComingAfter);
					}
				}
			}
			ArrayList<String> sortedData = new ArrayList<String>();
			for(int i=0;i<sortingNumber.size();i++){//add sorted numbers into final sorted arraylist
	            sortedData.add(""+sortingNumber.get(i));
	        } 
			for(int i=0;i<sortingAlphabet.size();i++){//add sorted words into final sorted arraylist
	            sortedData.add(sortingAlphabet.get(i));
	        }
			int count = 0;//counting until it reaches the final value that has to be stored into the cell.
			for (int row = startCell.getRow(); row <= endCell.getRow(); row++) {
				for (int col = startCell.getCol(); col <=endCell.getCol(); col++) {
					dataTable[row+1][col+1] = new TextCell(sortedData.get(count));
					count++;
				}
			}
		}
		if (command.toLowerCase().contains("sortd")){
			String[] data = command.split(" ", 2)[1].split("-");//example: J10-L19
			SpreadsheetLocation startCell = new SpreadsheetLocation(data[0]);
			SpreadsheetLocation endCell = new SpreadsheetLocation(data[1]);
			ArrayList <String> sortingAlphabet = new ArrayList<String>();
			ArrayList <Double> sortingNumber = new ArrayList<Double>();
			for (int row = startCell.getRow(); row <= endCell.getRow(); row++) {
				for (int col = startCell.getCol(); col <=endCell.getCol(); col++) {
					if(isNumeric(dataTable[row+1][col+1].fullCellText())) {
						sortingNumber.add(Double.valueOf(dataTable[row+1][col+1].fullCellText()));//stores every value into array list
					} else {
						sortingAlphabet.add(dataTable[row+1][col+1].fullCellText());//stores every value into array list
					}
				}
			}//variable count is needed because in this code, I have to count the how much I'm repeating multiple times
			for (int count1=0; count1 < sortingAlphabet.size(); count1++) {
				for (int count2=count1+1; count2 < sortingAlphabet.size(); count2++) {
					if (sortingAlphabet.get(count1).compareTo(sortingAlphabet.get(count2))<0) {//only needs first character; greater number for char means that it is the alphabet coming after
						String characterComingAfter = sortingAlphabet.get(count1);
						sortingAlphabet.set(count1, sortingAlphabet.get(count2));
						sortingAlphabet.set(count2, characterComingAfter);
					}
				}
			}
			for (int count1=0; count1 < sortingNumber.size(); count1++) {
				for (int count2=count1+1; count2 < sortingNumber.size(); count2++) {
					if (sortingNumber.get(count1).compareTo(sortingNumber.get(count2))<0) {//only needs first character; greater number for char means that it is the alphabet coming after
						Double characterComingAfter = sortingNumber.get(count1);
						sortingNumber.set(count1, sortingNumber.get(count2));
						sortingNumber.set(count2, characterComingAfter);
					}
				}
			}
			ArrayList<String> sortedData = new ArrayList<String>();
			for(int i=0;i<sortingNumber.size();i++){//add sorted numbers into final sorted arraylist
	            sortedData.add(""+sortingNumber.get(i));
	        } 
			for(int i=0;i<sortingAlphabet.size();i++){//add sorted words into final sorted arraylist
	            sortedData.add(sortingAlphabet.get(i));
	        }
			int count = 0;//counting until it reaches the final value that has to be stored into the cell.
			for (int row = startCell.getRow(); row <= endCell.getRow(); row++) {
				for (int col = startCell.getCol(); col <=endCell.getCol(); col++) {
					dataTable[row+1][col+1] = new TextCell(sortedData.get(count));
					count++;
				}
			}
		}
		return getGridText();
	}
	//checks if the cell is text, value, formula, or percent (created for the processCommand)
	public void whichCell (String command) {
		String[] data = command.split(" ", 3);
		SpreadsheetLocation location = new SpreadsheetLocation(data[0]);
		if (isNumeric(data[2])) {//if it is value cell
			ValueCell valueCell = new ValueCell(data[2]);
			dataTable[location.getRow() + 1][location.getCol() + 1] = valueCell;	
		} else if (data[2].contains("%")) {//if it is percent cell
			PercentCell percentCell = new PercentCell(data[2]);
			dataTable[location.getRow() + 1][location.getCol() + 1] = percentCell;	
		} else if(data[2].substring(0,1).equals("(") && (command.contains("+") || command.contains("-") || command.contains("*") || command.contains("/") || command.substring(command.length()-1).equals(")"))) {
			FormulaCell formulaCell = new FormulaCell(data[2]);//if it is formula cell
			dataTable[location.getRow() + 1][location.getCol() + 1] = formulaCell;
		} else {//if it is not value, formula, or percent, it has to be text cell
			TextCell cell = new TextCell(data[2]);
			System.out.println(data[2]);
			dataTable[location.getRow() + 1][location.getCol() + 1] = cell;
		}
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
		return dataTable[loc.getRow() + 1][loc.getCol() + 1];
	}
	//Returns the entire spreadsheet
	public String getGridText() {
		String grid = "";
		char colCount = 'A';
		for(int row = 0; row <= 20; row++) {
			for(int col = 0; col <= 12; col++) {
				if(row == 0) {
					if(col == 0) {
						grid += "   |";
					} else {
						grid += "" + colCount + "         |";
						colCount++;	
					}
				} else {
					if (col == 0) {
						if(row < 10) {
							grid += "" + row + "  |";
						} else {
							grid += "" + row + " |";
						}
					} else {
						String cell = dataTable[row][col].abbreviatedCellText();//fill in with the abbreviated values
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
		} else {
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