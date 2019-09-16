import java.util.*;

public class blackJack {
	public static void main(String[] args) {	
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int cards1;
		int cards2;
		int pTotal;
		int dCards1;
		int dCards2;
		int dTotal;
		String play = "hit";
		int deci = -1;
		boolean gCont = true;
		boolean pCont = true;
		boolean dCont = true;
		boolean pWin = false;
		boolean playerBroke = false;
		System.out.println("Welcome to the Black Jack tabel, I hope your hand is to your liking");
		while(gCont == true) {
			gCont = true;
			pCont = true;
			dCont = true;
			pWin = false;
			playerBroke = false;
			cards1 = 0;
			cards2 = 0;
			play = "hit";
			cards1 = rand.nextInt(10) + 1;
			cards2 = rand.nextInt(10) + 1;
			pTotal = cards1 + cards2;
			System.out.println("Your total is " + pTotal + " from having a " + cards1 + " and a " + cards2);
			if (pTotal == 21) {
				System.out.println("You win, congradulations");
				pCont = false;
				pWin = true;
				playerBroke = true; //Note that in the is scenario the player did not break, we are just reusing a variable to stop the code for the dealer code from running
			}
			while (pCont == true) {
				System.out.println("Would you like to take another card?");
				System.out.println("Yes or No?");
				play = scan.next();
				if (play.equals("Yes") || play.equals("yes")) {
					cards1 = rand.nextInt(11) + 1;
					System.out.println("Your total right now is " + pTotal + " and your new card is a " + cards1);
					pTotal = pTotal + cards1;
					System.out.println("Having your grand total became a total of "  + pTotal);
					if (pTotal == 21) {
						System.out.println("You win, congradulations");
						pCont = false;
						dCont = false;
						playerBroke = true; //Note that in the is scenario the player did not break, we are just reusing a variable to stop the code for the dealer code from running
						}
					if (pTotal > 21){
						System.out.println("You broke, sorry you lose");
						System.out.println("Try again, if your feeling lucky");
						pCont = false;
						pWin = true;
						playerBroke = true;
						}
				}
				else {
					System.out.println("Lets hope luck is in your favor then!");
					pCont = false;
				}
			}
			
			//END OF PLAYER TURN
			if (playerBroke == false) {
				System.out.println("Now its time for the dealers turn");
				dCards1 = rand.nextInt(10) +1;
				dCards2 = rand.nextInt(10) + 1;
				dTotal = dCards1 + dCards2;
				System.out.println("The dealer has draw a " + dCards1 + " and a " + dCards2 + " for a total of " + dTotal);	
				if (dTotal == 21) {
					System.out.println("The deal has acheived a 21, what do you have?");
					if (dTotal == 21 && pTotal == 21) {
						System.out.println("In this game we give do Player's advantage, PLAYER WINS the hand!");
						dCont = false;
					}
					else {
						System.out.println("The dealer has a 21, while the player dose not, THE DEALER WINS the hand");
						dCont = false;
					}
				}
				if (dCont == true) {
					while (dTotal < 17) {
						dCards1 = rand.nextInt(10) + 1;
						System.out.println("The dealers total is currently " + dTotal);
						dTotal = dTotal + dCards1;
						System.out.println("The dealer has draw a " + dCards1 + " and has a new total of " + dTotal);
						System.out.println();
					}
					if (dTotal == 21) {
						System.out.println("The deal has acheived a 21, what do you have?");
						if (dTotal == 21 && pTotal == 21) {
							System.out.println("In this game we give do Player's advantage, PLAYER WINS the hand!");
							dCont = false;
						}
						else {
							System.out.println("The dealer has a 21, while the player dose not, THE DEALER WINS the hand");
							dCont = false;
						}
					}
					else if(dTotal > 21) {
						System.out.println("The Dealer has broken, and has lost, THE PLAYER HAS WON the hand");
						dCont = false;
					}
					else if(dTotal > pTotal) {
						System.out.println("The Dealer has a total of " + dTotal + " and the player has a total of " + pTotal + " thus THE DEALER WINS the hand");
						dCont = false;
					}
					else if(dTotal < pTotal) {
						System.out.println("The Dealer has a total of " + dTotal + " and the player has a total of " + pTotal + " thus THE PLAYER WINS the hand");
						dCont = false;
					}
				}
			}
			System.out.println();
			System.out.println("****************END OF HAND****************************");
			System.out.println();
			
			System.out.println("Would you like to play another hand");
			System.out.println("Press 1 for yes and 2 for no");
			deci = scan.nextInt();
			while (deci != 1 && deci != 2) {
				System.out.println("Please supply 1 for yes and 2 for no");
				deci = scan.nextInt();
			}
			if (deci == 2) {
				gCont = false;
			}
		}
		System.out.println("Thank you, and we hope you join us for Black Jack on another day");
	}
}

