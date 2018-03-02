import java.util.ArrayList;
import java.lang.Character;

public class Palindrome {

	public Boolean checkPalindrome(String str){

		//all to lowerCase  (ie make A == a)
		str = str.toLowerCase();

		//removing white space
		str = str.replaceAll("\\s+","");

		//removes non-alphanumeric characters
		str = str.replaceAll("[^a-zA-Z0-9]", "");



		int i = 0;
		int l = str.length() - 1;

		//Boolean returning if it true and false
		boolean isPal = true;

		while (i < l) {
			//first character of string
			String start = str.substring(i, i + 1);
			//last character of string
			String end = str.substring(l, l + 1);

			//check is if the 2 characters are the same
			if (start.equals(end) == false) {
				//if they are different return False(not a palindrone)
				isPal = false;
				break;
			}
			//i goes up the string
			i++;
			//goes down the string
			l--;
		}
		return isPal;
		}
}
