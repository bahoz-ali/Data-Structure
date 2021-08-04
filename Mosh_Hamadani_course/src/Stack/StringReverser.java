package Stack;

import java.util.Stack;

public class StringReverser {
public static void main(String[] args) {
	System.out.println(reverse("kurdistan"));
}

public static String  reverse(String text) {
	if(text == null)
		throw new IllegalArgumentException();
	
	Stack<Character> stack = new Stack<>();
	for(char ch : text.toCharArray())
		stack.push(ch);

	
	StringBuffer reversed = new StringBuffer(); // awa bashtra la String a=""
	while(!stack.empty())
		reversed.append(stack.pop());
	
	return reversed.toString();
}


}
