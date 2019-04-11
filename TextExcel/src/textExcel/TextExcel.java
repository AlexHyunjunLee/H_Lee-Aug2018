// @author Alex Lee
// @version March 4, 2019
//This class is client code for making the spreadsheet with the methods from various classes.

package textExcel;

import java.util.Scanner;
import textExcel.TestsALL.TestLocation;

public class TextExcel {
	public static void main(String[] args) {
		Spreadsheet grid = new Spreadsheet();
		System.out.println(grid.getGridText());
		System.out.println(grid.getCell(new TestLocation(0,0)).fullCellText());
	    Spreadsheet Mainspreadsheet = new Spreadsheet();
	    Scanner userInput  = new Scanner (System.in);
	    String input = "";
	    while(!input.equals ("quit")) {
	    	input = Mainspreadsheet.processCommand(userInput.nextLine());
	    		System.out.println(input);
	    }
	}
}