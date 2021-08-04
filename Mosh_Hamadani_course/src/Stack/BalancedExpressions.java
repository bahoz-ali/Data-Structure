package Stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpressions {
	private static final List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');
	private static final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');
	
	public static boolean IsBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		
		for ( char ch : input.toCharArray() ) {
			if ( isLeftBracket(ch) ) 
				stack.push(ch);
			
			else if( isRightBracket(ch) ) {
				if ( stack.empty() ) return false;
				
				char top = stack.pop();
				//System.out.println("pop "+ top);
     			//System.out.println("come "+ ch);
				if (!isBracketMatch(top, ch)) return false;
			}//else if
		}//for
		return stack.empty();
	}
	private static boolean isLeftBracket(char ch) {
		return leftBrackets.contains(ch) ;
	}
	private static boolean isRightBracket(char ch) {
		return rightBrackets.contains(ch) ;
	}
	private static boolean isBracketMatch(char left ,char right) {
		return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
	}

	public static void main(String[] args) {
		boolean a = IsBalanced("({}[])");
		System.out.println(a);
	}
}
