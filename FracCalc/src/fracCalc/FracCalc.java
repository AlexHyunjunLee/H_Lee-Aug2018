package fracCalc;
import java.util.Arrays;
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
    		System.out.println("More calculations? (Type \"yes\" to continue or \"quit\" to end)");
			input.nextLine();// Consume newline left-over
			String result = input.nextLine();
			String check = result.replaceAll("\\s","");//removing spaces
			if (check.toLowerCase().contains("quit")) {//if the input contains the word "quit" regardless of the caps 
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
    	String fraction1 = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ")), (input.indexOf(" ")+ 3)); 
        String fraction2 = input.substring(input.lastIndexOf(" ") + 1);
        int[] frac1 = parseFrac(fraction1);
        int[] frac2 = parseFrac(fraction2);
        frac1 = toImproperFrac(frac1[0], frac1[1], frac1[2]);
        frac2 = toImproperFrac(frac2[0], frac2[1], frac2[2]);
    	int[] result = new int [3];
    	if (operator.equals(" + ")) {
    		result = addition(frac1, frac2);
    	} else if (operator.equals(" - ")) {
    		result = subtraction(frac1, frac2);
    	} else if (operator.equals(" * ")) {
    		result = multiplication(frac1, frac2);
    	} else if (operator.equals(" / ")) {
    		result = division(frac1, frac2);
    	}
    	result = reduceFrac(result);
    	if (result[1]==0) {//if numerator is zero, the value is whole number
        	return "" + result[0];
        }
    	if (result[0]==0) {
        	return result[1] + "/" + result[2];
        } else {
        	return result[0] + "_" + result[1] + "/" + result[2];
        }
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static int[] parseFrac(String frac) {
    	int whole = 0;
        int numerator = 0;
        int denominator = 1;
        if (frac.indexOf("_") > 0) {// Test if there is an whole number.
        	whole = Integer.valueOf(frac.substring(0, frac.indexOf("_")));
        }
        if (frac.indexOf("/") < 0) {// Test if there is a fraction.
        	whole = Integer.valueOf(frac);
        } else {
        	numerator = Integer.valueOf(frac.substring(frac.indexOf("_") + 1, frac.indexOf("/")));
        	denominator = Integer.valueOf(frac.substring(frac.indexOf("/") + 1));
        }
    	int[] finalFrac = {whole, numerator, denominator};
    	return finalFrac;
    }
    
    public static String prepareCalc(String input) {
    	String[] wholeCalc = input.split(" ");
    	String[] frac1 = {wholeCalc[0]};
    	String[] operator = {wholeCalc[1]};
    	String[] frac2 = {wholeCalc[2]};
    	return Arrays.toString(frac1) + Arrays.toString(operator) + Arrays.toString(frac2);
    }
    
    public static void calculate(String[] frac1, String[] operator, String[] frac2) {
    	if (Arrays.toString(operator)=="+") {
    	} else if (Arrays.toString(operator)=="-") {
    	} else if (Arrays.toString(operator)=="*") {
    	} else if (Arrays.toString(operator)=="/") {
    	}
    }
    
    public static int[] toImproperFrac(int whole, int numerator, int denominator) {
    	if (whole >= 0){
    	numerator = ((whole * denominator) + numerator);
    	} else {
    		whole *= -1;
    		numerator = ((whole * denominator) + numerator);
    		numerator *= -1;
    	}
    	int finalfrac[] = new int [] {0, numerator, denominator};
    	return finalfrac;   	
    }
    
    public static int[] addition(int[] frac1, int[] frac2) {
    	int [] result = new int [3];
    	result [2]= frac1[2] * frac2[2];//denominator is multiplication of two denominators
    	result [1]= (frac1[1] * frac2[2]) + (frac2[1] * frac1[2]);
    	return result;
    }
    
    public static int[] subtraction(int[] frac1, int[] frac2) {
    	int [] result = new int [3];
    	result [2]= frac1[2] * frac2[2];//denominator is multiplication of two denominators
    	result [1]= (frac1[1] * frac2[2]) - (frac2[1] * frac1[2]);
    	return result;
    }
    
    public static int[] multiplication(int[] frac1, int[] frac2) {
    	int [] result = new int [3];
    	result [2]= frac1[2] * frac2[2];//denominator is multiplication of two denominators
    	result [1]= (frac1[1] * frac2[1]);
    	return result;
    }
    
    public static int[] division(int[] frac1, int[] frac2) {
    	int [] result = new int [3];
    	result [2]= frac1[2] * frac2[1];//denominator is multiplication of two denominators
    	result [1]= (frac1[1] * frac2[2]);
    	return result;
    }
    
    public static int [] reduceFrac(int [] calculatedFrac) {
    	int gcf;
    	int finalFrac[]= calculatedFrac;
    	finalFrac = toImproperFrac(finalFrac[0], finalFrac[1], finalFrac[2]);
    	if (finalFrac[2]<0) {//checking that the denominator is positive
    		finalFrac[2] *= -1;
    		finalFrac[1] *= -1;
    	}	
    	finalFrac[0] += finalFrac[1]/finalFrac[2];//convert improper fraction to whole fraction
    	finalFrac[1] = finalFrac[1]%finalFrac[2];
    	if(finalFrac[0]!=0 && finalFrac[1]<0) {
    		finalFrac[1] *= -1;	
    	}
    	gcf = gcf(finalFrac[1], finalFrac[2]);//calculate GCF to simplify the fraction
    	finalFrac[1] /= gcf;
    	finalFrac[2] /= gcf;
    	return finalFrac;
    }
    
  //Calculates the greatest common factor of two integers
    public static int gcf(int numerator, int denominator) {
    	int gcf = 1; // Set the initial value of gcf to 1 (the lowest possible gcf)
		int count; // Set it to whichever number is larger.
    	if (numerator == denominator || numerator > denominator ) {
    		count = numerator;
    	} else {
    		count = denominator;
    	}
		for (int i = 1; i < Math.abs(count); i++) {
			if(numerator % i == 0 && denominator % i == 0) {
				gcf = i;
			}
		}
		return gcf;
    }
    
}
