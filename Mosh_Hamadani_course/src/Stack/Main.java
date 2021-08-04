package Stack;

public class Main {
	public static void main(String args[]) {
		Stack stack = new Stack(7);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
	
//		int poped = stack.pop();
//		System.out.println("pop: " + poped);
		
//	
//		stack.push(5);
//		int peek = stack.peek();
//		System.out.println("peek: " + peek);
		
		System.out.println(stack.toSrring());
		
	}
	
	
}
