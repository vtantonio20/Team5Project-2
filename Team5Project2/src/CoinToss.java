import javax.swing.JOptionPane;
/*
 * This program is a coin toss game where the user will get money for flipping a coin if it lands heads.
 * In this program the user will flip a penny, nickel, dime, and quarter(in this order) until they make 1.00$ or more
 * If the user makes more then 1.00$ then they lose the game. If they make exactly 1.00$ they will win the game.
 */
public class CoinToss {

	public static void main(String[] args) {

		//this double variables stores the current balance the player has in the game
		double totalBalence = 0.00;
		//this int variable will control which type of coin is being fliped.
		int coinType = 1;
		
		//the boolean controls weather the prohram is on or off
		boolean runProgram = true;
		
		//all coin type classes
		Penny newPenny = new Penny();
		Nickel newNickel = new Nickel();
		Dime newDime = new Dime();
		Quarter newQuarter = new Quarter();
		
		//this class controls the odds each coin has
		tossOdds odds = new tossOdds();

		//gets input from user to restart the game
		String input = new String();

		
		JOptionPane.showMessageDialog(null, "Welcome to the Coin Toss game");
		
		//This while loop allows the user to choose when to exit the program
		while(runProgram == true) {
			
			//This while loop checks if the user must keep flipping coins
			while(totalBalence < 1.00) {
			
				//this calls the tossOdds class and sets a result for the next coin flip
				odds.setResult();
				
				JOptionPane.showConfirmDialog(null, "Balence: " + Math.round(totalBalence * 100) + "¢");
				//This switch statement goes through each coin type and adds its value to the total if it is flipped
				if(odds.getResult() == 1) {
					
					//this switch statement goes through each of the coin types
					switch(coinType) {
					//penny class
					case 1:
						//Adds penny value to the total balence
						totalBalence += newPenny.getValue();
						break;
						
					//Nickel class
					case 2:
						//Adds Nickel value to the total balence
						totalBalence += newNickel.getValue();
						break;
						
					//Dime class
					case 3:
						//Adds Dime value to the total balence
						totalBalence += newDime.getValue();
						break;
						
					//Quarter Class
					case 4:
						//Adds Quarter value to the total balence 
						totalBalence += newQuarter.getValue();
						break;
						
					}//End of switch statement					
				}//End of if statement
				
				//This makes the program move onto the next coin Type.
				coinType++;
				
				//This if statement will bring the coinType back to penny after quarter
				if(coinType >= 5) {
					coinType = 1;
				}//End of if statement
				
			}//End of While Loop for flipping part of game
			
			//This if else statement determines if the player won or lost the game
			if(totalBalence < 1.001 && totalBalence >= .9999) {
				JOptionPane.showMessageDialog(null, "Congragulations you won! \nYour Balence was: " + totalBalence + "$");
				JOptionPane.showInputDialog("Type r to replay. Type anything else to end program.");
			}else {
				JOptionPane.showMessageDialog(null, "You lost. \nYour Balence was: " + totalBalence + "$");
				input = JOptionPane.showInputDialog("Type r to replay. Type anything else to end program.");
				
			}//End of if statement that determines if win/loss
			
			//This if else statement will allow the user to end program or restart the program
			if(input.equals("r")) {
				totalBalence = 0.00;
			}else {
				runProgram = false;
			}//end of if else statement

		}//End of runProgram while loop
	}//End of Main 
}//End of CoinToss class
