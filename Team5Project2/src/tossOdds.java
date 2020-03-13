import java.util.Random;

public class tossOdds {

	private Random odds = new Random();
	private int result;
	
	/**
	 * The setResult method with get a random value either 0 or 1.
	 * 0. will be tails and wont add money to the totalBalence 
	 * 1. will be heads and will add money to the totalBalence 
	 * @param result stores the random value 0 or 1
	 */
	public void setResult() {
		result = odds.nextInt(2);
	}//end of setResult
	
	/**
	 * The getResult method will return a 0 or 1 value.
	 * @return The value in the result field.
	 */
	public int getResult() {
		return result;
	}//End of getResult()
}//End of tossOdds Class
