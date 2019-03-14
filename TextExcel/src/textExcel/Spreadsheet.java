package textExcel;

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
		int row = 0, column = 0;
		String place = row + column +"";
		Location cellPlace = new SpreadsheetLocation(place);
		if (command.equals("clear cell")) {
			
		}
		return "";
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
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		
		return null;
	}

}
