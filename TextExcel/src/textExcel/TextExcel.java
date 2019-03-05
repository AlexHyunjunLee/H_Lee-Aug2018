package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
// Update this file with your own code.

public class TextExcel {
	public static void main(String[] args) {
	    // Add your command loop here
		Spreadsheet Mainspreadsheet = new Spreadsheet();
	    Scanner userInput = new Scanner (System.in);
	    String input = "";
	    while(!input.equalsIgnoreCase("quit")) {
	    	input = Mainspreadsheet.processCommand(userInput.nextLine());
	    	System.out.println(input);
	    }
	}
}
