package stack.examples;
import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {

		String invalid = "{[])}{[()}[";
		
		String valid = "[[{()}][()][{()()}{{}}]]";
		
		BalancedParenthesis parenthesis = new BalancedParenthesis();
		
		System.out.println("Parenthesis1 ="+invalid+" is valid ? "+ parenthesis.isValid(invalid));

		System.out.println("Parenthesis2 ="+valid+" is valid ? "+ parenthesis.isValid(valid));
	}

	public boolean isValid(String expression) {

		//sequence of opening parenthesis according to its precedence
		//i.e. '[' has higher precedence than '{' or '('
		String openingParenthesis="[{(";

		//sequence of closing parenthesis according to its precedence
		String closingParenthesis=")}]";

		//Stack will be pushed on opening parenthesis and popped on closing.
		Stack<Character> parenthesisStack=new Stack<>();


		/*For expression to be valid :
          CHECK :
          1. it must start with opening parenthesis [()...
          2. precedence of parenthesis  should be proper (eg. "{[" invalid  
                                                              "[{(" valid  ) 


          3. matching pair if(  '(' => ')')  i.e. [{()}(())] ->valid [{)]not 
		 */

		String start = ((Character)expression.charAt(0)).toString();
		String end = ((Character)expression.charAt(expression.length()-1)).toString();
		
		if(closingParenthesis.contains(start) || openingParenthesis.contains(end))
			return false;
		
		else{

			for(int i=0;i<expression.length();i++){

				char ch = (Character)expression.charAt(i);
				String s = String.valueOf(ch);
				
				//if parenthesis is opening(ie any of '[','{','(') push on stack
				
				if(openingParenthesis.contains(s)){
					parenthesisStack.push(ch);
					
				}else if(closingParenthesis.contains(s)){

					//if parenthesis is closing (ie any of ']','}',')') pop stack
					//depending upon check-3 
					if(parenthesisStack.peek()=='(' && (ch==')') || 
							parenthesisStack.peek()=='{' && (ch=='}') ||    
							parenthesisStack.peek()=='[' && (ch==']')
							){
						parenthesisStack.pop();
					}
				}
			}
			return parenthesisStack.isEmpty();
		}
	}
}

