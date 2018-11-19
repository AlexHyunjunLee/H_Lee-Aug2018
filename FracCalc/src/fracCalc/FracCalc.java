package fracCalc;
import java.util.Scanner;
/*This class contains the methods that are used to calculate fractions
 * @author Alex Lee
 * @versions November 19, 2018
 */
public class FracCalc {
	static Scanner input = new Scanner(System.in);
	
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	boolean done = false;
    	while (!done) {
    		System.out.println("Type in the calculation");
    		String expression = input.nextLine();
    		System.out.println(FracCalc.produceAnswer(expression));
    		System.out.println("More calculations? (Type \"quit\" to end)");
			input.nextLine();// Consume newline left-over
			String result = input.nextLine();
			String answer = result.replaceAll("\\s","");//removing spaces
			if (answer.toLowerCase().contains("quit")) {//if the input contains the word "quit" regardless of the caps 
				done = true;
			}
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
    	FracCalc.prepareAnswer(input);
    	
        
        return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String prepareAnswer(String input) {
    	String[] wholeCalc = input.split(" ");
    	String frac1I = wholeCalc[0];
    	String operatorI = wholeCalc[1];
    	String frac2I = wholeCalc[2];
    	String[] frac1
    	String operator
    	String frac2
    	return frac1I + operatorI + frac2I;
    }
    
    public static String calculate(String frac1, String operator, String frac2) {
    	if (operator=="+") {
    		FracCalc.addition(frac1, operator, frac2);
    	} else if (operator=="-") {
    		
    	} else if (operator=="*") {
    		
    	} else if (operator=="/") {
    		
    	}
    	return "";
    }
    
    public static String addition(String frac1, String operator, String frac2) {
    	
    	String result = "";
    	return result;
    }
}
