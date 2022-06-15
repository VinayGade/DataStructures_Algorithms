package stack;

public class PalindromeValidator {

	public static void main(String[] args) {
		
		String str = "abracadabra"; //madam mam mom
		
		PalindromeValidator pv = new PalindromeValidator();
		System.out.println("String "+str+" is palindrome ? "+pv.isPalindrome(str));

	}
	
	public boolean isPalindrome(String str) {
		int i=0;
		int j=str.length()-1;
		while( i <= j && str.charAt(i) == str.charAt(j) ) {
			i++;
			j--;
		}
		return (i>j);
	}

}
