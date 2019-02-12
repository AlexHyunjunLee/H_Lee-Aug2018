import java.util.ArrayList;

public class ThereAndBackAgain 
{

	public static void main(String[] args) {
		
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Dwarf gimli = new Dwarf("Gimli");
		Wizard gandalf = new Wizard("Gandalf", "grey");
		
		// Create a traveling party called party1 by creating an array of Travelers 
		// and filling it with frodo, sam, and gimli
		Traveler[] party1 = {frodo, sam, gimli};
		// Then, use a loop to make all travelers go a distance of 50 miles  
		for(int i=0; i<=party1.length;i++) {
			party1[i].travel(50);
		}
		for(int i=0; i<party1.length;i++) {
			System.out.println(party1[i].getName()+ " has traveled "+party1[i].getDistanceTraveled()+" miles");
			}
		// Then, for each Traveler in the travelingParty, print their name and how far they've
		//    traveled in miles.  (In the next piece, you'll do this in methods, but 
		//    for a first pass, just do it in main and print to the console.)
		// Expected output:  Frodo has traveled 50 miles.
		//                   Sam has traveled 50 miles.
		//                   Gimli has traveled 50 miles.
		
		
		
		
		
		
		System.out.println();

	}

	
}
