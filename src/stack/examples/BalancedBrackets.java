package stack.examples;
import java.util.Stack;
public class BalancedBrackets {

	/*
	 * Valid parenthesis 
	 * 
	 * [{()}{()}]  valid
	 * {(){{)[    invalid
	 * 
	 * */
	
	public static void main(String[] args) {
	
		String brackets = "[{()}{()}]";

		boolean isValid = validParenthesis(brackets);
		
		System.out.println("Is Valid Paranthesis :"+isValid);
	}
	
	public static String charToString(Character ch) {
		return String.valueOf(ch);
	}
	
	public static boolean validParenthesis(String parenthesis) {
		
		String open = "[{(";
		String close = ")}]";
		
		//boolean isValid = false;
		
		int n = parenthesis.length(); 
		
		if(close.contains(charToString(parenthesis.charAt(0))) ||  
				open.contains(charToString(parenthesis.charAt(n-1))))
			return false;
		else {
			
			Stack<Character> bracketStack = new Stack<>();
			
			for(int i=0; i<n; i++) {
				char ch = parenthesis.charAt(i);
				
				if(open.contains(charToString(ch)))
					bracketStack.push(ch);
				
				else {
					if( bracketStack.peek() == '[' && (ch == ']') ||
						bracketStack.peek() == '{' && (ch == '}') || 
						bracketStack.peek() == '(' && (ch == ')') )
							bracketStack.pop();
				}
			}
			return 	bracketStack.isEmpty();
		}	
	}
}