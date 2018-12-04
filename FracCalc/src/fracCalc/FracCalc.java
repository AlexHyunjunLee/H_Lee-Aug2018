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
    		System.out.println("Type in the calculation (Type \"quit\" to end)");
    		String expression = input.nextLine();
			if (expression.equals("quit")) {//if the input contains the word "quit" regardless of the caps 
				done = true;
			} else if(expression.contains("  ")) {//if there is no fraction then there will be no "/" and also, it can't have double spaces
				FracCalc.checkCondition(expression);
			} else {
				System.out.println(FracCalc.produceAnswer(expression));
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
    public static String calculate(String input) {
    	parseFrac(input);
    	if (input=="") {
    		checkCondition(input);
    	} else {
    		produceAnswer(input);
    	}
    	return "";
    	// NOT DONE...
    }
    
    //changed it to the calculate from the produceAnswer for the extra credit
    //this was originally the produceAnswer
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
    	//separates the string into fraction1, fraction2, operator
    	String fraction1 = input.substring(0, input.indexOf(" "));
        String operator = input.substring((input.indexOf(" ")), (input.indexOf(" ")+ 3));
        String fraction2 = input.substring(input.lastIndexOf(" ") + 1);
        int[] frac1 = parseFrac(fraction1);
        int[] frac2 = parseFrac(fraction2);
        //making them to the improper fraction so that it is easier to calculate
        frac1 = toImproperFrac(frac1[0], frac1[1], frac1[2]);
        frac2 = toImproperFrac(frac2[0], frac2[1], frac2[2]);
        //store the final calculated fraction into the variable named result
    	int[] result = new int [3];
    	//does the calculation based on the types of the operators: +, -, *, /
    	result = calculation(frac1,frac2,operator);
    	result = reduceFrac(result);//reduce
    	return fracForm(result);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    //part of Extra Credit
    //method that detects the index of the nth occurring character 
    public static int findPosition(String str, String substr, int n) {
        int position = str.indexOf(substr);
        while (--n > 0 && position != -1)
        	position = str.indexOf(substr, position + 1);
        return position;
    }
    
    //part of Extra Credit
    //method that checks if the input passed in is available for the calculation
    public static void checkCondition(String calculation) {
    	if (calculation.indexOf("/0")!=-1||calculation.indexOf("* 0/")!=-1) {
    		System.out.println("ERROR: Cannot divide by zero");
    	} if (calculation.contains("++")||calculation.contains("--")||calculation.contains("**")||calculation.contains("//")||calculation.contains("  ")||!calculation.contains("/")||calculation.contains("  ")) {
    		System.out.println("ERROR: Input is in an invalid format");
    	}
    }
    
    //part of Extra Credit
    //IDK
    public static void jeonledongha() {
    	System.out.println("The historical method comprises the techniques and guidelines by which historians use primary sources and other evidence to research and then to write history.\r\n" + 
    			"\r\n" + 
    			"Herodotus of Halicarnassus (484 BC – ca.425 BC)[27] has generally been acclaimed as the \"father of history\". However, his contemporary Thucydides (c. 460 BC – ca. 400 BC) is credited with having first approached history with a well-developed historical method in his work the History of the Peloponnesian War. Thucydides, unlike Herodotus, regarded history as being the product of the choices and actions of human beings, and looked at cause and effect, rather than as the result of divine intervention.[27] In his historical method, Thucydides emphasized chronology, a neutral point of view, and that the human world was the result of the actions of human beings. Greek historians also viewed history as cyclical, with events regularly recurring.[28]\r\n" + 
    			"\r\n" + 
    			"There were historical traditions and sophisticated use of historical method in ancient and medieval China. The groundwork for professional historiography in East Asia was established by the Han dynasty court historian known as Sima Qian (145–90 BC), author of the Records of the Grand Historian (Shiji). For the quality of his written work, Sima Qian is posthumously known as the Father of Chinese historiography. Chinese historians of subsequent dynastic periods in China used his Shiji as the official format for historical texts, as well as for biographical literature.[citation needed]\r\n" + 
    			"\r\n" + 
    			"Saint Augustine was influential in Christian and Western thought at the beginning of the medieval period. Through the Medieval and Renaissance periods, history was often studied through a sacred or religious perspective. Around 1800, German philosopher and historian Georg Wilhelm Friedrich Hegel brought philosophy and a more secular approach in historical study.[22]\r\n" + 
    			"\r\n" + 
    			"In the preface to his book, the Muqaddimah (1377), the Arab historian and early sociologist, Ibn Khaldun, warned of seven mistakes that he thought that historians regularly committed. In this criticism, he approached the past as strange and in need of interpretation. The originality of Ibn Khaldun was to claim that the cultural difference of another age must govern the evaluation of relevant historical material, to distinguish the principles according to which it might be possible to attempt the evaluation, and lastly, to feel the need for experience, in addition to rational principles, in order to assess a culture of the past. Ibn Khaldun often criticized \"idle superstition and uncritical acceptance of historical data.\" As a result, he introduced a scientific method to the study of history, and he often referred to it as his \"new science\".[29] His historical method also laid the groundwork for the observation of the role of state, communication, propaganda and systematic bias in history,[30] and he is thus considered to be the \"father of historiography\"[31][32] or the \"father of the philosophy of history\".[33]\r\n" + 
    			"\r\n" + 
    			"In the West, historians developed modern methods of historiography in the 17th and 18th centuries, especially in France and Germany. The 19th-century historian with greatest influence on methods was Leopold von Ranke in Germany.\r\n" + 
    			"\r\n" + 
    			"In the 20th century, academic historians focused less on epic nationalistic narratives, which often tended to glorify the nation or great men, to more objective and complex analyses of social and intellectual forces. A major trend of historical methodology in the 20th century was a tendency to treat history more as a social science rather than as an art, which traditionally had been the case. Some of the leading advocates of history as a social science were a diverse collection of scholars which included Fernand Braudel, E. H. Carr, Fritz Fischer, Emmanuel Le Roy Ladurie, Hans-Ulrich Wehler, Bruce Trigger, Marc Bloch, Karl Dietrich Bracher, Peter Gay, Robert Fogel, Lucien Febvre and Lawrence Stone. Many of the advocates of history as a social science were or are noted for their multi-disciplinary approach. Braudel combined history with geography, Bracher history with political science, Fogel history with economics, Gay history with psychology, Trigger history with archaeology while Wehler, Bloch, Fischer, Stone, Febvre and Le Roy Ladurie have in varying and differing ways amalgamated history with sociology, geography, anthropology, and economics. More recently, the field of digital history has begun to address ways of using computer technology to pose new questions to historical data and generate digital scholarship.\r\n" + 
    			"\r\n" + 
    			"In opposition to the claims of history as a social science, historians such as Hugh Trevor-Roper, John Lukacs, Donald Creighton, Gertrude Himmelfarb and Gerhard Ritter argued that the key to the historians' work was the power of the imagination, and hence contended that history should be understood as an art. French historians associated with the Annales School introduced quantitative history, using raw data to track the lives of typical individuals, and were prominent in the establishment of cultural history (cf. histoire des mentalités). Intellectual historians such as Herbert Butterfield, Ernst Nolte and George Mosse have argued for the significance of ideas in history. American historians, motivated by the civil rights era, focused on formerly overlooked ethnic, racial, and socio-economic groups. Another genre of social history to emerge in the post-WWII era was Alltagsgeschichte (History of Everyday Life). Scholars such as Martin Broszat, Ian Kershaw and Detlev Peukert sought to examine what everyday life was like for ordinary people in 20th-century Germany, especially in the Nazi period.\r\n" + 
    			"\r\n" + 
    			"Marxist historians such as Eric Hobsbawm, E. P. Thompson, Rodney Hilton, Georges Lefebvre, Eugene Genovese, Isaac Deutscher, C. L. R. James, Timothy Mason, Herbert Aptheker, Arno J. Mayer and Christopher Hill have sought to validate Karl Marx's theories by analyzing history from a Marxist perspective. In response to the Marxist interpretation of history, historians such as François Furet, Richard Pipes, J. C. D. Clark, Roland Mousnier, Henry Ashby Turner and Robert Conquest have offered anti-Marxist interpretations of history. Feminist historians such as Joan Wallach Scott, Claudia Koonz, Natalie Zemon Davis, Sheila Rowbotham, Gisela Bock, Gerda Lerner, Elizabeth Fox-Genovese, and Lynn Hunt have argued for the importance of studying the experience of women in the past. In recent years, postmodernists have challenged the validity and need for the study of history on the basis that all history is based on the personal interpretation of sources. In his 1997 book In Defence of History, Richard J. Evans defended the worth of history. Another defence of history from post-modernist criticism was the Australian historian Keith Windschuttle's 1994 book, The Killing of History.");
    }
    
    //based on the operator(+,-,*,/), does the calculation
    //originally came from the produceAnswer
    public static int[] calculation(int[] frac1, int[] frac2, String operator) {
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
    	return result;
    }
    
    //based on the result, choose the way to print out (whole number or mixed fraction or normal fraction)
    //originally came from the produceAnswer
    public static String fracForm(int[] result) {
    	if (result[1]==0) {//if numerator is zero, the value is whole number
        	return "" + result[0];
        } if (result[0]==0) {
        	return result[1] + "/" + result[2];
        } else {
        	return result[0] + "_" + result[1] + "/" + result[2];
        }
    }
    
    //method that parses the fraction and stores it into the array
    public static int[] parseFrac(String frac) {
    	int whole = 0;
        int numerator = 0;
        int denominator = 1;
        if (frac.indexOf("_") > 0) {// Test if there is an whole number.
        	whole = Integer.valueOf(frac.substring(0, frac.indexOf("_")));
        }
        if (frac.indexOf("/") < 0) {// Test if there is a fraction. if / presents, there is fraction
        	whole = Integer.valueOf(frac);
        } else {
        	numerator = Integer.valueOf(frac.substring(frac.indexOf("_") + 1, frac.indexOf("/")));
        	denominator = Integer.valueOf(frac.substring(frac.indexOf("/") + 1));
        }
    	int[] finalFrac = {whole, numerator, denominator};
    	return finalFrac;
    }
    
    //method that converts any types of fractions to the improper fraction
    public static int[] toImproperFrac(int whole, int numerator, int denominator) {
    	if (whole >= 0){
    	numerator = ((whole * denominator) + numerator);
    	} else {
    		whole *= -1;
    		numerator = ((whole * denominator) + numerator);
    		numerator *= -1;
    	}
    	int finalfrac[] = {0, numerator, denominator};
    	return finalfrac;   	
    }
    
    //method that does addition
    public static int[] addition(int[] frac1, int[] frac2) {
    	int [] result = new int [3];
    	result [2]= frac1[2] * frac2[2];//denominator is multiplication of two denominators
    	result [1]= (frac1[1] * frac2[2]) + (frac2[1] * frac1[2]);
    	return result;
    }
    
    //method that does subtraction
    public static int[] subtraction(int[] frac1, int[] frac2) {
    	int [] result = new int [3];
    	result [2]= frac1[2] * frac2[2];//denominator is multiplication of two denominators
    	result [1]= (frac1[1] * frac2[2]) - (frac2[1] * frac1[2]);
    	return result;
    }
    
    //method that does multiplication
    public static int[] multiplication(int[] frac1, int[] frac2) {
    	int [] result = new int [3];
    	result [2]= frac1[2] * frac2[2];//denominator is multiplication of two denominators
    	result [1]= (frac1[1] * frac2[1]);
    	return result;
    }
    
    //method that does division
    public static int[] division(int[] frac1, int[] frac2) {
    	int [] result = new int [3];
    	result [2]= frac1[2] * frac2[1];//denominator is multiplication of two denominators
    	result [1]= (frac1[1] * frac2[2]);
    	return result;
    }
    
    //method that reduces the fraction into the simplest form that the fraction can be
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
    	if(finalFrac[0]!=0 && finalFrac[1]<0) {//getting rid of the possible negative in the numerator
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
		for (int i=1;i<Math.abs(count);i++) {
			if(numerator%i == 0 && denominator%i == 0) {
				gcf = i;
			}
		}
		return gcf;
    }
    
}
