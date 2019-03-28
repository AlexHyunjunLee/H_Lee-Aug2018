// @author Alex Lee
// @version March 4, 2019

package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
// Update this file with your own code.

public class TextExcel {
	public static void main(String[] args) {
	    // Add your command loop here
		Spreadsheet grid = new Spreadsheet();
		System.out.println(grid.getGridText());
		Spreadsheet Mainspreadsheet = new Spreadsheet();
	    Scanner userInput = new Scanner (System.in);
	    String input = "";
	    while(!input.equals("quit")) {
	    	input = Mainspreadsheet.processCommand(userInput.nextLine());
	    		System.out.println(input);
	    }
	}
}
