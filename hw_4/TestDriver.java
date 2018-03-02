
public class TestDriver{

public static void main(String[] args) {
		Palindrome pr = new Palindrome();

		//Test Case 1
		String str = "Anna";
		System.out.println("Vanilla case. All lowercase and one word");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 2
		str = "";
		System.out.println("\nTesting when it is an empty string");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 3

		str = "bad dab";
		System.out.println("\nTesting 2 words. All lowercase and one space");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 4

		str = "a";
		System.out.println("\nTesting when there is only one character left");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 5

		str = "never odd or even";
		System.out.println("\nTesting a whole phrase. All lowercase and several spaces. ");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 6

		str = "ABBA";
		System.out.println("\nTesting a word that is all uppercase. ");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 7

		str = "I am Mai";
		System.out.println("\nTesting uppercase and lowercase characters");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 8

		str = "Madam, I am Adam";
		System.out.println("\nTesting phrases with non-alphanumeric characters. Will ignore");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 9

		str = "11";
		System.out.println("\nTesting numbers");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 10

		str = "aa1221aa";
		System.out.println("\nTesting numbers and lowercase characters");
		System.out.println("Expected Output: true");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 11

		str = "A123_321A";
		System.out.println("\nTesting numbers, letters, and non-alphanumeric characters");
		System.out.println("Expected Output: False");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 12

		str = "anba";
		System.out.println("\nTesting false case of lowercase characters");
		System.out.println("Expected Output: False");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 13

		str = "12345";
		System.out.println("\nTesting false case with numbers");
		System.out.println("Expected Output: False");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 14

		str = "A123BASDa";
		System.out.println("\nTesting false case with UpperCase and LowerCase with numbers");
		System.out.println("Expected Output: False");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 15

		str = "123,45";
		System.out.println("\nTesting false case with non-alphanumeric characters with numbers.");
		System.out.println("Expected Output: False");
		System.out.println(pr.checkPalindrome(str));

		//Test Case 16

		str = "123a,45b";
		System.out.println("\nTesting false case with non-alphanumeric characters with numbers");
		System.out.println("Expected Output: False");
		System.out.println(pr.checkPalindrome(str));
	}
}
