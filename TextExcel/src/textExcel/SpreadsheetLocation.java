// @author Alex Lee
// @version March 4, 2019

package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int columnNumber;
	private int rowNumber;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
    	return rowNumber;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
    	return columnNumber;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	columnNumber = Character.getNumericValue(cellName.charAt(0)) - 10;
    	rowNumber = ParseInt(cellName.substring(1)) - 1;
    }
    private int ParseInt(String substring) {
		return Integer.valueOf(substring);
	}
}
